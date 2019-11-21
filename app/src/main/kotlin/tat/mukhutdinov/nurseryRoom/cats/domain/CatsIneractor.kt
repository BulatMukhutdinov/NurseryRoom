package tat.mukhutdinov.nurseryRoom.cats.domain

import kotlinx.coroutines.flow.Flow
import tat.mukhutdinov.nurseryRoom.cats.domain.boundary.CatGateway
import tat.mukhutdinov.nurseryRoom.cats.domain.boundary.CatsDomain
import tat.mukhutdinov.nurseryRoom.cats.domain.model.MasterWithCats
import tat.mukhutdinov.nurseryRoom.master.domain.boundary.MasterGateway
import tat.mukhutdinov.nurseryRoom.pet.domain.model.PetParticipant

class CatsIneractor(
    private val catGateway: CatGateway,
    private val masterGateway: MasterGateway
) : CatsDomain {

    override fun getMastersWithCats(): Flow<List<MasterWithCats>> =
        masterGateway.getMastersWithCats()

    override suspend fun getMasterParticipants(): List<PetParticipant> =
        masterGateway.getAll()
            .map { PetParticipant(it.name, it.id) }

    override suspend fun getCatParticipants(): List<PetParticipant> =
        catGateway.getAll()
            .map { PetParticipant(it.name, it.id) }

    override suspend fun pet(masterId: Long, catId: Long) =
        catGateway.pet(masterId, catId)
}