package tat.mukhutdinov.nurseryRoom.pet.di

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import tat.mukhutdinov.nurseryRoom.pet.ui.PetSharedViewModel

object PetInjectionModule {

    val module = module {

        viewModel {
            PetSharedViewModel()
        }
    }
}