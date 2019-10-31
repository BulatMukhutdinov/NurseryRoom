package tat.mukhutdinov.nurseryRoom.home.redux

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.CONFLATED
import tat.mukhutdinov.nurseryRoom.home.ui.HomeFragmentDirections
import tat.mukhutdinov.nurseryRoom.home.ui.boundary.HomeReducer

class HomeStateReducer : HomeReducer {

    override val states = Channel<HomeState>(CONFLATED)

    override suspend fun intent(action: HomeAction) =
        when (action) {
            HomeAction.ShowDogs -> states.send(HomeState(HomeFragmentDirections.toDogs()))
            HomeAction.ShowCats -> states.send(HomeState(HomeFragmentDirections.toCats()))
        }
}