package com.meeweel.ciceronlogger.data.forretrofit.userrepo

interface GitHubUserRepoRepository {

    fun getUserByLogin(login: String)

}