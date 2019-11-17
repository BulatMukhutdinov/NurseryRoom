package tat.mukhutdinov.nurseryRoom.dogs.redux

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import tat.mukhutdinov.nurseryRoom.dogs.domain.model.MasterWithDogs
import tat.mukhutdinov.nurseryRoom.pet.domain.model.PetParticipant

data class DogsState(
    val shouldShowPetDialog: Boolean = false,
    // In current app there is no need to make 'observable' list of data since nobody from outside changes the data.
    // But for example purposes it is made a flow intentionally to simulate situation described above
    val mastersWithDogs: Flow<List<MasterWithDogs>> = emptyFlow(),
    val masters: List<PetParticipant> = emptyList(),
    val dogs: List<PetParticipant> = emptyList()
)