package com.desafio.android.features.pullrequests.repository.model.entities

import androidx.room.Embedded
import androidx.room.Relation

data class PullRequestAndUser(
    @Embedded val pullRequestEntity: PullRequestEntity?,
    @Relation(
        parentColumn = "id",
        entityColumn = "idPullRequest"
    )
    val userEntity: UserEntity?
)