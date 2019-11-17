package tat.mukhutdinov.nurseryRoom.dogs.ui.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import tat.mukhutdinov.nurseryRoom.dogs.domain.model.MasterWithDogs
import tat.mukhutdinov.nurseryRoom.infrastructure.structure.recycler.BaseAdapter

class MastersWithDogsAdapter : BaseAdapter<MasterWithDogs, MastersWithDogsViewHolder>() {

    init {
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MastersWithDogsViewHolder =
        MastersWithDogsViewHolder.create(parent)

    override fun getDiffUtil(updated: List<MasterWithDogs>): DiffUtil.Callback =
        MasterWithDogsDiffUtil(items, updated)

    override fun getItemId(position: Int): Long =
        items[position].master.id
}