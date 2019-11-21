package tat.mukhutdinov.nurseryRoom.cats.domain.boundary

import tat.mukhutdinov.nurseryRoom.cats.domain.model.Cat

interface CatGateway {

    suspend fun getAll(): List<Cat>

    suspend fun pet(masterId: Long, catId: Long)
}