package tat.mukhutdinov.nurseryRoom.dogs.redux

sealed class DogsAction {

    object Pet : DogsAction()

    object OnViewCreated : DogsAction()
}