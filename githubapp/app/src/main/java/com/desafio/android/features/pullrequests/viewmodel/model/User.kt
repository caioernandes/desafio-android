package com.desafio.android.features.pullrequests.viewmodel.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val login: String,
    val avatarUrl: String
): Parcelable