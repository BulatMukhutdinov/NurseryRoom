package tat.mukhutdinov.nurseryRoom.dogs.ui.recycler

import androidx.recyclerview.widget.DiffUtil
import tat.mukhutdinov.nurseryRoom.dogs.domain.model.MasterWithDogs

class MasterWithDogsDiffUtil(
    private val oldList: List<MasterWithDogs>,
    private val newList: List<MasterWithDogs>
) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].master.id == newList[newItemPosition].master.id

    override fun getOldListSize(): Int =
        oldList.size

    override fun getNewListSize(): Int =
        newList.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].master == newList[newItemPosition].master
            && oldList[oldItemPosition].dogs == newList[newItemPosition].dogs
}