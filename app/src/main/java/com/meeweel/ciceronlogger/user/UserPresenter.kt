package com.meeweel.ciceronlogger.user

import com.meeweel.ciceronlogger.cicerone.CustomRouter
import com.meeweel.ciceronlogger.data.UserModel
import moxy.MvpPresenter

class UserPresenter(
    private val userRepository: UserRepository,
    private val router: CustomRouter
) : MvpPresenter<UserView>() {

    fun getUser() : UserModel? = userRepository.getUser()

    override fun onFirstViewAttach() {
        userRepository.getUser()?.let(viewState::showUser)
    }
}