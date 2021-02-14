package com.desafio.android.di

import androidx.room.Room
import com.desafio.android.db.AppDatabase
import com.desafio.android.util.Constants
import org.koin.dsl.module

val roomTestModule = module {
    single {
        Room.databaseBuilder(get(), AppDatabase::class.java, Constants.DB_NAME)
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }
    single { get<AppDatabase>().repositoryListDao() }
    single { get<AppDatabase>().pullRequestListDao() }
}
