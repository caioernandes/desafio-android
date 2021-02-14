package com.desafio.android.features.repositories.repository.model.api

import com.google.gson.annotations.SerializedName

data class RepositoryResponse(
    @SerializedName("id") val id: Long?,
    @SerializedName("name") val name: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("owner") val owner: OwnerResponse?,
    @SerializedName("forks_count") val forksCount: Int?,
    @SerializedName("stargazers_count") val stargazersCount: Int?
)