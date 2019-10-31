package tat.mukhutdinov.nurseryRoom.dogs.domain.boundary

import tat.mukhutdinov.nurseryRoom.dogs.domain.model.MasterWithDogs

interface DogsGateway {

    suspend fun getMastersWithDogs(): List<MasterWithDogs>
}