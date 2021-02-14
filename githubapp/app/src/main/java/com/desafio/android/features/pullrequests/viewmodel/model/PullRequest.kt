package com.desafio.android.features.pullrequests.viewmodel.model

data class PullRequest(
    val title: String,
    val body: String,
    val state: String,
    val user: User
)