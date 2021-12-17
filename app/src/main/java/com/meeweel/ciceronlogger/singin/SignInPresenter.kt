package com.meeweel.ciceronlogger.singin

import com.meeweel.ciceronlogger.cicerone.CustomRouter
import com.meeweel.ciceronlogger.data.UserModel
import com.meeweel.ciceronlogger.data.repository.UserRepository
import moxy.MvpPresenter

const val WRONG_PASSWORD = "Wrong password"
const val WRONG_LOGIN = "Wrong login"

class SignInPresenter(
    private val userRepository: UserRepository,
    private val router: CustomRouter
) : MvpPresenter<SignInView>() {

    var id = ""
    var password = ""

    fun tryToSignIn(user: UserModel) {
        id = user.login
        password = user.password
        if (checkId()) {
            if (checkPassword()) {
                setUser()
                router.openDeepLink()
            } else {
                viewState.toastError(WRONG_PASSWORD)
            }
        } else {
            viewState.toastError(WRONG_LOGIN)
        }
    }

    private fun setUser() {
        userRepository.setUser(id)
    }

    private fun checkId() : Boolean {
        var isIdTrue = false
        userRepository.getUsers().subscribe({
            for (item in it) {
                if (item.login == id) isIdTrue = true
                break
            }
        },{})
        return isIdTrue
    }

    private fun checkPassword() : Boolean {
        var isPasswordTrue = false
        userRepository.getUserById(id).subscribe({ user ->
            if (user.password == password) {
                isPasswordTrue = true
            }
        },{})
        return isPasswordTrue
    }
}