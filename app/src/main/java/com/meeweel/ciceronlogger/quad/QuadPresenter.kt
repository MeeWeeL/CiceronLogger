package com.meeweel.ciceronlogger.quad

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.BehaviorSubject
import moxy.MvpPresenter
import java.util.concurrent.TimeUnit

class QuadPresenter(
    private val subject: @NonNull BehaviorSubject<String> = BehaviorSubject.create()
) : MvpPresenter<QuadView>() {

    fun calculate(value: String) {
        subject.onNext(value)
    }

    override fun onFirstViewAttach() {
        setSubject()
    }

    private fun setSubject() {
        subject
            .map { getQuad(it) }
            .delay(1000,TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.io()) // ИО потому что вычисление не трудное
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.showResult(it)
            },{
                error()
            })
    }

    private fun getQuad(value: String): String {
        val userValue = value.toInt()
        val resultValue = userValue * userValue
        return resultValue.toString()
    }

    private fun error(text: String = "Error") {
        viewState.toast(text)
    }
}