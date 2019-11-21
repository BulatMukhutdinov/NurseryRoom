package tat.mukhutdinov.nurseryRoom.cats.redux.boundary

import kotlinx.coroutines.channels.BroadcastChannel
import tat.mukhutdinov.nurseryRoom.cats.redux.CatsAction
import tat.mukhutdinov.nurseryRoom.cats.redux.CatsState

interface CatsReducer {

    val states: BroadcastChannel<CatsState>

    suspend fun intent(currentState: CatsState, action: CatsAction)
}