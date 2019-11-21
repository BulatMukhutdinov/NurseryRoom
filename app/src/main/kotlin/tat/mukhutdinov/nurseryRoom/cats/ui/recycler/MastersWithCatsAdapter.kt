package tat.mukhutdinov.nurseryRoom.cats.ui.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import tat.mukhutdinov.nurseryRoom.cats.domain.model.MasterWithCats
import tat.mukhutdinov.nurseryRoom.dogs.domain.model.MasterWithDogs
import tat.mukhutdinov.nurseryRoom.infrastructure.structure.recycler.BaseAdapter

class MastersWithCatsAdapter : BaseAdapter<MasterWithCats, MastersWithCatsViewHolder>() {

    init {
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MastersWithCatsViewHolder =
        MastersWithCatsViewHolder.create(parent)

    override fun getDiffUtil(updated: List<MasterWithCats>): DiffUtil.Callback =
        MasterWithCatsDiffUtil(items, updated)

    override fun getItemId(position: Int): Long =
        items[position].master.id
}