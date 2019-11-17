package tat.mukhutdinov.nurseryRoom.master.domain.boundary

import kotlinx.coroutines.flow.Flow
import tat.mukhutdinov.nurseryRoom.dogs.domain.model.MasterWithDogs
import tat.mukhutdinov.nurseryRoom.master.domain.model.Master

interface MasterGateway {

    fun getMastersWithDogs(): Flow<List<MasterWithDogs>>

    suspend fun getAll(): List<Master>
}