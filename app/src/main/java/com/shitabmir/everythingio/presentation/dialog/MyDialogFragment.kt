package com.shitabmir.everythingio.presentation.dialog

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment


/**
 * Created by Shitab Mir on 2/22/24.
 * shitabmir@gmail.com
 **/

class MyDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Dialog Title")
            .setMessage("This is a sample dialog.")
            .setPositiveButton("OK", DialogInterface.OnClickListener { dialog, id ->
                // User clicked OK button
            })
            .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, id ->
                // User cancelled the dialog
            })
            .setCancelable(false)

        return builder.create()
    }
}