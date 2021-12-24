package com.meeweel.ciceronlogger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.meeweel.ciceronlogger.app.MainApp
import com.meeweel.ciceronlogger.cicerone.CustomNavigator
import com.meeweel.ciceronlogger.cicerone.CustomRouter
import com.meeweel.ciceronlogger.githunusers.GitHubUsersScreen
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private val navigator = CustomNavigator(activity = this, R.id.container)

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var router: CustomRouter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MainApp.instance.component.inject(this)
        if (savedInstanceState == null) {
            router.newRootScreen(GitHubUsersScreen())
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