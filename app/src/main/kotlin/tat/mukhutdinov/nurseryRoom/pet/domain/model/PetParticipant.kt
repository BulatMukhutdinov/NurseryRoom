package tat.mukhutdinov.nurseryRoom.pet.domain.model

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
class PetParticipant(val name: String, val id: Long) : Parcelable