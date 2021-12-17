package com.meeweel.ciceronlogger.githunusers

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

class GitHubUsersScreen : FragmentScreen {

    override fun createFragment(factory: FragmentFactory): Fragment =
        GitHubUsersFragment.newInstance()

}