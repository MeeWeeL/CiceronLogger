package com.meeweel.ciceronlogger.data.repository

import com.meeweel.ciceronlogger.data.UserModel
import com.meeweel.ciceronlogger.data.repository.UserRepositoryFactory.getUserIdFromRepo
import com.meeweel.ciceronlogger.data.repository.UserRepositoryFactory.getUserFromRepoById
import com.meeweel.ciceronlogger.data.repository.UserRepositoryFactory.getUsersFromRepo
import com.meeweel.ciceronlogger.data.repository.UserRepositoryFactory.setUserId
import io.reactivex.rxjava3.core.Observable

class UserRepositoryImpl : UserRepository {


    override fun getUser(): Observable<String> {
        return getUserIdFromRepo()
    }

    override fun getUserById(id: String): Observable<UserModel> {
        getUserFromRepoById(id)!!.let {
            return Observable.just(it)
        }
    }

    override fun setUser(id: String) {
        setUserId(id)
    }

    override fun getUsers(): Observable<List<UserModel>> {
        return getUsersFromRepo()
    }
}