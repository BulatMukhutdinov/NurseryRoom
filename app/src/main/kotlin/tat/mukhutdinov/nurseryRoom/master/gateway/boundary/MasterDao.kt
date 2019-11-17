package tat.mukhutdinov.nurseryRoom.master.gateway.boundary

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow
import tat.mukhutdinov.nurseryRoom.master.gateway.entity.MasterEntity
import tat.mukhutdinov.nurseryRoom.master.gateway.entity.MasterWithDogsRelation

@Dao
interface MasterDao {

    @Transaction
    @Query("SELECT * FROM ${MasterEntity.TABLE_NAME}")
    fun getMasterWithDogs(): Flow<List<MasterWithDogsRelation>>

    @Query("SELECT * FROM ${MasterEntity.TABLE_NAME}")
    suspend fun getAll(): List<MasterEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg masters: MasterEntity)
}