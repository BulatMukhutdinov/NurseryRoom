package tat.mukhutdinov.nurseryRoom.pet.ui

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.navArgs
import org.koin.android.viewmodel.ext.android.sharedViewModel
import tat.mukhutdinov.nurseryRoom.R
import tat.mukhutdinov.nurseryRoom.databinding.PetBinding
import tat.mukhutdinov.nurseryRoom.pet.domain.model.PetParticipant

class PetFragment : DialogFragment(), PetBindings {

    private lateinit var viewBinding: PetBinding

    private val petSharedViewModel: PetSharedViewModel by sharedViewModel()

    private val args: PetFragmentArgs by navArgs()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        viewBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.pet, null, false)
        viewBinding.bindings = this

        setAdapters()

        return AlertDialog.Builder(activity)
            .setView(viewBinding.root)
            .create()
    }

    override fun onPetClicked() {
        val selectedMaster = args.masters[viewBinding.master.selectedItemPosition]
        val selectedPet = args.pets[viewBinding.pet.selectedItemPosition]

        petSharedViewModel.selectedMasterIdToPetId.value = selectedMaster.id to selectedPet.id

        dialog?.dismiss()
    }

    override fun onCancelClicked() {
        dialog?.dismiss()
    }

    private fun setAdapters() {
        val mastersAdapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, args.masters.map(PetParticipant::name))
        mastersAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        viewBinding.master.adapter = mastersAdapter

        val petsAdapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, args.pets.map(PetParticipant::name))
        petsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        viewBinding.pet.adapter = petsAdapter
    }
}