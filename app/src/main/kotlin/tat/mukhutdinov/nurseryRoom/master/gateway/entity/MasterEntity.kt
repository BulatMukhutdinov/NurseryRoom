package tat.mukhutdinov.nurseryRoom.master.gateway.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import tat.mukhutdinov.nurseryRoom.master.gateway.entity.MasterEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class MasterEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ID)
    val id: Long,
    @ColumnInfo(name = COLUMN_NAME)
    val name: String
) {

    companion object {
        const val TABLE_NAME = "master"
        const val COLUMN_ID = "id"
        const val COLUMN_NAME = "name"
    }
}