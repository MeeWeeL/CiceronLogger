package com.meeweel.ciceronlogger.data.repository

import com.meeweel.ciceronlogger.data.UserModel
import com.meeweel.ciceronlogger.user.UserRepository

class UserRepositoryImpl : UserRepository {


    override fun getUser(): UserModel? {
        return user
    }

    override fun setUser(newUser: UserModel) {
        user = newUser
    }
}