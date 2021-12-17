package com.meeweel.ciceronlogger.githunusers

import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState
import moxy.viewstate.strategy.alias.Skip

interface GitHubUsersView : MvpView {

    @Skip
    fun toastError(text: String)
    @SingleState
    fun setName(name: String)
}