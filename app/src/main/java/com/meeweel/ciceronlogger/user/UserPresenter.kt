package com.meeweel.ciceronlogger.user

import com.meeweel.ciceronlogger.cicerone.CustomRouter
import com.meeweel.ciceronlogger.data.repository.UserRepository
import moxy.MvpPresenter

class UserPresenter(
    private val userRepository: UserRepository,
    private val router: CustomRouter
) : MvpPresenter<UserView>() {

    fun getUser() {
        userRepository.getUser().subscribe({
            viewState.showUser(it)
        },{

        })
    }
}