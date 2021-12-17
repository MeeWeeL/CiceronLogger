package com.meeweel.ciceronlogger.githubuser

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.meeweel.ciceronlogger.R
import com.meeweel.ciceronlogger.data.forretrofit.GitHubUser
import com.meeweel.ciceronlogger.data.forretrofit.GitHubUserRepositoryFactory
import com.meeweel.ciceronlogger.databinding.GithubUserInfoLayoutBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class GitHubUserFragment : MvpAppCompatFragment(R.layout.github_user_info_layout),
    GitHubUserView {

    private val userId: String by lazy {
        arguments?.getString(ARG_USER_LOGIN).orEmpty()
    }
    private val presenter: GitHubUserPresenter by moxyPresenter {
        GitHubUserPresenter(
            userId.toInt(),
            userRepository = GitHubUserRepositoryFactory.create()
        )
    }

    private lateinit var viewBinging: GithubUserInfoLayoutBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinging = GithubUserInfoLayoutBinding.bind(view)
    }

    override fun toastError(text: String) {
        Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()
    }

    override fun showResult(user: GitHubUser) {
        viewBinging.userLink.text = user.url
        viewBinging.userName.text = user.login
        Glide.with(viewBinging.userPhoto.context)
            .load(user.avatarUrl)
            .into(viewBinging.userPhoto)
    }

    companion object {
        private const val ARG_USER_LOGIN = "arg_user_login"
        fun newInstance(userId: String): Fragment =
            GitHubUserFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_USER_LOGIN, userId)
                }
            }
    }
}