package com.meeweel.ciceronlogger.model

import com.meeweel.ciceronlogger.presenter.UserRepository

class UserRepositoryImpl : UserRepository {


    override fun getUser(): UserModel? {
        return user
    }

    override fun setUser(newUser: UserModel) {
        user = newUser
    }
}