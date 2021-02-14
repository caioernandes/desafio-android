package com.desafio.android.features.pullrequests.repository.dao

import androidx.lifecycle.LiveData
import com.desafio.android.features.pullrequests.repository.model.entities.PullRequestAndUser

interface PullRequestListLocalDataSource {
    fun getAllPullRequestsByRepository(repositoryName: String): LiveData<List<PullRequestAndUser>>
    suspend fun insertAllPullRequestAndUser(data: List<PullRequestAndUser>)
}