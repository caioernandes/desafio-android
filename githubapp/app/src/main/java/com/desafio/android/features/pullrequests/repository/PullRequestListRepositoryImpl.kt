package com.desafio.android.features.pullrequests.repository

import androidx.lifecycle.LiveData
import com.desafio.android.features.pullrequests.repository.dao.PullRequestListLocalDataSource
import com.desafio.android.features.pullrequests.repository.mappers.toPullRequestEntity
import com.desafio.android.features.pullrequests.repository.model.entities.PullRequestAndUser
import com.desafio.android.features.pullrequests.repository.service.PullRequestListRemoteDataSource
import com.desafio.android.commons.network.Resource
import com.desafio.android.commons.ext.performGetOperation

class PullRequestListRepositoryImpl(
    private val localDataSource: PullRequestListLocalDataSource,
    private val remoteDataSource: PullRequestListRemoteDataSource
) : PullRequestListRepository {
    override fun getPullRequests(
        creatorRepository: String,
        repository: String
    ): LiveData<Resource<List<PullRequestAndUser>>> = performGetOperation(
        databaseQuery = {
            localDataSource.getAllPullRequestsByRepository(repository)
        },
        networkCall = {
            remoteDataSource.getPullRequestsByRepository(creatorRepository, repository)
        },
        saveCallResult = {
            val dataMapped: List<PullRequestAndUser> = it.toPullRequestEntity(repository)
            localDataSource.insertAllPullRequestAndUser(dataMapped)
        }
    )
}