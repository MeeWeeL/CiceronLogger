package com.meeweel.ciceronlogger.data.forretrofit

object GitHubUserRepositoryFactory {

    fun create(): GitHubUserRepository = GitHubUserRepositoryImpl()

}