package com.desafio.android.base

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.desafio.android.helper.MainCoroutinesScopeRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule

abstract class TestUnitBase {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule
    val coroutinesScopeRule = MainCoroutinesScopeRule.create()

    @Before
    abstract fun setup()
}

