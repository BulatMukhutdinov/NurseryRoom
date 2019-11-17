package tat.mukhutdinov.nurseryRoom.dogs.gateway

import tat.mukhutdinov.nurseryRoom.dogs.domain.boundary.DogGateway
import tat.mukhutdinov.nurseryRoom.dogs.domain.model.Dog
import tat.mukhutdinov.nurseryRoom.dogs.gateway.boundary.DogDao
import tat.mukhutdinov.nurseryRoom.dogs.gateway.entity.DogConverter

class DogLocalGateway(private val dao: DogDao, private val converter: DogConverter) : DogGateway {

    override suspend fun getById(id: Long): Dog =
        dao.getDogWithMasterById(id)
            .let(converter::convert)

    override suspend fun pet(masterId: Long, dogId: Long) {
        val dog = dao.getDogById(dogId)
        val updated = dog.copy(masterId = masterId)

        dao.update(updated)
    }

    override suspend fun getAll(): List<Dog> =
        dao.getDogsWithMaster()
            .map(converter::convert)
}