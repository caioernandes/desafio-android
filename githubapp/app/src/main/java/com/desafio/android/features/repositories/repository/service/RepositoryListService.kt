package com.desafio.android.features.repositories.repository.service

import com.desafio.android.features.repositories.repository.model.api.RepositoryListResponse
import com.desafio.android.util.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface RepositoryListService {

    @GET(Constants.URL_REPOSITORIES)
    suspend fun getRepositories(@QueryMap queryMap: HashMap<String, String>): Response<RepositoryListResponse>
}