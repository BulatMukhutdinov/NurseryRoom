package tat.mukhutdinov.nurseryRoom.dogs.gateway.entity

import androidx.room.Embedded
import androidx.room.Relation
import tat.mukhutdinov.nurseryRoom.master.gateway.entity.MasterEntity

data class DogWithMasterRelation(
    @Embedded
    val dog: DogEntity,
    @Relation(
        parentColumn = DogEntity.COLUMN_MASTER_ID,
        entityColumn = MasterEntity.COLUMN_ID,
        entity = MasterEntity::class
    )
    val master: MasterEntity?
)