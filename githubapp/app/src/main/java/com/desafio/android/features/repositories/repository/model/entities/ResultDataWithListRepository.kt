package com.desafio.android.features.repositories.repository.model.entities

import androidx.room.Embedded
import androidx.room.Relation

data class ResultDataWithListRepository(
    @Embedded val resultDataRepositoryListEntity: ResultDataRepositoryListEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "resultDataId"
    )
    val repositoryListEntity: List<RepositoryEntity>
)