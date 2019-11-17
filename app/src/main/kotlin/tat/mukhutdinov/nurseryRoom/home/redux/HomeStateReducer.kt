package tat.mukhutdinov.nurseryRoom.home.redux

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.BroadcastChannel
import tat.mukhutdinov.nurseryRoom.home.redux.boundary.HomeReducer
import tat.mukhutdinov.nurseryRoom.home.ui.HomeFragmentDirections

@ExperimentalCoroutinesApi
class HomeStateReducer : HomeReducer {

    override val states = BroadcastChannel<HomeState>(1)

    override suspend fun intent(action: HomeAction) =
        when (action) {
            HomeAction.ShowDogs -> states.send(HomeState(HomeFragmentDirections.toDogs()))
            HomeAction.ShowCats -> states.send(HomeState(HomeFragmentDirections.toCats()))
        }
}