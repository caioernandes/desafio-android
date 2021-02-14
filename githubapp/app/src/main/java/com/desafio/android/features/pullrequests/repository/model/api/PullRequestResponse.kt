package com.desafio.android.features.pullrequests.repository.model.api

import com.google.gson.annotations.SerializedName

data class PullRequestResponse(
    @SerializedName("id") val id: Long?,
    @SerializedName("title") val title: String?,
    @SerializedName("body") val body: String?,
    @SerializedName("state") val state: String?,
    @SerializedName("user") val user: UserResponse?
)