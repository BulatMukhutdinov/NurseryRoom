package tat.mukhutdinov.nurseryRoom.cats.domain.boundary

import kotlinx.coroutines.flow.Flow
import tat.mukhutdinov.nurseryRoom.cats.domain.model.MasterWithCats
import tat.mukhutdinov.nurseryRoom.pet.domain.model.PetParticipant

interface CatsDomain {

    fun getMastersWithCats(): Flow<List<MasterWithCats>>

    suspend fun getMasterParticipants(): List<PetParticipant>

    suspend fun getCatParticipants(): List<PetParticipant>

    suspend fun pet(masterId: Long, catId: Long)
}