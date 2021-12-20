package com.meeweel.ciceronlogger.data.forretrofit

import com.meeweel.ciceronlogger.data.room.*
import io.reactivex.rxjava3.core.Single

class GitHubUserRepositoryImpl : GitHubUserRepository {

    private val db = RoomEngine.create().getGitEntityDao()
    private val gitHubApi = GitHubApiFactory.create()

    override fun getUsers(): Single<List<GitHubUser>> {
        return db.getUsersList()
            .flatMap {
                if (convertEntityListToGitHubUserList(it).isEmpty()) {
                    gitHubApi.fetchUsers().map { serverResult ->
                        for (item in serverResult) {
                            db.insert(convertGitHubUserToEntity(item))
                        }
                        serverResult
                    }
                } else {
                    Single.just(convertEntityListToGitHubUserList(it))
                }
            }
    }

    override fun getUserByLogin(userId: String): Single<GitHubUser> {
        return db.getUserByLogin(userId).flatMap {
            Single.just(convertEntityToGitHubUser(it))
        }
    }
}