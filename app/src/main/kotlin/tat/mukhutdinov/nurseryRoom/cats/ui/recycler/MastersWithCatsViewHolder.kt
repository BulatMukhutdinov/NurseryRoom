package tat.mukhutdinov.nurseryRoom.cats.ui.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import tat.mukhutdinov.nurseryRoom.R
import tat.mukhutdinov.nurseryRoom.cats.domain.model.MasterWithCats
import tat.mukhutdinov.nurseryRoom.databinding.CatsItemBinding
import tat.mukhutdinov.nurseryRoom.infrastructure.structure.recycler.BaseViewHolder

class MastersWithCatsViewHolder(
    viewBinding: CatsItemBinding
) : BaseViewHolder<MasterWithCats, CatsItemBinding>(viewBinding) {

    companion object {

        fun create(parent: ViewGroup): MastersWithCatsViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val viewDataBinding: CatsItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.cats_item, parent, false)

            return MastersWithCatsViewHolder(viewDataBinding)
        }
    }
}