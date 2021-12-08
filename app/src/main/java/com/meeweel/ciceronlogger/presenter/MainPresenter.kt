package com.meeweel.ciceronlogger.presenter

import com.meeweel.ciceronlogger.cicerone.CustomRouter
import com.meeweel.ciceronlogger.cicerone.UserView
import com.meeweel.ciceronlogger.model.UserModel
import moxy.MvpPresenter

class MainPresenter(
    private val userRepository: UserRepository,
    private val router: CustomRouter
) : MvpPresenter<UserView>() {

    fun getUser() : UserModel? = userRepository.getUser()

    override fun onFirstViewAttach() {
        userRepository.getUser()?.let(viewState::showUser)
    }
}