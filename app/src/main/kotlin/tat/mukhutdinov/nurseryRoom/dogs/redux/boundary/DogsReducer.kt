package tat.mukhutdinov.nurseryRoom.dogs.redux.boundary

import kotlinx.coroutines.channels.BroadcastChannel
import tat.mukhutdinov.nurseryRoom.dogs.redux.DogsAction
import tat.mukhutdinov.nurseryRoom.dogs.redux.DogsState

interface DogsReducer {

    val states: BroadcastChannel<DogsState>

    suspend fun intent(currentState: DogsState, action: DogsAction)
}