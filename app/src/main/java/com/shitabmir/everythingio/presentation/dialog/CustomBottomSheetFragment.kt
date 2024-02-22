package com.shitabmir.everythingio.presentation.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.shitabmir.everythingio.R


/**
 * Created by Shitab Mir on 2/22/24.
 * shitabmir@gmail.com
 **/

class CustomBottomSheetFragment : BottomSheetDialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_dialog_bottom_sheet, container, false)

        // Customize the bottom sheet components (e.g., set text)
        val tvBottomSheetTitle = view.findViewById<TextView>(R.id.tvBottomSheetTitle)
        tvBottomSheetTitle.text = "Custom Bottom Sheet Title"
        val tvBottomSheetSubtitle = view.findViewById<TextView>(R.id.tvBottomSheetSubtitle)
        tvBottomSheetSubtitle.text = "This is a custom bottom sheet message."
        val btnClose = view.findViewById<Button>(R.id.btnClose)
        btnClose.setOnClickListener { // Dismiss the bottom sheet when the close button is clicked
            dismiss()
        }
        return view
    }
}