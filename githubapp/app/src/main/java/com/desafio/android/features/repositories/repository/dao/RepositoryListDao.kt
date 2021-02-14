package com.desafio.android.features.repositories.repository.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.desafio.android.features.repositories.repository.model.entities.RepositoryEntity
import com.desafio.android.features.repositories.repository.model.entities.ResultDataRepositoryListEntity
import com.desafio.android.features.repositories.repository.model.entities.ResultDataWithListRepository

@Dao
abstract class RepositoryListDao {

    @Transaction
    @Query("SELECT * FROM ResultDataRepositoryListEntity")
    abstract fun getAllRepositories(): LiveData<ResultDataWithListRepository>

    @Transaction
    @Query("SELECT * FROM ResultDataRepositoryListEntity WHERE id = :id")
    abstract fun getAllRepositories(id: String): LiveData<ResultDataWithListRepository>

    fun insertFullResultDataListRepository(
        resultData: ResultDataRepositoryListEntity,
        repositoryListEntity: List<RepositoryEntity>
    ) {
        insertResultDataListRepository(resultData)
        insertListRepository(repositoryListEntity)
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertListRepository(listRepository: List<RepositoryEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertResultDataListRepository(searchRepositoriesEntity: ResultDataRepositoryListEntity)
}