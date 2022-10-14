package com.invozone.hiltexample.Application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class MyApplication  : Application(){



    override fun onCreate() {
        super.onCreate()


    }
}