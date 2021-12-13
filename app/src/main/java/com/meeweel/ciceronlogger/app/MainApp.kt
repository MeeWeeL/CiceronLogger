package com.meeweel.ciceronlogger.app

import android.app.Application
import com.github.terrakok.cicerone.Cicerone
import com.meeweel.ciceronlogger.cicerone.CustomRouter

class MainApp : Application() {

    companion object Navigation {

        private val cicerone: Cicerone<CustomRouter> by lazy {
            Cicerone.create(CustomRouter())
        }
        val navigatorHolder = cicerone.getNavigatorHolder()
        val router = cicerone.router
    }
}