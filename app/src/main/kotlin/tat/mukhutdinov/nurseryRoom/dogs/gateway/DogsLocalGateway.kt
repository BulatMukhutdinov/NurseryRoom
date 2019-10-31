package tat.mukhutdinov.nurseryRoom.dogs.gateway

import tat.mukhutdinov.nurseryRoom.dogs.domain.boundary.DogsGateway
import tat.mukhutdinov.nurseryRoom.dogs.domain.model.MasterWithDogs
import tat.mukhutdinov.nurseryRoom.dogs.gateway.boundary.DogDao
import tat.mukhutdinov.nurseryRoom.dogs.gateway.entity.DogsConverter

class DogsLocalGateway(private val dao: DogDao, private val converter: DogsConverter) : DogsGateway {

    override suspend fun getMastersWithDogs(): List<MasterWithDogs> =
        dao.getMasterWithDogs()
            .map(converter::convert)
}