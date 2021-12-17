package com.meeweel.ciceronlogger.singin

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.meeweel.ciceronlogger.R
import com.meeweel.ciceronlogger.app.MainApp.Navigation.router
import com.meeweel.ciceronlogger.data.repository.UserRepositoryFactory
import com.meeweel.ciceronlogger.databinding.SignInFragmentLayoutBinding
import com.meeweel.ciceronlogger.data.UserModel
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class SingInFragment : MvpAppCompatFragment(R.layout.sign_in_fragment_layout), SignInView {

    private val presenter: SignInPresenter by moxyPresenter {
        SignInPresenter(
            userRepository = UserRepositoryFactory.create(),
            router = router
        )
    }

    private lateinit var viewBinging: SignInFragmentLayoutBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinging = SignInFragmentLayoutBinding.bind(view)
        viewBinging.nextBtn.setOnClickListener {
            val login: String = viewBinging.inputEditText.text.toString()
            val password: String = viewBinging.passwordInputEditText.text.toString()
            val user = UserModel(login, password)
            presenter.tryToSignIn(user)
        }
    }

    override fun toastError(text: String) {
        Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()
    }

    companion object {
        fun newInstance(): Fragment = SingInFragment()
    }

}