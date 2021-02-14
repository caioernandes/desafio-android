package com.desafio.android.features.repositories.repository.dao

import androidx.lifecycle.LiveData
import com.desafio.android.features.repositories.repository.model.entities.ResultDataWithListRepository

interface RepositoryListLocalDataSource {
    fun getResultRepositoryListLocalDataSource(): LiveData<ResultDataWithListRepository>
    suspend fun insertFullResultDataListRepository(pageIndex: String, data: ResultDataWithListRepository)
}