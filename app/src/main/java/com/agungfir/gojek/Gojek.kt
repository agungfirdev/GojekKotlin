package com.agungfir.gojek

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate

class Gojek : Application() {

    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }
}