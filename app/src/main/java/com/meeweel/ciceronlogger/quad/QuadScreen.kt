package com.meeweel.ciceronlogger.quad

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

class QuadScreen : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment =
        QuadFragment.newInstance()
}