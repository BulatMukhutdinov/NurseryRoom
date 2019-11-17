package tat.mukhutdinov.nurseryRoom.dogs.domain.boundary

import tat.mukhutdinov.nurseryRoom.dogs.domain.model.Dog

interface DogGateway {

    suspend fun getAll(): List<Dog>

    suspend fun getById(id: Long): Dog

    suspend fun pet(masterId: Long, dogId: Long)
}