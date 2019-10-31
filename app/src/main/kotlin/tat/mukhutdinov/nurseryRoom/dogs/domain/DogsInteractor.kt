package tat.mukhutdinov.nurseryRoom.dogs.domain

import tat.mukhutdinov.nurseryRoom.dogs.domain.boundary.DogsGateway
import tat.mukhutdinov.nurseryRoom.dogs.domain.model.MasterWithDogs
import tat.mukhutdinov.nurseryRoom.dogs.redux.boundary.DogsDomain

class DogsInteractor(private val gateway: DogsGateway) : DogsDomain {

    override suspend fun getMastersWithDogs(): List<MasterWithDogs> =
        gateway.getMastersWithDogs()
}