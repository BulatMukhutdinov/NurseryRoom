package tat.mukhutdinov.nurseryRoom.master.gateway.entity

import tat.mukhutdinov.nurseryRoom.master.domain.model.Master

class MasterConverter {

    fun convert(master: MasterEntity) =
        Master(
            id = master.id,
            name = master.name
        )
}