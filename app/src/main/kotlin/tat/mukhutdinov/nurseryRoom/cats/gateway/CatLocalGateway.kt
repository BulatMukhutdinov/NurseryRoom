package tat.mukhutdinov.nurseryRoom.cats.gateway

import tat.mukhutdinov.nurseryRoom.cats.domain.boundary.CatGateway
import tat.mukhutdinov.nurseryRoom.cats.domain.model.Cat
import tat.mukhutdinov.nurseryRoom.cats.gateway.boundary.CatDao
import tat.mukhutdinov.nurseryRoom.cats.gateway.entity.CatConverter
import tat.mukhutdinov.nurseryRoom.cats.gateway.entity.CatWithMasterEntity

class CatLocalGateway(private val dao: CatDao, private val converter: CatConverter) : CatGateway {

    override suspend fun getAll(): List<Cat> =
        dao.getAll()
            .map(converter::convert)

    override suspend fun pet(masterId: Long, catId: Long) {
        val catWithMaster = CatWithMasterEntity(
            masterId = masterId,
            catId = catId
        )

        dao.insert(catWithMaster)
    }
}