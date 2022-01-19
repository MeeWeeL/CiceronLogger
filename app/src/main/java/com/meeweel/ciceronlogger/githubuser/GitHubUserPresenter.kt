package com.meeweel.ciceronlogger.githubuser

import com.meeweel.ciceronlogger.data.forretrofit.GitHubUser
import com.meeweel.ciceronlogger.data.forretrofit.userrepo.GitHubUserRepoRepository
import com.meeweel.ciceronlogger.data.forretrofit.GitHubUserRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.BehaviorSubject
import moxy.MvpPresenter
import javax.inject.Inject

class GitHubUserPresenter(
    private val userLogin: String,
    private val subject: @NonNull BehaviorSubject<GitHubUser> = BehaviorSubject.create()
    ) : MvpPresenter<GitHubUserView>() {

    @Inject
    lateinit var userRepository: GitHubUserRepository

    @Inject
    lateinit var userRepoRepository: GitHubUserRepoRepository




    override fun onFirstViewAttach() {
        setSubject()
        userRepository
            .getUserByLogin(userLogin)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                viewState.setProgressBar(true)
            }
            .doFinally {
                viewState.setProgressBar(false)
            }
            .subscribe({
                subject.onNext(it)
            },{
                viewState.toastError(it.message.toString())
            })
    }

    private fun setSubject() {
        subject
            .subscribe({
                userRepoRepository.getUserByLogin(it.login!!)
                viewState.showResult(it)
            },{})
    }
}