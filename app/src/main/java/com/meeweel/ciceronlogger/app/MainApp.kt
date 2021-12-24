package com.meeweel.ciceronlogger.app

import android.app.Application
import com.meeweel.ciceronlogger.di.ApplicationComponent
import com.meeweel.ciceronlogger.di.DaggerApplicationComponent

class MainApp : Application() {

    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        component = DaggerApplicationComponent.builder()
            .setContext(this)
            .build()
    }

    companion object {
        lateinit var instance: MainApp
    }
}