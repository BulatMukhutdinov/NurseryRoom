package tat.mukhutdinov.nurseryRoom.cats.ui.recycler

import androidx.recyclerview.widget.DiffUtil
import tat.mukhutdinov.nurseryRoom.cats.domain.model.MasterWithCats

class MasterWithCatsDiffUtil(
    private val oldList: List<MasterWithCats>,
    private val newList: List<MasterWithCats>
) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].master.id == newList[newItemPosition].master.id

    override fun getOldListSize(): Int =
        oldList.size

    override fun getNewListSize(): Int =
        newList.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].master == newList[newItemPosition].master
                && oldList[oldItemPosition].cats == newList[newItemPosition].cats
}