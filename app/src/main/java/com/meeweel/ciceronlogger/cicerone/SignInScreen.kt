package com.meeweel.ciceronlogger.cicerone

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.meeweel.ciceronlogger.view.SingInFragment

class SignInScreen : FragmentScreen {

    override fun createFragment(factory: FragmentFactory): Fragment =
        SingInFragment.newInstance()

}