package com.desafio.android.features.pullrequests.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.desafio.android.features.pullrequests.repository.PullRequestListRepository
import com.desafio.android.features.pullrequests.repository.model.entities.PullRequestAndUser
import com.desafio.android.commons.network.Resource

class PullRequestListViewModel(
    private val repository: PullRequestListRepository
) : ViewModel() {

    fun loadPullRequests(
        creatorRepository: String,
        repositoryName: String
    ): LiveData<Resource<List<PullRequestAndUser>>> {
        return repository.getPullRequests(creatorRepository, repositoryName)
    }
}