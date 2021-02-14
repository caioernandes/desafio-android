package com.desafio.android.features.repositories.repository.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class ResultDataRepositoryListEntity (
	@PrimaryKey val id: String = UUID.randomUUID().toString(),
	val totalCount : Int = 0,
	val incompleteResults : Boolean = false
)