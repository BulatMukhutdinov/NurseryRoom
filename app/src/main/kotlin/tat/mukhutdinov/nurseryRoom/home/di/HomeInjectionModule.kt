package tat.mukhutdinov.nurseryRoom.home.di

import org.koin.dsl.module
import tat.mukhutdinov.nurseryRoom.home.redux.HomeStateReducer
import tat.mukhutdinov.nurseryRoom.home.ui.boundary.HomeReducer

object HomeInjectionModule {

    val module = module {

        factory<HomeReducer> {
            HomeStateReducer()
        }

    }
}