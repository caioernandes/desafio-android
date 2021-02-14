package com.desafio.android.di

import com.desafio.android.features.repositories.repository.service.RepositoryListService
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun configureNetworkForInstrumentationTest(urlBaseTestApi: String) = module {
    single {
        Retrofit.Builder()
            .baseUrl(urlBaseTestApi)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }
    factory{ get<Retrofit>().create(RepositoryListService::class.java) }
}

