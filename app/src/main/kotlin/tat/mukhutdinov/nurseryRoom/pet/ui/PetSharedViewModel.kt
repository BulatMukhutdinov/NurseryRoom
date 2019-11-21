package tat.mukhutdinov.nurseryRoom.pet.ui

import androidx.lifecycle.ViewModel
import tat.mukhutdinov.nurseryRoom.infrastructure.util.SingleLiveEvent

class PetSharedViewModel : ViewModel() {

    val selectedMasterIdToPetId = SingleLiveEvent<Pair<Long, Long>>()
}