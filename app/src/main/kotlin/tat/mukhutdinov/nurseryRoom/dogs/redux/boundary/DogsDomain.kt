package tat.mukhutdinov.nurseryRoom.dogs.redux.boundary

import tat.mukhutdinov.nurseryRoom.dogs.domain.model.MasterWithDogs

interface DogsDomain {

    suspend fun getMastersWithDogs(): List<MasterWithDogs>
}