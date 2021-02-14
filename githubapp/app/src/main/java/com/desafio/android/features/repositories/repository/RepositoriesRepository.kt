package com.desafio.android.features.repositories.repository

import androidx.lifecycle.LiveData
import com.desafio.android.features.repositories.repository.model.entities.ResultDataWithListRepository
import com.desafio.android.commons.network.Resource

interface RepositoriesRepository {
    fun getRepositories(pageIndex: String): LiveData<Resource<ResultDataWithListRepository>>
}