package com.agungfir.gojek.bottomsheetexpanded

import android.app.Dialog
import android.os.Bundle
import com.agungfir.gojek.R
import com.google.android.material.R.id.design_bottom_sheet
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_EXPANDED
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

open class BottomSheetDialogFragmentExpanded : BottomSheetDialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = BottomSheetDialog(requireActivity(), R.style.Theme_Design_BottomSheetDialog)
        dialog.setOnShowListener {
            BottomSheetBehavior.from(
                (it as BottomSheetDialog).findViewById(
                    design_bottom_sheet
                )!!
            ).state = STATE_EXPANDED
        }
        dialog.window?.setDimAmount(0.3F)
        return dialog
    }

}