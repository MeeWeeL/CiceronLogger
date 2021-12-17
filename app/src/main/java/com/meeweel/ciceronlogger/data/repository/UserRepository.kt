package com.meeweel.ciceronlogger.data.repository

import com.meeweel.ciceronlogger.data.UserModel
import io.reactivex.rxjava3.core.Observable

interface UserRepository {

    fun getUser(): Observable<String>
    fun getUserById(id: String): Observable<UserModel>
    fun setUser(id: String)
    fun getUsers(): Observable<List<UserModel>>
}