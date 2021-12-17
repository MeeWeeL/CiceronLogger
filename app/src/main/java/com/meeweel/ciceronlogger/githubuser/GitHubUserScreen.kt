package com.meeweel.ciceronlogger.githubuser

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

class GitHubUserScreen(private val userId: String) : FragmentScreen {

    override fun createFragment(factory: FragmentFactory): Fragment =
        GitHubUserFragment.newInstance(userId)

}