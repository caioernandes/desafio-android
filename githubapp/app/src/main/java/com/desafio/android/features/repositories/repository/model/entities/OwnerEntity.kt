package com.desafio.android.features.repositories.repository.model.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class OwnerEntity(
    @PrimaryKey val idUser: Long = 0,
    var idPullRequest: Long = 0,
    val login: String = "",
    val avatarUrl: String = ""
) : Parcelable