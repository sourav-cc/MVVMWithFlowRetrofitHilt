package com.example.setup1

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SetupApplication : Application(){
    override fun onCreate() {
        super.onCreate()
    }
}