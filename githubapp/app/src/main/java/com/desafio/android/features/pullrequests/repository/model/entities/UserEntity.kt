package com.desafio.android.features.pullrequests.repository.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(
    @PrimaryKey val idUser: Long = 0,
    var idPullRequest: Long = 0,
    val login: String = "",
    val avatarUrl: String = ""
)