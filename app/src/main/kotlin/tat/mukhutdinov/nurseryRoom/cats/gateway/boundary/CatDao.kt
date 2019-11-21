package tat.mukhutdinov.nurseryRoom.cats.gateway.boundary

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import tat.mukhutdinov.nurseryRoom.cats.gateway.entity.CatEntity
import tat.mukhutdinov.nurseryRoom.cats.gateway.entity.CatWithMasterEntity

@Dao
interface CatDao {

    @Query("SELECT * FROM ${CatEntity.TABLE_NAME}")
    suspend fun getAll(): List<CatEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg catWithMaster: CatWithMasterEntity)
}