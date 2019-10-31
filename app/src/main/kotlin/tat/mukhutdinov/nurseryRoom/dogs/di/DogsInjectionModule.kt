package tat.mukhutdinov.nurseryRoom.dogs.di

import org.koin.dsl.module
import tat.mukhutdinov.nurseryRoom.dogs.domain.DogsInteractor
import tat.mukhutdinov.nurseryRoom.dogs.domain.boundary.DogsGateway
import tat.mukhutdinov.nurseryRoom.dogs.gateway.entity.DogsConverter
import tat.mukhutdinov.nurseryRoom.dogs.gateway.DogsLocalGateway
import tat.mukhutdinov.nurseryRoom.dogs.redux.DogsStateReducer
import tat.mukhutdinov.nurseryRoom.dogs.redux.boundary.DogsDomain
import tat.mukhutdinov.nurseryRoom.dogs.ui.boundary.DogsReducer

object DogsInjectionModule {

    val module = module {

        factory<DogsDomain> {
            DogsInteractor(get())
        }

        factory<DogsGateway> {
            DogsLocalGateway(get(), get())
        }

        factory<DogsReducer> {
            DogsStateReducer(get())
        }

        factory {
            DogsConverter(get())
        }
    }
}