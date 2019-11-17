package tat.mukhutdinov.nurseryRoom.dogs.redux

sealed class DogsAction {

    object ChoosePet : DogsAction()

    class Pet(val masterId: Long, val dogId: Long) : DogsAction()

    object OnViewCreated : DogsAction()
}