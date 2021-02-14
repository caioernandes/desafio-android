package com.desafio.android.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.desafio.android.features.pullrequests.repository.dao.PullRequestListDao
import com.desafio.android.features.pullrequests.repository.model.entities.PullRequestEntity
import com.desafio.android.features.repositories.repository.model.entities.RepositoryEntity
import com.desafio.android.features.repositories.repository.model.entities.ResultDataRepositoryListEntity
import com.desafio.android.features.pullrequests.repository.model.entities.UserEntity
import com.desafio.android.features.repositories.repository.dao.RepositoryListDao
import com.desafio.android.util.Constants
import com.desafio.android.BuildConfig

@Database(
    entities = [
        PullRequestEntity::class,
        RepositoryEntity::class,
        ResultDataRepositoryListEntity::class,
        UserEntity::class
    ],
    version = BuildConfig.VERSION_CODE,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun repositoryListDao(): RepositoryListDao
    abstract fun pullRequestListDao(): PullRequestListDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase =
            instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { appDatabase ->
                    instance = appDatabase
                }
            }

        private fun buildDatabase(appContext: Context): AppDatabase {
            return Room.databaseBuilder(appContext, AppDatabase::class.java, Constants.DB_NAME)
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}