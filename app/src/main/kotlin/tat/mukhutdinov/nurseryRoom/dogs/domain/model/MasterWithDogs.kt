package tat.mukhutdinov.nurseryRoom.dogs.domain.model

import tat.mukhutdinov.nurseryRoom.master.domain.model.Master

data class MasterWithDogs(val master: Master, val dogs: List<Dog>) {

    override fun toString(): String {
        val dogNames = StringBuilder()
        dogs.forEach {
            dogNames.append(it.name)
            dogNames.append(" ")
        }


        return "Master ${master.name} domesticated dogs: ${dogNames.trim()}"
    }
}