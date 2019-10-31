package tat.mukhutdinov.nurseryRoom.dogs.ui.boundary

import kotlinx.coroutines.channels.ReceiveChannel
import tat.mukhutdinov.nurseryRoom.dogs.redux.DogsAction
import tat.mukhutdinov.nurseryRoom.dogs.redux.DogsState

interface DogsReducer {

    val states: ReceiveChannel<DogsState>

    suspend fun intent(action: DogsAction)
}