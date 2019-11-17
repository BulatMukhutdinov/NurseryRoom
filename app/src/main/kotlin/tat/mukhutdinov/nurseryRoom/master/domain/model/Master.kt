package tat.mukhutdinov.nurseryRoom.master.domain.model

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
data class Master(val id: Long, val name: String) : Parcelable