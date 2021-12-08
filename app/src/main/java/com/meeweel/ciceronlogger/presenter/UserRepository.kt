package com.meeweel.ciceronlogger.presenter

import com.meeweel.ciceronlogger.model.UserModel

interface UserRepository {

    fun getUser(): UserModel?
    fun setUser(newUser: UserModel)
}