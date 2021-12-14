package com.meeweel.ciceronlogger.singin

import moxy.MvpView
import moxy.viewstate.strategy.alias.Skip

interface SignInView : MvpView {
    @Skip
    fun toastError(text: String)
}