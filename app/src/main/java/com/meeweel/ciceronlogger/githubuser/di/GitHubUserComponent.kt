package com.meeweel.ciceronlogger.githubuser.di

import com.meeweel.ciceronlogger.githubuser.GitHubUserPresenter
import dagger.Subcomponent
import javax.inject.Scope

@FragmentScope
@Subcomponent(
    modules = [
        GitHubUserRoomModule::class,
        RepoRepositoryModule::class
    ]
)
interface GitHubUserComponent {

    @Subcomponent.Builder
    interface Builder {
        fun build(): GitHubUserComponent
    }

    fun inject(activity: GitHubUserPresenter)
}

@Scope
annotation class FragmentScope