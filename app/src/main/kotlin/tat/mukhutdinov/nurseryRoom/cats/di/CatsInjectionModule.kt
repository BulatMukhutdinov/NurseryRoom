package tat.mukhutdinov.nurseryRoom.cats.di

import org.koin.dsl.module
import tat.mukhutdinov.nurseryRoom.cats.domain.CatsIneractor
import tat.mukhutdinov.nurseryRoom.cats.domain.boundary.CatGateway
import tat.mukhutdinov.nurseryRoom.cats.domain.boundary.CatsDomain
import tat.mukhutdinov.nurseryRoom.cats.gateway.CatLocalGateway
import tat.mukhutdinov.nurseryRoom.cats.gateway.entity.CatConverter
import tat.mukhutdinov.nurseryRoom.cats.redux.CatsStateReducer
import tat.mukhutdinov.nurseryRoom.cats.redux.boundary.CatsReducer
import tat.mukhutdinov.nurseryRoom.infrastructure.db.DataBase

object CatsInjectionModule {

    val module = module {

        factory<CatsDomain> {
            CatsIneractor(get(), get())
        }

        factory<CatGateway> {
            CatLocalGateway(get(), get())
        }

        factory<CatsReducer> {
            CatsStateReducer(get())
        }

        factory {
            CatConverter()
        }

        single {
            get<DataBase>().catDao()
        }
    }
}