package tat.mukhutdinov.nurseryRoom.home.redux.boundary

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.BroadcastChannel
import tat.mukhutdinov.nurseryRoom.home.redux.HomeAction
import tat.mukhutdinov.nurseryRoom.home.redux.HomeState

interface HomeReducer {

    @ExperimentalCoroutinesApi
    val states: BroadcastChannel<HomeState>

    suspend fun intent(action: HomeAction)
}