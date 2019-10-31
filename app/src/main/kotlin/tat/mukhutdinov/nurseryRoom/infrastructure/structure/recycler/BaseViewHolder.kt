package tat.mukhutdinov.nurseryRoom.infrastructure.structure.recycler

import androidx.annotation.CallSuper
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.recyclerview.widget.RecyclerView
import tat.mukhutdinov.nurseryRoom.BR

abstract class BaseViewHolder<Item, V : ViewDataBinding>(
    protected val viewDataBinding: V
) : RecyclerView.ViewHolder(viewDataBinding.root), LifecycleOwner {

    override fun getLifecycle(): Lifecycle = lifecycleRegistry

    private val lifecycleRegistry by lazy { LifecycleRegistry(this) }

    @CallSuper
    open fun bindTo(item: Item) {
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START)

        viewDataBinding.setVariable(BR.item, item)
        viewDataBinding.lifecycleOwner = this
        viewDataBinding.executePendingBindings()
    }

    @CallSuper
    open fun onViewRecycled() {
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP)
        viewDataBinding.unbind()
    }
}