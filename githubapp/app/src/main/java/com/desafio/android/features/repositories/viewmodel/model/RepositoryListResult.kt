package com.desafio.android.features.repositories.viewmodel.model

data class RepositoryListResult(
    val totalCount: Int,
    val incompleteResults: Boolean,
    val items: List<Repository>
)