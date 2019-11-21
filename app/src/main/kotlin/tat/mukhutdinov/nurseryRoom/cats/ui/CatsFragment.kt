package tat.mukhutdinov.nurseryRoom.cats.ui

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.sharedViewModel
import tat.mukhutdinov.nurseryRoom.R
import tat.mukhutdinov.nurseryRoom.cats.redux.CatsAction
import tat.mukhutdinov.nurseryRoom.cats.redux.CatsState
import tat.mukhutdinov.nurseryRoom.cats.redux.boundary.CatsReducer
import tat.mukhutdinov.nurseryRoom.cats.ui.recycler.MastersWithCatsAdapter
import tat.mukhutdinov.nurseryRoom.databinding.CatsBinding
import tat.mukhutdinov.nurseryRoom.infrastructure.structure.BaseFragment
import tat.mukhutdinov.nurseryRoom.pet.ui.PetSharedViewModel

class CatsFragment : BaseFragment<CatsBinding>(), CatsBindings {

    override val layoutId: Int = R.layout.cats

    private val reducer: CatsReducer by inject()

    private val petSharedViewModel: PetSharedViewModel by sharedViewModel()

    private var state = CatsState()
    private var observeMasterWithCatsJob: Job? = null

    private lateinit var adapter: MastersWithCatsAdapter

    @FlowPreview
    @ExperimentalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAdapter()

        viewScope.launch {
            reducer.states.asFlow().collect {
                setState(it)
            }
        }

        viewScope.launch {
            reducer.intent(state, CatsAction.OnViewCreated)
        }

        petSharedViewModel.selectedMasterIdToPetId.observe(viewLifecycleOwner, Observer {
            viewScope.launch {
                reducer.intent(state, CatsAction.Pet(it.first, it.second))
            }
        })
    }

    private fun setupAdapter() {
        adapter = MastersWithCatsAdapter()

        viewBinding.list.adapter = adapter
        viewBinding.list.setHasFixedSize(true)
    }

    private fun setState(newState: CatsState) {
        observeMasterWithCatsJob?.cancel()
        state = newState

        observeMasterWithCatsJob = viewScope.launch {
            state.mastersWithCats.collect {
                adapter.submitList(it)
            }
        }

        if (state.shouldShowPetDialog) {
            findNavController().navigate(
                CatsFragmentDirections.toPet(
                    state.masters.toTypedArray(),
                    state.cats.toTypedArray()
                )
            )
        }
    }

    override fun onAddClicked() {
        viewScope.launch {
            reducer.intent(state, CatsAction.ChoosePet)
        }
    }
}