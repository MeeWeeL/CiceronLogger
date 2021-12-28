package com.meeweel.ciceronlogger.githubuser.di

import com.meeweel.ciceronlogger.data.forretrofit.GitHubApi
import com.meeweel.ciceronlogger.data.forretrofit.userrepo.GitHubUserRepoRepository
import com.meeweel.ciceronlogger.data.forretrofit.userrepo.GitHubUserRepoRepositoryImpl
import com.meeweel.ciceronlogger.data.room.userrepo.DBGitHubStorage
import dagger.Module
import dagger.Provides

@Module
class RepoRepositoryModule {

    @FragmentScope
    @Provides
    fun provideRepository(api: GitHubApi, dbStorage: DBGitHubStorage): GitHubUserRepoRepository {
        return GitHubUserRepoRepositoryImpl(api, dbStorage)
    }
}