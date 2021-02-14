package com.desafio.android.di

import com.desafio.android.features.pullrequests.repository.dao.PullRequestListLocalDataSource
import com.desafio.android.features.pullrequests.repository.dao.PullRequestListLocalDataSourceImpl
import com.desafio.android.features.pullrequests.repository.service.PullRequestListRemoteDataSource
import com.desafio.android.features.repositories.repository.dao.RepositoryListLocalDataSource
import com.desafio.android.features.repositories.repository.dao.RepositoryListLocalDataSourceImpl
import com.desafio.android.features.repositories.repository.service.RepositoryListRemoteDataSource
import org.koin.dsl.module

val dataSourceModule = module {
    single { RepositoryListRemoteDataSource(service = get()) }
    single { PullRequestListRemoteDataSource(service = get()) }
    factory<RepositoryListLocalDataSource> {
        RepositoryListLocalDataSourceImpl(dao = get())
    }
    factory<PullRequestListLocalDataSource> {
        PullRequestListLocalDataSourceImpl(dao = get())
    }
}