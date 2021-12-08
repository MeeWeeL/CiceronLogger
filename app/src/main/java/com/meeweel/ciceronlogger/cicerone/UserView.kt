package com.meeweel.ciceronlogger.cicerone

import com.meeweel.ciceronlogger.model.UserModel
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

interface UserView : MvpView {

    /**
     * Показывает информацию о пользователе.
     * @param user пользователь
     */
    @SingleState
    fun showUser(user: UserModel)

}