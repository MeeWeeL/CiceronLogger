package com.meeweel.ciceronlogger.cicerone

import com.meeweel.ciceronlogger.data.repository.UserRepositoryImpl
import com.meeweel.ciceronlogger.user.UserRepository

object UserRepositoryFactory {

    fun create(): UserRepository = UserRepositoryImpl()

}