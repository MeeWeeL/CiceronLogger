package com.meeweel.ciceronlogger.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.meeweel.ciceronlogger.R
import com.meeweel.ciceronlogger.app.MainApp.Navigation.router
import com.meeweel.ciceronlogger.cicerone.UserRepositoryFactory
import com.meeweel.ciceronlogger.cicerone.UserView
import com.meeweel.ciceronlogger.databinding.MainFragmentLayoutBinding
import com.meeweel.ciceronlogger.model.UserModel
import com.meeweel.ciceronlogger.presenter.MainPresenter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class MainFragment : MvpAppCompatFragment(R.layout.main_fragment_layout), UserView {

    private val presenter: MainPresenter by moxyPresenter {
        MainPresenter(
            userRepository = UserRepositoryFactory.create(),
            router = router
        )
    }

    private lateinit var viewBinging: MainFragmentLayoutBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinging = MainFragmentLayoutBinding.bind(view)
        viewBinging.text.text = presenter.getUser()?.login.toString()
    }


    companion object {
        fun newInstance(): Fragment = MainFragment()
    }

    override fun showUser(user: UserModel) {
        viewBinging.text.text = user.login
    }
}