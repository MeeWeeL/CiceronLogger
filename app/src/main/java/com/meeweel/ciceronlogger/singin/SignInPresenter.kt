package com.meeweel.ciceronlogger.singin

import com.meeweel.ciceronlogger.cicerone.CustomRouter
import com.meeweel.ciceronlogger.data.UserModel
import com.meeweel.ciceronlogger.user.UserRepository
import moxy.MvpPresenter

class SignInPresenter(
    private val userRepository: UserRepository,
    private val router: CustomRouter
) : MvpPresenter<SignInView>() {

    fun setUser(user: UserModel) {
        userRepository.setUser(user)
    }
}