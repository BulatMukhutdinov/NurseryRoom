package tat.mukhutdinov.nurseryRoom.cats.gateway.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import tat.mukhutdinov.nurseryRoom.cats.gateway.entity.CatEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class CatEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ID)
    val id: Long,
    @ColumnInfo(name = COLUMN_NAME)
    val name: String
) {

    companion object {
        const val TABLE_NAME = "cat"
        const val COLUMN_ID = "id"
        const val COLUMN_NAME = "name"
    }
}