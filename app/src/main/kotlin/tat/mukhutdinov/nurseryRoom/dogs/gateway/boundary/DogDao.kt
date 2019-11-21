package tat.mukhutdinov.nurseryRoom.dogs.gateway.boundary

import androidx.room.*
import tat.mukhutdinov.nurseryRoom.dogs.gateway.entity.DogEntity
import tat.mukhutdinov.nurseryRoom.dogs.gateway.entity.DogWithMasterRelation

@Dao
interface DogDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg dogs: DogEntity)

    @Transaction
    @Query("SELECT * FROM ${DogEntity.TABLE_NAME}")
    suspend fun getDogsWithMaster(): List<DogWithMasterRelation>

    @Transaction
    @Query("SELECT * FROM ${DogEntity.TABLE_NAME} WHERE ${DogEntity.COLUMN_ID} = :id")
    suspend fun getDogWithMasterById(id: Long): DogWithMasterRelation

    @Query("SELECT * FROM ${DogEntity.TABLE_NAME} WHERE ${DogEntity.COLUMN_ID} = :id")
    suspend fun getDogById(id: Long): DogEntity

    @Update
    suspend fun update(vararg dog: DogEntity)
}