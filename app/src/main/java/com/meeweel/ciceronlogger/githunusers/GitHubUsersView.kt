package com.meeweel.ciceronlogger.githunusers

import moxy.MvpView
import moxy.viewstate.strategy.alias.Skip

interface GitHubUsersView : MvpView {

    @Skip
    fun toastError(text: String)
    @Skip
    fun setName(name: String)
}