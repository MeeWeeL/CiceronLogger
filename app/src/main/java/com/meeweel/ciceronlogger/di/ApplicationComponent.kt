package com.meeweel.ciceronlogger.di

import android.content.Context
import com.meeweel.ciceronlogger.MainActivity
import com.meeweel.ciceronlogger.githubuser.GitHubUserPresenter
import com.meeweel.ciceronlogger.githunusers.GitHubUsersPresenter
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        CiceroneModule::class,
        RepositoryModule::class,
        RoomModule::class
    ]
)

interface ApplicationComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun setContext(context: Context): Builder
        fun build(): ApplicationComponent
    }

    fun inject(activity: MainActivity)
    fun inject(activity: GitHubUsersPresenter)
    fun inject(activity: GitHubUserPresenter)
}