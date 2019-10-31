package tat.mukhutdinov.nurseryRoom.master.di

import org.koin.dsl.module
import tat.mukhutdinov.nurseryRoom.master.gateway.entity.MasterConverter

object MasterInjectionModule {

    val module = module {

        factory {
            MasterConverter()
        }
    }
}