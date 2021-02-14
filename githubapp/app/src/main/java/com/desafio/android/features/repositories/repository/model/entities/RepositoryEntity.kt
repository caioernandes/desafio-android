package com.desafio.android.features.repositories.repository.model.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class RepositoryEntity(
    @PrimaryKey val id: Long = 0,
    var resultDataId: String = UUID.randomUUID().toString(),
    val name: String = "",
    val description: String = "",
    @Embedded val owner: OwnerEntity? = OwnerEntity(),
    val forksCount: Int = 0,
    val stargazersCount: Int = 0
)