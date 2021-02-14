package com.desafio.android.features.pullrequests.repository.service

import com.desafio.android.features.pullrequests.repository.model.api.PullRequestResponse
import com.desafio.android.util.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PullRequestListService {

    @GET(Constants.URL_PULLS)
    suspend fun getPullRequestsByRepository(
        @Path("creator") creatorRepository: String,
        @Path("repository") repository: String
    ): Response<List<PullRequestResponse>>
}