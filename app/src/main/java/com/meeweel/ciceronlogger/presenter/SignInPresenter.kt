package com.meeweel.ciceronlogger.presenter

import com.meeweel.ciceronlogger.cicerone.CustomRouter
import com.meeweel.ciceronlogger.cicerone.SignInView
import com.meeweel.ciceronlogger.cicerone.UserView
import com.meeweel.ciceronlogger.model.UserModel
import moxy.MvpPresenter

class SignInPresenter(
    private val userRepository: UserRepository,
    private val router: CustomRouter
) : MvpPresenter<SignInView>() {

    fun setUser(user: UserModel) {
        userRepository.setUser(user)
    }
}