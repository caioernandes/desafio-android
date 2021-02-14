package com.desafio.android.features.pullrequests.repository.service

import com.desafio.android.commons.base.BaseDataSource
import com.desafio.android.features.pullrequests.repository.model.api.PullRequestResponse
import com.desafio.android.commons.network.Resource

class PullRequestListRemoteDataSource (
    private val service: PullRequestListService
) : BaseDataSource() {

    suspend fun getPullRequestsByRepository(
        creatorRepository: String,
        repository: String
    ): Resource<List<PullRequestResponse>> {
        return getResult { service.getPullRequestsByRepository(creatorRepository, repository) }
    }
}