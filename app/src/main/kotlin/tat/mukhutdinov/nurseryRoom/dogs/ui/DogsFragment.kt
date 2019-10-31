package tat.mukhutdinov.nurseryRoom.dogs.ui

import android.os.Bundle
import android.view.View
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import tat.mukhutdinov.nurseryRoom.R
import tat.mukhutdinov.nurseryRoom.databinding.DogsBinding
import tat.mukhutdinov.nurseryRoom.dogs.domain.model.MasterWithDogs
import tat.mukhutdinov.nurseryRoom.dogs.redux.DogsAction
import tat.mukhutdinov.nurseryRoom.dogs.redux.DogsState
import tat.mukhutdinov.nurseryRoom.dogs.ui.boundary.DogsReducer
import tat.mukhutdinov.nurseryRoom.infrastructure.structure.BaseFragment

@ExperimentalCoroutinesApi
class DogsFragment : BaseFragment<DogsBinding>(), DogsBindings {

    override val layoutId: Int = R.layout.dogs

    override val mastersWithDogs = MutableLiveData<List<MasterWithDogs>>()

    private val reducer: DogsReducer by inject()

    private var state = DogsState()

    @ExperimentalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mastersWithDogs.value = state.mastersWithDogs

        viewScope.launch {
            reducer.intent(DogsAction.OnViewCreated)

            reducer.states.consumeEach {
                state = it

                mastersWithDogs.value = state.mastersWithDogs
            }
        }
    }
}