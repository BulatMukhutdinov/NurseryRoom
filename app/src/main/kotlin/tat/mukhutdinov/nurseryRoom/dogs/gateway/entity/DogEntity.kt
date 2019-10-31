package tat.mukhutdinov.nurseryRoom.dogs.gateway.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import tat.mukhutdinov.nurseryRoom.dogs.gateway.entity.DogEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class DogEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ID)
    var id: Long,
    @ColumnInfo(name = COLUMN_MASTER_ID)
    var masterId: Long,
    @ColumnInfo(name = COLUMN_NAME)
    var name: String
) {

    companion object {
        const val TABLE_NAME = "dog"
        const val COLUMN_ID = "id"
        const val COLUMN_MASTER_ID = "master_id"
        const val COLUMN_NAME = "name"
    }
}