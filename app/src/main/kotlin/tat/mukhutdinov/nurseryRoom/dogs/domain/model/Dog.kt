package tat.mukhutdinov.nurseryRoom.dogs.domain.model

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.android.parcel.Parcelize
import tat.mukhutdinov.nurseryRoom.master.domain.model.Master

@Keep
@Parcelize
data class Dog(val id: Long, val name: String, val master: Master?) : Parcelable