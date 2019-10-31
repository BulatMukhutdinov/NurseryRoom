package tat.mukhutdinov.nurseryRoom.dogs.gateway.boundary

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import tat.mukhutdinov.nurseryRoom.dogs.gateway.entity.MasterWithDogsRelation
import tat.mukhutdinov.nurseryRoom.master.gateway.entity.MasterEntity

@Dao
interface DogDao {

    @Transaction
    @Query("SELECT * FROM ${MasterEntity.TABLE_NAME}")
    suspend fun getMasterWithDogs(): List<MasterWithDogsRelation>
}