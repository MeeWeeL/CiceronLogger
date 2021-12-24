package com.meeweel.ciceronlogger.user

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.meeweel.ciceronlogger.R
import com.meeweel.ciceronlogger.cicerone.CustomRouter
import com.meeweel.ciceronlogger.data.repository.UserRepositoryFactory
import com.meeweel.ciceronlogger.databinding.MainFragmentLayoutBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class UserFragment : MvpAppCompatFragment(R.layout.main_fragment_layout), UserView {

    @Inject
    lateinit var router: CustomRouter
    private val presenter: UserPresenter by moxyPresenter {
        UserPresenter(
            userRepository = UserRepositoryFactory.create(),
            router = router
        )
    }

    private lateinit var viewBinging: MainFragmentLayoutBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinging = MainFragmentLayoutBinding.bind(view)
        presenter.getUser()
    }


    companion object {
        fun newInstance(): Fragment = UserFragment()
    }

    override fun showUser(user: String) {

        viewBinging.text.text = user
    }
}