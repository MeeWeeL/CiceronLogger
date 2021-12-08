package com.meeweel.ciceronlogger.cicerone

import com.github.terrakok.cicerone.Router

class CustomRouter : Router() {

    interface Command {
        fun execute(navigator: CustomNavigator)
    }

    fun openDeepLink() {
        executeCommands(DeepLink())
    }
}