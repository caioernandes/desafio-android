package com.desafio.android.di

import com.desafio.android.features.pullrequests.viewmodel.PullRequestListViewModel
import com.desafio.android.features.repositories.viewmodel.RepositoryListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { RepositoryListViewModel(repository = get()) }
    viewModel { PullRequestListViewModel(repository = get()) }
}