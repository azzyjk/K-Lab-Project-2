package com.example.communcationingarden.community

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.communcationingarden.data.RegistActivityInfo
import com.example.communcationingarden.databinding.DialogActivityRegistBinding

class AddDialogFragment : DialogFragment() {
	
	private var _binding: DialogActivityRegistBinding? = null
	private val binding get() = _binding!!
	lateinit var listener: NoticeDialogListener
	
	interface NoticeDialogListener {
		
		fun onDialogPositiveClick(registActivityInfo: RegistActivityInfo)
	}
	
	override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
		_binding = DialogActivityRegistBinding.inflate(layoutInflater)
		return AlertDialog.Builder(requireActivity())
			.setView(binding.root)
			.setPositiveButton("Regist") { dialog, id ->
				listener.onDialogPositiveClick(
					RegistActivityInfo(
						binding.activityNameEditText.text.toString(),
						binding.dateEditText.text.toString(),
						binding.timeEditText.text.toString(),
						binding.participantCountEditText.text.toString().toInt(),
						binding.activityNameEditText.text.toString()
					)
				)
			}
			.setNegativeButton("Cancel") { dialog, id ->
				dialog.cancel()
			}
			.create()
	}
	
	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}
}
