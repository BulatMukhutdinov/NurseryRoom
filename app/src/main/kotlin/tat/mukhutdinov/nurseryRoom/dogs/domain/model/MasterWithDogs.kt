package tat.mukhutdinov.nurseryRoom.dogs.domain.model

import tat.mukhutdinov.nurseryRoom.master.domain.model.Master

data class MasterWithDogs(val master: Master, val dogs: List<Dog>)