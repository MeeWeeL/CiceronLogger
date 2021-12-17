package com.meeweel.ciceronlogger.githubuser

import com.meeweel.ciceronlogger.data.forretrofit.GitHubUser
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState
import moxy.viewstate.strategy.alias.Skip

interface GitHubUserView : MvpView {

    @Skip
    fun toastError(text: String)
    @SingleState
    fun showResult(user: GitHubUser)
}