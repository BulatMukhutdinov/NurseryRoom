package tat.mukhutdinov.nurseryRoom.infrastructure.structure.recycler

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<Item, VH : BaseViewHolder<Item, *>> : RecyclerView.Adapter<VH>() {

    private val items = mutableListOf<Item>()

    abstract fun getDiffUtil(updated: List<Item>): DiffUtil.Callback

    fun updateItems(updated: List<Item>) {
        val diffResult = DiffUtil.calculateDiff(getDiffUtil(updated))

        items.clear()
        items.addAll(updated)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun getItemCount(): Int =
        items.size

    override fun onBindViewHolder(holder: VH, position: Int) =
        holder.bindTo(items[position])
}