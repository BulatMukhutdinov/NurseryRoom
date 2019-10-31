package tat.mukhutdinov.nurseryRoom.dogs.redux

import tat.mukhutdinov.nurseryRoom.dogs.domain.model.MasterWithDogs

data class DogsState(
    val mastersWithDogs: List<MasterWithDogs> = emptyList()
)