package tat.mukhutdinov.nurseryRoom.dogs.redux

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel.Factory.CONFLATED
import tat.mukhutdinov.nurseryRoom.dogs.domain.boundary.DogsDomain
import tat.mukhutdinov.nurseryRoom.dogs.redux.boundary.DogsReducer

@ExperimentalCoroutinesApi
class DogsStateReducer(private val domain: DogsDomain) : DogsReducer {

    override val states = BroadcastChannel<DogsState>(CONFLATED)

    override suspend fun intent(currentState: DogsState, action: DogsAction) =
        when (action) {
            DogsAction.OnViewCreated -> {
                val items = domain.getMastersWithDogs()
                states.send(
                    DogsState(
                        shouldShowPetDialog = currentState.shouldShowPetDialog,
                        dogs = currentState.dogs,
                        masters = currentState.masters,
                        mastersWithDogs = items
                    )
                )
            }

            DogsAction.ChoosePet -> {
                val masters = domain.getMasterParticipants()
                val dogs = domain.getDogParticipants()

                states.send(
                    DogsState(
                        shouldShowPetDialog = true,
                        dogs = dogs,
                        masters = masters,
                        mastersWithDogs = currentState.mastersWithDogs
                    )
                )
            }

            is DogsAction.Pet -> {
                domain.pet(action.masterId, action.dogId)
            }
        }
}