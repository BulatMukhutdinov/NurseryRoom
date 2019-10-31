package tat.mukhutdinov.nurseryRoom.home.ui

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import tat.mukhutdinov.nurseryRoom.R
import tat.mukhutdinov.nurseryRoom.databinding.HomeBinding
import tat.mukhutdinov.nurseryRoom.home.redux.HomeAction
import tat.mukhutdinov.nurseryRoom.home.ui.boundary.HomeReducer
import tat.mukhutdinov.nurseryRoom.infrastructure.structure.BaseFragment

@ExperimentalCoroutinesApi
class HomeFragment : BaseFragment<HomeBinding>(), HomeBindings {

    override val layoutId: Int = R.layout.home

    private val reducer: HomeReducer by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewScope.launch {
            reducer.states.consumeEach {
                findNavController().navigate(it.direction)
            }
        }
    }

    override fun onDogsClicked() {
        viewScope.launch { reducer.intent(HomeAction.ShowDogs) }
    }

    override fun onCatsClicked() {
        viewScope.launch { reducer.intent(HomeAction.ShowDogs) }
    }
}