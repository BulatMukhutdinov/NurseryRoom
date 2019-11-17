package tat.mukhutdinov.nurseryRoom.infrastructure.structure

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import tat.mukhutdinov.nurseryRoom.BR
import timber.log.Timber

abstract class BaseFragment<V : ViewDataBinding> : Fragment() {

    protected abstract val layoutId: Int

    protected lateinit var viewBinding: V

    protected lateinit var viewScope: CoroutineScope

    protected lateinit var fragmentScope: CoroutineScope

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
        fragmentScope = CoroutineScope(Dispatchers.IO + exceptionHandler)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewScope = CoroutineScope(Dispatchers.IO + exceptionHandler)

        viewBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)

        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.lifecycleOwner = viewLifecycleOwner

        viewBinding.setVariable(BR.bindings, this)
    }

    override fun onDestroyView() {
        viewScope.cancel()

        super.onDestroyView()
    }

    override fun onDestroy() {
        fragmentScope.cancel()

        super.onDestroy()
    }
}

private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
    Timber.e(throwable)
}