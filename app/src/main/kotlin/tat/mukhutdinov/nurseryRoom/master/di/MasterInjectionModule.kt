package tat.mukhutdinov.nurseryRoom.master.di

import org.koin.dsl.module
import tat.mukhutdinov.nurseryRoom.infrastructure.db.DataBase
import tat.mukhutdinov.nurseryRoom.master.domain.boundary.MasterGateway
import tat.mukhutdinov.nurseryRoom.master.gateway.MasterLocalGateway
import tat.mukhutdinov.nurseryRoom.master.gateway.entity.MasterConverter

object MasterInjectionModule {

    val module = module {

        factory {
            MasterConverter()
        }

        single {
            get<DataBase>().masterDao()
        }

        factory<MasterGateway> {
            MasterLocalGateway(get(), get())
        }
    }
}