package com.shitabmir.everythingio.base

import android.app.Application
import android.content.res.Configuration

/**
 * Created by Shitab Mir on 2/22/24.
 * shitabmir@gmail.com
 **/
class MyApplication: Application() {

    // -------------------------------- Application Lifecycle -------------------------------------
    override fun onCreate() {
        super.onCreate()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }

}