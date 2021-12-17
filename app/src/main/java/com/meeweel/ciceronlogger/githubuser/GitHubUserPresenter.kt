package com.meeweel.ciceronlogger.githubuser

import com.meeweel.ciceronlogger.data.forretrofit.GitHubUser
import com.meeweel.ciceronlogger.data.forretrofit.GitHubUserRepository
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.subjects.BehaviorSubject
import moxy.MvpPresenter

class GitHubUserPresenter(
    private val userId: Int,
    private val userRepository: GitHubUserRepository,
    private val subject: @NonNull BehaviorSubject<GitHubUser> = BehaviorSubject.create()
) : MvpPresenter<GitHubUserView>() {

    override fun onFirstViewAttach() {
        setSubject()
        userRepository
            .getUsers()
            .subscribe({
                subject.onNext(it[userId-1])
            },{})
    }

    private fun setSubject() {
        subject
            .subscribe({
                viewState.showResult(it)
            },{})
    }
}