package tat.mukhutdinov.nurseryRoom.dogs.ui

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
import tat.mukhutdinov.nurseryRoom.databinding.DogsBinding
import tat.mukhutdinov.nurseryRoom.dogs.redux.DogsAction
import tat.mukhutdinov.nurseryRoom.dogs.redux.DogsState
import tat.mukhutdinov.nurseryRoom.dogs.redux.boundary.DogsReducer
import tat.mukhutdinov.nurseryRoom.dogs.ui.recycler.MastersWithDogsAdapter
import tat.mukhutdinov.nurseryRoom.infrastructure.structure.BaseFragment
import tat.mukhutdinov.nurseryRoom.pet.ui.PetSharedViewModel

@ExperimentalCoroutinesApi
class DogsFragment : BaseFragment<DogsBinding>(), DogsBindings {

    override val layoutId: Int = R.layout.dogs

    private val reducer: DogsReducer by inject()

    private val petSharedViewModel: PetSharedViewModel by sharedViewModel()

    private var state = DogsState()
    private var observeMasterWithDogsJob: Job? = null

    private lateinit var adapter: MastersWithDogsAdapter

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
            reducer.intent(state, DogsAction.OnViewCreated)
        }

        petSharedViewModel.selectedMasterIdToPetId.observe(viewLifecycleOwner, Observer {
            viewScope.launch {
                reducer.intent(state, DogsAction.Pet(it.first, it.second))
            }
        })
    }

    private fun setupAdapter() {
        adapter = MastersWithDogsAdapter()

        viewBinding.list.adapter = adapter
        viewBinding.list.setHasFixedSize(true)
    }

    private fun setState(newState: DogsState) {
        observeMasterWithDogsJob?.cancel()
        state = newState

        observeMasterWithDogsJob = viewScope.launch {
            state.mastersWithDogs.collect {
                adapter.submitList(it)
            }
        }

        if (state.shouldShowPetDialog) {
            findNavController().navigate(
                DogsFragmentDirections.toPet(
                    state.masters.toTypedArray(),
                    state.dogs.toTypedArray()
                )
            )
        }
    }

    override fun onAddClicked() {
        viewScope.launch {
            reducer.intent(state, DogsAction.ChoosePet)
        }
    }
}