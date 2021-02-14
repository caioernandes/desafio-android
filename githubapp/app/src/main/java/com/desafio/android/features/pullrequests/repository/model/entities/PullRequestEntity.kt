package com.desafio.android.features.pullrequests.repository.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PullRequestEntity(
    @PrimaryKey val id: Long = 0,
    val repoName: String = "",
    val title: String = "",
    val body: String = "",
    val state: String = ""
)