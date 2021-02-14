package com.desafio.android.features.repositories.repository

import androidx.lifecycle.LiveData
import com.desafio.android.features.repositories.repository.dao.RepositoryListLocalDataSource
import com.desafio.android.features.repositories.repository.mappers.toRepositoryEntity
import com.desafio.android.features.repositories.repository.mappers.toSearchRepositoriesEntity
import com.desafio.android.features.repositories.repository.model.entities.ResultDataWithListRepository
import com.desafio.android.features.repositories.repository.service.RepositoryListRemoteDataSource
import com.desafio.android.commons.network.Resource
import com.desafio.android.commons.ext.performGetOperation

class RepositoriesRepositoryImpl(
    private val remoteDataSource: RepositoryListRemoteDataSource,
    private val localDataSource: RepositoryListLocalDataSource
) : RepositoriesRepository {
    override fun getRepositories(pageIndex: String): LiveData<Resource<ResultDataWithListRepository>> {
        return performGetOperation(
            databaseQuery = {
                localDataSource.getResultRepositoryListLocalDataSource()
            },
            networkCall = {
                remoteDataSource.getRepositories(pageIndex)
            },
            saveCallResult = {
                localDataSource.insertFullResultDataListRepository(pageIndex,
                    ResultDataWithListRepository(
                        resultDataRepositoryListEntity = it.toSearchRepositoriesEntity(),
                        repositoryListEntity = it.items?.toRepositoryEntity() ?: emptyList()
                    )
                )
            }
        )
    }
}