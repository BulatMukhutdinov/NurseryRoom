package tat.mukhutdinov.nurseryRoom.cats.domain.model

import tat.mukhutdinov.nurseryRoom.master.domain.model.Master

data class MasterWithCats(val master: Master, val cats: List<Cat>) {

    override fun toString(): String {
        val catNames = StringBuilder()
        cats.forEach {
            catNames.append(it.name)
            catNames.append(" ")
        }

        return "Master ${master.name} domesticated cats: ${catNames.trim()}"
    }
}