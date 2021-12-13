package com.meeweel.ciceronlogger.singin

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

class SignInScreen : FragmentScreen {

    override fun createFragment(factory: FragmentFactory): Fragment =
        SingInFragment.newInstance()

}