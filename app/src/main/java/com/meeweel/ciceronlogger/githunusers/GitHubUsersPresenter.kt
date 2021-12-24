package com.meeweel.ciceronlogger.githunusers

import com.meeweel.ciceronlogger.cicerone.CustomRouter
import com.meeweel.ciceronlogger.data.forretrofit.GitHubUserRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.BehaviorSubject
import moxy.MvpPresenter
import javax.inject.Inject

class GitHubUsersPresenter(
    private val subject: @NonNull BehaviorSubject<String> = BehaviorSubject.create()
) : MvpPresenter<GitHubUsersView>() {

    @Inject
    lateinit var userRepository: GitHubUserRepository

    @Inject
    lateinit var router: CustomRouter

    var focusedLogin = ""
    var id = 1
    private var length = 0

    fun next() {
        if (id < length) {
            id++
            findUser(id)
        }
    }

    fun back() {
        if (id > 1) {
            id--
            findUser(id)
        }
    }

    fun go() {
        router.openSecondLink(focusedLogin)
    }

    override fun onFirstViewAttach() {
        setSubject()
        userRepository
            .getUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                length = it.size
        },{})
        findUser(id)
    }

    private fun setSubject() {
        subject
            .subscribe({ login ->
                viewState.setName(login)
            },{})
    }

    private fun findUser(id: Int) {
        userRepository
            .getUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ list ->
                for (item in list) {
                    if (item.id == id.toString()) {
                        focusedLogin = item.login.toString()
                        subject.onNext(focusedLogin)
                    }
                }

            },{})
    }
}