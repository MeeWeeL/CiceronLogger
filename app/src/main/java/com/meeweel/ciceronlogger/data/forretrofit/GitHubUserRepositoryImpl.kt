package com.meeweel.ciceronlogger.data.forretrofit

import com.meeweel.ciceronlogger.data.room.*
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GitHubUserRepositoryImpl
@Inject constructor(
    private val gitHubApi: GitHubApi,
    private val db: DBStorage
) : GitHubUserRepository {



    override fun getUsers(): Single<List<GitHubUser>> {
        return db.getGitEntityDao().getUsersList()
            .flatMap {
                if (convertEntityListToGitHubUserList(it).isEmpty()) {
                    gitHubApi.fetchUsers().map { serverResult ->
                        for (item in serverResult) {
                            db.getGitEntityDao().insert(convertGitHubUserToEntity(item))
                        }
                        serverResult
                    }
                } else {
                    Single.just(convertEntityListToGitHubUserList(it))
                }
            }
    }

    override fun getUserByLogin(userId: String): Single<GitHubUser> {
        return db.getGitEntityDao().getUserByLogin(userId).flatMap {
            Single.just(convertEntityToGitHubUser(it))
        }
    }
}