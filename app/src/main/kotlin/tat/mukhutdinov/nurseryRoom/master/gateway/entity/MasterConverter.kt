package tat.mukhutdinov.nurseryRoom.master.gateway.entity

import tat.mukhutdinov.nurseryRoom.cats.domain.model.MasterWithCats
import tat.mukhutdinov.nurseryRoom.cats.gateway.entity.CatConverter
import tat.mukhutdinov.nurseryRoom.dogs.domain.model.Dog
import tat.mukhutdinov.nurseryRoom.dogs.domain.model.MasterWithDogs
import tat.mukhutdinov.nurseryRoom.dogs.gateway.entity.DogEntity
import tat.mukhutdinov.nurseryRoom.master.domain.model.Master

class MasterConverter(private val catConverter: CatConverter) {

    fun convert(master: MasterEntity) =
        Master(
            id = master.id,
            name = master.name
        )

    fun convert(relation: MasterWithCatsRelation): MasterWithCats =
        MasterWithCats(
            master = convert(relation.master),
            cats = relation.cats
                .map(catConverter::convert)
        )

    fun convert(relation: MasterWithDogsRelation): MasterWithDogs =
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