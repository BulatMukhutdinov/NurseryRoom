package tat.mukhutdinov.nurseryRoom.dogs.gateway.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import tat.mukhutdinov.nurseryRoom.dogs.gateway.entity.DogEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class DogEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ID)
    val id: Long,
    @ColumnInfo(name = COLUMN_MASTER_ID)
    val masterId: Long?,
    @ColumnInfo(name = COLUMN_NAME)
    val name: String
) {

    companion object {
        const val TABLE_NAME = "dog"
        const val COLUMN_ID = "id"
        const val COLUMN_MASTER_ID = "master_id"
        const val COLUMN_NAME = "name"
    }
}