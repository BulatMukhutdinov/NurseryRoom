package tat.mukhutdinov.nurseryRoom.master.domain.boundary

import kotlinx.coroutines.flow.Flow
import tat.mukhutdinov.nurseryRoom.cats.domain.model.MasterWithCats
import tat.mukhutdinov.nurseryRoom.dogs.domain.model.MasterWithDogs
import tat.mukhutdinov.nurseryRoom.master.domain.model.Master

interface MasterGateway {

    fun getMastersWithDogs(): Flow<List<MasterWithDogs>>

    fun getMastersWithCats(): Flow<List<MasterWithCats>>

    suspend fun getAll(): List<Master>
}