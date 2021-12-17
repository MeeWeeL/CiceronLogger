package com.meeweel.ciceronlogger.githubuser

import com.meeweel.ciceronlogger.data.forretrofit.GitHubUser
import com.meeweel.ciceronlogger.data.forretrofit.GitHubUserRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.BehaviorSubject
import moxy.MvpPresenter

class GitHubUserPresenter(
    private val userLogin: String,
    private val userRepository: GitHubUserRepository,
    private val subject: @NonNull BehaviorSubject<GitHubUser> = BehaviorSubject.create()
) : MvpPresenter<GitHubUserView>() {

    override fun onFirstViewAttach() {
        setSubject()
        userRepository
            .getUserByLogin(userLogin)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                subject.onNext(it)
            },{})
    }

    private fun setSubject() {
        subject
            .subscribe({
                viewState.showResult(it)
            },{})
    }
}