package com.desafio.android.base

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.desafio.android.di.generateTestAppComponent
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.koin.core.context.loadKoinModules
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest

abstract class InstrumentedTestBase : KoinTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    val mockWebServer by lazy { MockWebServerManager() }

    @Before
    fun start() {
        with(mockWebServer) {
            setUp()
            loadKoinModules(generateTestAppComponent(getMockWebServerUrl()).toList())
        }
    }

    @After
    fun after() {
        stopKoin()
    }
}