package tat.mukhutdinov.nurseryRoom.cats.redux

sealed class CatsAction {

    object ChoosePet : CatsAction()

    class Pet(val masterId: Long, val catId: Long) : CatsAction()

    object OnViewCreated : CatsAction()
}