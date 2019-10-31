package tat.mukhutdinov.nurseryRoom.home.redux

sealed class HomeAction {

    object ShowDogs : HomeAction()

    object ShowCats : HomeAction()
}