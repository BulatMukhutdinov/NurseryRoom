package tat.mukhutdinov.nurseryRoom.cats.ui

import tat.mukhutdinov.nurseryRoom.R
import tat.mukhutdinov.nurseryRoom.databinding.CatsBinding
import tat.mukhutdinov.nurseryRoom.infrastructure.structure.BaseFragment

class CatsFragment : BaseFragment<CatsBinding>(), CatsBindings {

    override val layoutId: Int = R.layout.cats
}