package tat.mukhutdinov.nurseryRoom.pet.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PetSharedViewModel : ViewModel() {

    val selectedMasterIdToPetId = MutableLiveData<Pair<Long, Long>>()
}