package tat.mukhutdinov.nurseryRoom.cats.redux

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import tat.mukhutdinov.nurseryRoom.cats.domain.model.MasterWithCats
import tat.mukhutdinov.nurseryRoom.pet.domain.model.PetParticipant

data class CatsState(
    val shouldShowPetDialog: Boolean = false,
    // In current app there is no need to make 'observable' list of data since nobody from outside changes the data.
    // But for example purposes it is made a flow intentionally to simulate situation described above
    val mastersWithCats: Flow<List<MasterWithCats>> = emptyFlow(),
    val masters: List<PetParticipant> = emptyList(),
    val cats: List<PetParticipant> = emptyList()
)