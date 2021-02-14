package com.desafio.android.di

import com.desafio.android.features.pullrequests.repository.PullRequestListRepository
import com.desafio.android.features.pullrequests.repository.PullRequestListRepositoryImpl
import com.desafio.android.features.repositories.repository.RepositoriesRepository
import com.desafio.android.features.repositories.repository.RepositoriesRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    factory<RepositoriesRepository>{
        RepositoriesRepositoryImpl(remoteDataSource = get(), localDataSource = get())
    }
    factory<PullRequestListRepository> {
        PullRequestListRepositoryImpl(remoteDataSource = get(), localDataSource = get())
    }
}