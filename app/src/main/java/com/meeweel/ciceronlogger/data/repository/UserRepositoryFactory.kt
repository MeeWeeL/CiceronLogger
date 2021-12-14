package com.meeweel.ciceronlogger.data.repository

import com.meeweel.ciceronlogger.data.UserModel
import io.reactivex.rxjava3.core.Observable

object UserRepositoryFactory {

    var user: String = ""

    var users: List<UserModel> = listOf(
        UserModel("Vanilla","Vanilla"),
        UserModel("Meeweel","qweqwe"),
        UserModel("User","123")
    )

    fun getUsersFromRepo() : Observable<List<UserModel>> {
        return Observable.just(users)
    }

    fun getUserIdFromRepo() : Observable<String> {
        return Observable.just(user)
    }

    fun getUserFromRepoById(id: String) : UserModel? {
        for (item in users) {
            if (item.login == id) {
                return item
            }
        }
        return null //UserModel("","")
    }

    fun setUserId(id: String) {
        user = id
    }

    fun create(): UserRepository = UserRepositoryImpl()

}