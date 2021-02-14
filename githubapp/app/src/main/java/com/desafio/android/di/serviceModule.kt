package com.desafio.android.di

import com.desafio.android.BuildConfig
import com.desafio.android.features.pullrequests.repository.service.PullRequestListService
import com.desafio.android.features.repositories.repository.service.RepositoryListService
import com.desafio.android.commons.network.AuthInterceptor
import com.desafio.android.commons.network.NetworkService
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val serviceModule = module {
    single { AuthInterceptor() }
    single { provideOkHttpClient(get()) }
    single { provideRetrofit(get()) }
    factory { provideRepositoryListService(get()) }
    factory { providePullRequestListService(get()) }
    single { NetworkService(get()) }
}

fun provideOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
    return OkHttpClient().newBuilder().addInterceptor(authInterceptor).build()
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(BuildConfig.API_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun provideRepositoryListService(retrofit: Retrofit): RepositoryListService {
    return retrofit.create(RepositoryListService::class.java)
}

fun providePullRequestListService(retrofit: Retrofit): PullRequestListService {
    return retrofit.create(PullRequestListService::class.java)
}
