package com.meeweel.ciceronlogger.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.meeweel.ciceronlogger.R
import com.meeweel.ciceronlogger.app.MainApp.Navigation.navigatorHolder
import com.meeweel.ciceronlogger.app.MainApp.Navigation.router
import com.meeweel.ciceronlogger.cicerone.CustomNavigator
import com.meeweel.ciceronlogger.cicerone.SignInScreen

class MainActivity : AppCompatActivity() {

    private val navigator = CustomNavigator(activity = this, R.id.container)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            router.newRootScreen(SignInScreen())
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}