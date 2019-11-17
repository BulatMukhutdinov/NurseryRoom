package tat.mukhutdinov.nurseryRoom.dogs.domain

import kotlinx.coroutines.flow.Flow
import tat.mukhutdinov.nurseryRoom.dogs.domain.boundary.DogGateway
import tat.mukhutdinov.nurseryRoom.dogs.domain.boundary.DogsDomain
import tat.mukhutdinov.nurseryRoom.dogs.domain.model.MasterWithDogs
import tat.mukhutdinov.nurseryRoom.master.domain.boundary.MasterGateway
import tat.mukhutdinov.nurseryRoom.pet.domain.model.PetParticipant

class DogsInteractor(
    private val dogGateway: DogGateway,
    private val masterGateway: MasterGateway
) : DogsDomain {

    override suspend fun pet(masterId: Long, dogId: Long) =
        dogGateway.pet(masterId, dogId)

    override suspend fun getMasterParticipants(): List<PetParticipant> =
        masterGateway.getAll()
            .map { PetParticipant(it.name, it.id) }

    override suspend fun getDogParticipants(): List<PetParticipant> =
        dogGateway.getAll()
            .filter { it.master == null }
            .map { PetParticipant(it.name, it.id) }

    override fun getMastersWithDogs(): Flow<List<MasterWithDogs>> =
        masterGateway.getMastersWithDogs()
}