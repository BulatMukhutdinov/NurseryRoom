package tat.mukhutdinov.nurseryRoom.infrastructure.db

import androidx.room.Database
import androidx.room.RoomDatabase
import tat.mukhutdinov.nurseryRoom.cats.gateway.entity.CatEntity
import tat.mukhutdinov.nurseryRoom.dogs.gateway.boundary.DogDao
import tat.mukhutdinov.nurseryRoom.dogs.gateway.entity.DogEntity
import tat.mukhutdinov.nurseryRoom.master.gateway.boundary.MasterDao
import tat.mukhutdinov.nurseryRoom.master.gateway.entity.MasterEntity

@Database(
    entities = [
        CatEntity::class,
        DogEntity::class,
        MasterEntity::class
    ],
    version = 3
)

abstract class DataBase : RoomDatabase() {

    abstract fun dogDao(): DogDao

    abstract fun masterDao(): MasterDao
}