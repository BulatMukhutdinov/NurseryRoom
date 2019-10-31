package tat.mukhutdinov.nurseryRoom.dogs.gateway.entity

import tat.mukhutdinov.nurseryRoom.dogs.domain.model.Dog
import tat.mukhutdinov.nurseryRoom.dogs.domain.model.MasterWithDogs
import tat.mukhutdinov.nurseryRoom.master.gateway.entity.MasterConverter

class DogsConverter(private val masterConverter: MasterConverter) {

    fun convert(dog: DogEntity) =
        Dog(
            id = dog.id,
            name = dog.name
        )

    fun convert(relation: MasterWithDogsRelation) =
        MasterWithDogs(
            master = masterConverter.convert(relation.master),
            dogs = relation.dogs.map(::convert)
        )
}