package com.meeweel.ciceronlogger.data.forretrofit

import com.meeweel.ciceronlogger.data.forretrofit.userrepo.GitHubRepoResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubApi {

    @GET("/users")
    fun fetchUsers(): Single<List<GitHubUser>>

    @GET("/users/{login}")
    fun fetchUserByLogin(@Path("login") login: String): Single<GitHubUser>

    @GET("/users/{login}/repos")
    fun fetchUserRepositories(@Path("login") login: String): Single<List<GitHubRepoResponse>>
}