package com.meeweel.ciceronlogger.cicerone

import com.meeweel.ciceronlogger.model.UserRepositoryImpl
import com.meeweel.ciceronlogger.presenter.UserRepository

object UserRepositoryFactory {

    fun create(): UserRepository = UserRepositoryImpl()

}