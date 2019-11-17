package tat.mukhutdinov.nurseryRoom.infrastructure.di

import androidx.room.Room
import org.koin.dsl.module
import tat.mukhutdinov.nurseryRoom.infrastructure.db.DataBase

object InfrastructureInjectionModule {
    private const val DATABASE_NAME = "nursery_room.db"
    private const val DATABASE_DIRECTORY = "database/nursery_room.db"

    val module = module {
        single {
            Room.databaseBuilder(get(), DataBase::class.java, DATABASE_NAME)
                .createFromAsset(DATABASE_DIRECTORY)
                .build()
        }
    }
}