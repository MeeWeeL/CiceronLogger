package com.meeweel.ciceronlogger.di

import android.content.Context
import com.meeweel.ciceronlogger.MainActivity
import com.meeweel.ciceronlogger.githubuser.di.GitHubUserComponent
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

    fun provideGitHubUserComponent(): GitHubUserComponent.Builder

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun setContext(context: Context): Builder
        fun build(): ApplicationComponent
    }


    fun inject(activity: MainActivity)
    fun inject(presenter: GitHubUsersPresenter)
}