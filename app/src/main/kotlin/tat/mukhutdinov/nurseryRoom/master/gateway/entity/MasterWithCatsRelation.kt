package tat.mukhutdinov.nurseryRoom.master.gateway.entity

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import tat.mukhutdinov.nurseryRoom.cats.gateway.entity.CatEntity
import tat.mukhutdinov.nurseryRoom.cats.gateway.entity.CatWithMasterEntity

data class MasterWithCatsRelation(
    @Embedded
    val master: MasterEntity,
    @Relation(
        parentColumn = MasterEntity.COLUMN_ID,
        entityColumn = CatEntity.COLUMN_ID,
        entity = CatEntity::class,
        associateBy = Junction(
            value = CatWithMasterEntity::class,
            entityColumn = CatWithMasterEntity.COLUMN_MASTER_ID,
            parentColumn = CatWithMasterEntity.COLUMN_CAT_ID
        )
    )
    val cats: List<CatEntity>
)