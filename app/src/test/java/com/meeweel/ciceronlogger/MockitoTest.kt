package com.meeweel.ciceronlogger

import com.meeweel.ciceronlogger.cicerone.CustomRouter
import com.meeweel.ciceronlogger.data.repository.UserRepository
import com.meeweel.ciceronlogger.user.UserPresenter
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class MockitoTest {

    private lateinit var presenter: UserPresenter

    @Mock
    private lateinit var repository: UserRepository

    @Mock
    private lateinit var router: CustomRouter

    @Before
    fun setUp() {

        MockitoAnnotations.initMocks(this)
        presenter = UserPresenter(repository, router)
    }

    @Test
    fun getUsers_Test() {

        Mockito.`when`(repository.getUser()).thenReturn(Observable.just("Moon"))

        presenter.getUser()
        presenter.getUser()
        presenter.getUser()

        Mockito.verify(repository, Mockito.atLeast(2)).getUser()
    }

    @Test
    fun getUser_Test() {

        Mockito.`when`(repository.getUser()).thenReturn(Observable.just("MoonLight"))

        repository.getUser()
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe({
                Assert.assertEquals("MoonLight", it)
            },{})
    }

    @Test
    fun moki_Test() {

        val mok = Mockito.mock(SuperMok::class.java)
        Mockito.`when`(mok.get()).thenReturn("MoonLight").thenReturn("Moon")

        Assert.assertEquals("MoonLight", mok.get())
        Assert.assertEquals("Moon", mok.get())
    }

    interface SuperMok {
        fun get() : String
    }
}