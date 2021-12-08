package com.meeweel.ciceronlogger.cicerone

import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Forward

class DeepLink : CustomRouter.Command, Command {

    override fun execute(navigator: CustomNavigator) {
        navigator.applyCommand(Forward(UserScreen()))
    }
}