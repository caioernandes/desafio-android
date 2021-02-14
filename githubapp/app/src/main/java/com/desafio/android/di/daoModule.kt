package com.desafio.android.di

import com.desafio.android.db.AppDatabase
import org.koin.dsl.module

val daoModule = module {
    single { AppDatabase.getDatabase(get()) }
    single { get<AppDatabase>().repositoryListDao() }
    single { get<AppDatabase>().pullRequestListDao() }
}