package com.desafio.android.features.pullrequests.repository.dao

import androidx.lifecycle.LiveData
import com.desafio.android.features.pullrequests.repository.model.entities.PullRequestAndUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PullRequestListLocalDataSourceImpl(
    private val dao: PullRequestListDao
) : PullRequestListLocalDataSource {

    override fun getAllPullRequestsByRepository(repositoryName: String): LiveData<List<PullRequestAndUser>> {
        return dao.getAllPullRequestsByRepository(repositoryName)
    }

    override suspend fun insertAllPullRequestAndUser(data: List<PullRequestAndUser>) =
        withContext(Dispatchers.IO) {
            data.forEach {
                it.userEntity?.idPullRequest = it.pullRequestEntity?.id ?: 0
                it.pullRequestEntity?.let { pullRequestEntity ->
                    dao.insertPullRequest(pullRequestEntity)
                }
                it.userEntity?.let { userEntity ->
                    dao.insertUser(userEntity)
                }
            }
        }
}