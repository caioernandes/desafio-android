package com.desafio.android.features.repositories.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.desafio.android.features.repositories.repository.RepositoriesRepository
import com.desafio.android.features.repositories.repository.model.entities.ResultDataWithListRepository
import com.desafio.android.commons.network.Resource

class RepositoryListViewModel(
    private val repository: RepositoriesRepository
) : ViewModel() {

    fun getRepositories(pageIndex: Int): LiveData<Resource<ResultDataWithListRepository>> =
        repository.getRepositories(pageIndex.toString())
}