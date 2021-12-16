package com.meeweel.ciceronlogger.quad

import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState
import moxy.viewstate.strategy.alias.Skip

interface QuadView : MvpView {

    @SingleState
    fun calculate(value: String)

    @Skip
    fun toast(text: String)

    @SingleState
    fun showResult(text: String)

}