package com.desafio.android.features.repositories.viewmodel.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Repository(
    val name: String,
    val description: String,
    val owner: Owner,
    val forksCount: Int,
    val stargazersCount: Int
): Parcelable