 package com.meeweel.ciceronlogger.user

 import com.meeweel.ciceronlogger.data.UserModel

 interface UserRepository {

    fun getUser(): UserModel?
    fun setUser(newUser: UserModel)
}