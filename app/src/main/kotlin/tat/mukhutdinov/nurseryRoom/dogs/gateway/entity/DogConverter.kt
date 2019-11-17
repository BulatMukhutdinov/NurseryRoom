package tat.mukhutdinov.nurseryRoom.dogs.gateway.entity

import tat.mukhutdinov.nurseryRoom.dogs.domain.model.Dog
import tat.mukhutdinov.nurseryRoom.master.gateway.entity.MasterConverter

class DogConverter(private val masterConverter: MasterConverter) {

    fun convert(relation: DogWithMasterRelation) =
        Dog(
            id = relation.dog.id,
            name = relation.dog.name,
            master = if (relation.master == null) {
                null
            } else {
                masterConverter.convert(relation.master)
            }
        )
}