package tat.mukhutdinov.nurseryRoom.dogs.redux

import kotlinx.coroutines.channels.ReceiveChannel
import tat.mukhutdinov.nurseryRoom.dogs.redux.boundary.DogsDomain
import tat.mukhutdinov.nurseryRoom.dogs.ui.boundary.DogsReducer

class DogsStateReducer(private val domain: DogsDomain) : DogsReducer {

    override val states: ReceiveChannel<DogsState>
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override suspend fun intent(action: DogsAction) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}