package com.meeweel.ciceronlogger.di

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.meeweel.ciceronlogger.githubuser.di.GitHubUserComponent
import com.meeweel.ciceronlogger.cicerone.CustomRouter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [GitHubUserComponent::class])
class CiceroneModule {

    var cicerone: Cicerone<CustomRouter> = Cicerone.create(CustomRouter())

    @Provides
    fun cicerone(): Cicerone<CustomRouter> = cicerone

    @Singleton
    @Provides
    fun navigatorHolder(): NavigatorHolder = cicerone.getNavigatorHolder()

    @Singleton
    @Provides
    fun router(): CustomRouter = cicerone.router


}