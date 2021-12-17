package com.meeweel.ciceronlogger.githunusers

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.meeweel.ciceronlogger.R
import com.meeweel.ciceronlogger.app.MainApp.Navigation.router
import com.meeweel.ciceronlogger.data.forretrofit.GitHubUserRepositoryFactory
import com.meeweel.ciceronlogger.databinding.GithubChooseUserLayoutBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class GitHubUsersFragment : MvpAppCompatFragment(R.layout.github_choose_user_layout), GitHubUsersView {

    lateinit var listener: View.OnClickListener
    private val presenter: GitHubUsersPresenter by moxyPresenter {
        GitHubUsersPresenter(
            userRepository = GitHubUserRepositoryFactory.create(),
            router = router
        )
    }

    private lateinit var viewBinging: GithubChooseUserLayoutBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinging = GithubChooseUserLayoutBinding.bind(view)
        setListener()
        viewBinging.nextBtn.setOnClickListener(listener)
        viewBinging.backBtn.setOnClickListener(listener)
        viewBinging.goBtn.setOnClickListener(listener)
    }

    private fun setListener() {
        listener = View.OnClickListener { view ->
            when (view.id) {
                R.id.back_btn -> presenter.back()
                R.id.next_btn -> presenter.next()
                R.id.go_btn -> presenter.go()
            }
        }
    }
    override fun setName(name: String) {
        viewBinging.userName.text = name
    }

    override fun toastError(text: String) {
        Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()
    }

    companion object {
        fun newInstance(): Fragment = GitHubUsersFragment()
    }

}