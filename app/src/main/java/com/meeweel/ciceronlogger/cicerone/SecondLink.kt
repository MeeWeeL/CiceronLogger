package com.meeweel.ciceronlogger.cicerone

import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Forward
import com.meeweel.ciceronlogger.githubuser.GitHubUserScreen

class SecondLink(private val userId: String) : CustomRouter.Command, Command {

    override fun execute(navigator: CustomNavigator) {
        navigator.applyCommand(Forward(GitHubUserScreen(userId)))
    }
}