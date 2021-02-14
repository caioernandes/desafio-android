package com.desafio.android.di

fun generateTestAppComponent(baseApi: String) = listOf(
    configureNetworkForInstrumentationTest(baseApi),
    roomTestModule,
    dataSourceModule,
    repositoryModule,
    viewModelModule
)

