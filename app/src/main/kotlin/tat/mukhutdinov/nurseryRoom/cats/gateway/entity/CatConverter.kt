package tat.mukhutdinov.nurseryRoom.cats.gateway.entity

import tat.mukhutdinov.nurseryRoom.cats.domain.model.Cat

class CatConverter {

    fun convert(entity: CatEntity): Cat =
        Cat(
            id = entity.id,
            name = entity.name
        )
}