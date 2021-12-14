package com.meeweel.ciceronlogger.user

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.meeweel.ciceronlogger.user.UserFragment

class UserScreen : FragmentScreen {

    override fun createFragment(factory: FragmentFactory): Fragment =
        UserFragment.newInstance()

}