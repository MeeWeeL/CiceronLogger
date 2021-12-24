package com.meeweel.ciceronlogger.di

import com.meeweel.ciceronlogger.data.forretrofit.GitHubApi
import com.meeweel.ciceronlogger.data.forretrofit.GitHubUserRepository
import com.meeweel.ciceronlogger.data.forretrofit.GitHubUserRepositoryImpl
import com.meeweel.ciceronlogger.data.room.DBStorage
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideRepository(api: GitHubApi, dbStorage: DBStorage): GitHubUserRepository {
        return GitHubUserRepositoryImpl(api, dbStorage)
    }
}