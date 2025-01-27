package com.agungfir.gojek.utils

import android.content.res.Resources
import android.util.TypedValue


object Utils {

    fun dp2px(resource: Resources, dp: Int): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dp.toFloat(),
            resource.displayMetrics
        ).toInt()
    }
}