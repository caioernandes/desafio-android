package com.desafio.android.features.repositories.repository.service

import com.desafio.android.commons.base.BaseDataSource
import com.desafio.android.features.repositories.repository.model.api.RepositoryListResponse
import com.desafio.android.commons.network.Resource

class RepositoryListRemoteDataSource (
    private val service: RepositoryListService
) : BaseDataSource() {

    private val KEY_Q = "q"
    private val VALUE_Q = "language:Java"
    private val KEY_SORT = "sort"
    private val VALUE_SORT = "stars"
    private val KEY_PAGE = "page"

    suspend fun getRepositories(pageIndex: String): Resource<RepositoryListResponse> {
        return getResult { service.getRepositories(getQueryMap(pageIndex)) }
    }

    private fun getQueryMap(page: String): HashMap<String, String> {
        val queryMap: HashMap<String, String> = HashMap()
        queryMap[KEY_Q] = VALUE_Q
        queryMap[KEY_SORT] = VALUE_SORT
        queryMap[KEY_PAGE] = page
        return queryMap
    }
}