package tat.mukhutdinov.nurseryRoom.dogs.di

import org.koin.dsl.module
import tat.mukhutdinov.nurseryRoom.dogs.domain.DogsInteractor
import tat.mukhutdinov.nurseryRoom.dogs.domain.boundary.DogsDomain
import tat.mukhutdinov.nurseryRoom.dogs.domain.boundary.DogGateway
import tat.mukhutdinov.nurseryRoom.dogs.gateway.DogLocalGateway
import tat.mukhutdinov.nurseryRoom.dogs.gateway.entity.DogConverter
import tat.mukhutdinov.nurseryRoom.dogs.redux.DogsStateReducer
import tat.mukhutdinov.nurseryRoom.dogs.redux.boundary.DogsReducer
import tat.mukhutdinov.nurseryRoom.infrastructure.db.DataBase

object DogsInjectionModule {

    val module = module {

        factory<DogsDomain> {
            DogsInteractor(get(), get())
        }

        factory<DogGateway> {
            DogLocalGateway(get(), get())
        }

        factory<DogsReducer> {
            DogsStateReducer(get())
        }

        factory {
            DogConverter(get())
        }

        single {
            get<DataBase>().dogDao()
        }
    }
}