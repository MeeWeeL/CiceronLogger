package com.meeweel.ciceronlogger.githubuser

import com.meeweel.ciceronlogger.data.forretrofit.GitHubUser
import moxy.MvpView
import moxy.viewstate.strategy.alias.Skip

interface GitHubUserView : MvpView {

    @Skip
    fun toastError(text: String)
    @Skip
    fun showResult(user: GitHubUser)
}