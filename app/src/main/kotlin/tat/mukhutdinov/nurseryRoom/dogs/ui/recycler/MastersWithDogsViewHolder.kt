package tat.mukhutdinov.nurseryRoom.dogs.ui.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import tat.mukhutdinov.nurseryRoom.R
import tat.mukhutdinov.nurseryRoom.databinding.DogsItemBinding
import tat.mukhutdinov.nurseryRoom.dogs.domain.model.MasterWithDogs
import tat.mukhutdinov.nurseryRoom.infrastructure.structure.recycler.BaseViewHolder

class MastersWithDogsViewHolder(
    viewBinding: DogsItemBinding
) : BaseViewHolder<MasterWithDogs, DogsItemBinding>(viewBinding) {

    companion object {

        fun create(parent: ViewGroup): MastersWithDogsViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val viewDataBinding: DogsItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.dogs_item, parent, false)

            return MastersWithDogsViewHolder(viewDataBinding)
        }
    }
}