package tat.mukhutdinov.nurseryRoom.cats.redux

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel.Factory.CONFLATED
import tat.mukhutdinov.nurseryRoom.cats.domain.boundary.CatsDomain
import tat.mukhutdinov.nurseryRoom.cats.redux.boundary.CatsReducer

@ExperimentalCoroutinesApi
class CatsStateReducer(private val domain: CatsDomain) : CatsReducer {

    override val states = BroadcastChannel<CatsState>(CONFLATED)

    override suspend fun intent(currentState: CatsState, action: CatsAction) =
        when (action) {
            CatsAction.OnViewCreated -> {
                val items = domain.getMastersWithCats()
                states.send(
                    CatsState(
                        shouldShowPetDialog = currentState.shouldShowPetDialog,
                        cats = currentState.cats,
                        masters = currentState.masters,
                        mastersWithCats = items
                    )
                )
            }

            CatsAction.ChoosePet -> {
                val masters = domain.getMasterParticipants()
                val cats = domain.getCatParticipants()

                states.send(
                    CatsState(
                        shouldShowPetDialog = true,
                        cats = cats,
                        masters = masters,
                        mastersWithCats = currentState.mastersWithCats
                    )
                )
            }

            is CatsAction.Pet -> {
                domain.pet(action.masterId, action.catId)
            }
        }
}