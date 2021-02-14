package com.desafio.android.features.repositories.repository.model.api

import com.google.gson.annotations.SerializedName

data class RepositoryListResponse (
	@SerializedName("total_count") val totalCount : Int?,
	@SerializedName("incomplete_results") val incompleteResults : Boolean?,
	@SerializedName("items") val items : List<RepositoryResponse>?
)