package com.desafio.android.features.pullrequests.repository.mappers

import com.desafio.android.commons.ext.orZero
import com.desafio.android.features.pullrequests.viewmodel.model.PullRequest
import com.desafio.android.features.pullrequests.viewmodel.model.User
import com.desafio.android.features.pullrequests.repository.model.api.PullRequestResponse
import com.desafio.android.features.pullrequests.repository.model.entities.PullRequestAndUser
import com.desafio.android.features.pullrequests.repository.model.entities.PullRequestEntity
import com.desafio.android.features.pullrequests.repository.model.entities.UserEntity

fun List<PullRequestResponse>.toPullRequestEntity(repository: String): List<PullRequestAndUser> =
    map {
        PullRequestAndUser(
            pullRequestEntity = PullRequestEntity(
                id = it.id.orZero(),
                repoName = repository,
                title = it.title.orEmpty(),
                body = it.body.orEmpty(),
                state = it.state.orEmpty()
            ),
            userEntity = UserEntity(
                idUser = it.user?.id.orZero(),
                login = it.user?.login.orEmpty(),
                avatarUrl = it.user?.avatarUrl.orEmpty()
            )
        )
    }

fun List<PullRequestAndUser>.toPullRequestList() = map {
    PullRequest(
        title = it.pullRequestEntity?.title.orEmpty(),
        body = it.pullRequestEntity?.body.orEmpty(),
        state = it.pullRequestEntity?.state.orEmpty(),
        user = it.userEntity?.toUser() ?: getUserEmpty()
    )
}

fun UserEntity.toUser() =
    User(
        login = login,
        avatarUrl = avatarUrl
    )

fun getUserEmpty() =
    User(
        login = "",
        avatarUrl = ""
    )