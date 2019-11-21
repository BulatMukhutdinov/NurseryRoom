package tat.mukhutdinov.nurseryRoom.cats.gateway.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import tat.mukhutdinov.nurseryRoom.cats.gateway.entity.CatWithMasterEntity.Companion.COLUMN_CAT_ID
import tat.mukhutdinov.nurseryRoom.cats.gateway.entity.CatWithMasterEntity.Companion.COLUMN_MASTER_ID
import tat.mukhutdinov.nurseryRoom.cats.gateway.entity.CatWithMasterEntity.Companion.TABLE_NAME
import tat.mukhutdinov.nurseryRoom.master.gateway.entity.MasterEntity

@Entity(
    tableName = TABLE_NAME,
    primaryKeys = [COLUMN_CAT_ID, COLUMN_MASTER_ID],
    foreignKeys = [
        ForeignKey(
            entity = CatEntity::class,
            parentColumns = [CatEntity.COLUMN_ID],
            childColumns = [COLUMN_CAT_ID]
        ),
        ForeignKey(
            entity = MasterEntity::class,
            parentColumns = [MasterEntity.COLUMN_ID],
            childColumns = [COLUMN_MASTER_ID]
        )
    ]
)
data class CatWithMasterEntity(
    @ColumnInfo(name = COLUMN_CAT_ID)
    val catId: Long,
    @ColumnInfo(name = COLUMN_MASTER_ID)
    val masterId: Long
) {

    companion object {
        const val TABLE_NAME = "catWithMaster"
        const val COLUMN_CAT_ID = "catId"
        const val COLUMN_MASTER_ID = "masterId"
    }
}