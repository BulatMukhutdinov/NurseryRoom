package tat.mukhutdinov.nurseryRoom.master.gateway.entity

import androidx.room.Embedded
import androidx.room.Relation
import tat.mukhutdinov.nurseryRoom.dogs.gateway.entity.DogEntity

data class MasterWithDogsRelation(
    @Embedded
    val master: MasterEntity,
    @Relation(
        parentColumn = MasterEntity.COLUMN_ID,
        entityColumn = DogEntity.COLUMN_MASTER_ID,
        entity = DogEntity::class
    )
    val dogs: List<DogEntity>
)