package tat.mukhutdinov.nurseryRoom.home.ui.boundary

import kotlinx.coroutines.channels.ReceiveChannel
import tat.mukhutdinov.nurseryRoom.home.redux.HomeAction
import tat.mukhutdinov.nurseryRoom.home.redux.HomeState

interface HomeReducer {

    val states: ReceiveChannel<HomeState>

    suspend fun intent(action: HomeAction)
}