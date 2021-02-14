package com.desafio.android.app

import com.desafio.android.App
import org.koin.core.module.Module

/**
 * Helps to configure required dependencies for Instrumented Tests.
 * Method provideDependency can be overrided and new dependencies can be supplied.
 */
class TestApp : App() {
    override fun provideDependency() = listOf<Module>()
}