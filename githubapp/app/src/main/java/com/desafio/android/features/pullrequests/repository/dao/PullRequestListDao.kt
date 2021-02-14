package com.desafio.android.features.pullrequests.repository.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.desafio.android.features.pullrequests.repository.model.entities.PullRequestAndUser
import com.desafio.android.features.pullrequests.repository.model.entities.PullRequestEntity
import com.desafio.android.features.pullrequests.repository.model.entities.UserEntity

@Dao
abstract class PullRequestListDao {

    @Transaction
    @Query("SELECT * FROM PullRequestEntity WHERE repoName = :repositoryName")
    abstract fun getAllPullRequestsByRepository(repositoryName: String): LiveData<List<PullRequestAndUser>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertUser(userEntity: UserEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertPullRequest(pullRequestEntity: PullRequestEntity)
}