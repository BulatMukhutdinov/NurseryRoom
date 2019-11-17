package tat.mukhutdinov.nurseryRoom.master.gateway.entity

import tat.mukhutdinov.nurseryRoom.dogs.domain.model.Dog
import tat.mukhutdinov.nurseryRoom.dogs.domain.model.MasterWithDogs
import tat.mukhutdinov.nurseryRoom.dogs.gateway.entity.DogEntity
import tat.mukhutdinov.nurseryRoom.master.domain.model.Master

class MasterConverter {

    fun convert(master: MasterEntity) =
        Master(
            id = master.id,
            name = master.name
        )

    fun convert(relation: MasterWithDogsRelation) =
        MasterWithDogs(
            master = convert(relation.master),
            dogs = relation.dogs
                .map { convert(it, relation.master) }
        )

    private fun convert(dog: DogEntity, master: MasterEntity) =
        Dog(
            id = dog.id,
            name = dog.name,
            master = convert(master)
        )

}