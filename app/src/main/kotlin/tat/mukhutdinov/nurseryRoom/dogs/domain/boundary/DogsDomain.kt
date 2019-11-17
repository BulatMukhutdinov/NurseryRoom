package tat.mukhutdinov.nurseryRoom.dogs.domain.boundary

import kotlinx.coroutines.flow.Flow
import tat.mukhutdinov.nurseryRoom.dogs.domain.model.MasterWithDogs
import tat.mukhutdinov.nurseryRoom.pet.domain.model.PetParticipant

interface DogsDomain {

    fun getMastersWithDogs(): Flow<List<MasterWithDogs>>

    suspend fun getMasterParticipants(): List<PetParticipant>

    suspend fun getDogParticipants(): List<PetParticipant>

    suspend fun pet(masterId: Long, dogId: Long)
}