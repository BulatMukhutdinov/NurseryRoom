package tat.mukhutdinov.nurseryRoom.infrastructure.di

import tat.mukhutdinov.nurseryRoom.dogs.di.DogsInjectionModule
import tat.mukhutdinov.nurseryRoom.home.di.HomeInjectionModule
import tat.mukhutdinov.nurseryRoom.master.di.MasterInjectionModule

object InjectionModules {

    val modules = listOf(
        InfrastructureInjectionModule.module,
        HomeInjectionModule.module,
        MasterInjectionModule.module,
        DogsInjectionModule.module
    )
}