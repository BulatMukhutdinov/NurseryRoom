package tat.mukhutdinov.nurseryRoom.master.gateway

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import tat.mukhutdinov.nurseryRoom.cats.domain.model.MasterWithCats
import tat.mukhutdinov.nurseryRoom.dogs.domain.model.MasterWithDogs
import tat.mukhutdinov.nurseryRoom.master.domain.boundary.MasterGateway
import tat.mukhutdinov.nurseryRoom.master.domain.model.Master
import tat.mukhutdinov.nurseryRoom.master.gateway.boundary.MasterDao
import tat.mukhutdinov.nurseryRoom.master.gateway.entity.MasterConverter

class MasterLocalGateway(private val dao: MasterDao, private val converter: MasterConverter) : MasterGateway {

    override suspend fun getAll(): List<Master> =
        dao.getAll()
            .map(converter::convert)

    override fun getMastersWithDogs(): Flow<List<MasterWithDogs>> =
        dao.getMastersWithDogs()
            .map { it.map(converter::convert) }

    override fun getMastersWithCats(): Flow<List<MasterWithCats>> =
        dao.getMastersWithCats()
            .map { it.map(converter::convert) }
}