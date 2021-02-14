package com.desafio.android.features.pullrequests.repository

import androidx.lifecycle.LiveData
import com.desafio.android.features.pullrequests.repository.model.entities.PullRequestAndUser
import com.desafio.android.commons.network.Resource

interface PullRequestListRepository {
    fun getPullRequests(
        creatorRepository: String,
        repository: String
    ): LiveData<Resource<List<PullRequestAndUser>>>
}