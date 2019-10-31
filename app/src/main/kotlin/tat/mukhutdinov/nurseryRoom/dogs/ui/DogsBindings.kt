package tat.mukhutdinov.nurseryRoom.dogs.ui

import androidx.lifecycle.LiveData
import tat.mukhutdinov.nurseryRoom.dogs.domain.model.MasterWithDogs

interface DogsBindings {

    val mastersWithDogs: LiveData<List<MasterWithDogs>>
}