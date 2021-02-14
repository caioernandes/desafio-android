package com.desafio.android.features.pullrequests.viewmodel

import androidx.lifecycle.MutableLiveData
import com.desafio.android.base.TestUnitBase
import com.desafio.android.commons.network.Resource
import com.desafio.android.features.pullrequests.repository.PullRequestListRepository
import com.desafio.android.helper.mockCreatorRepository
import com.desafio.android.helper.mockRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class PullRequestListViewModelTest: TestUnitBase() {

    @InjectMockKs
    internal lateinit var viewModelTest: PullRequestListViewModel

    @MockK
    internal lateinit var repositoryTest: PullRequestListRepository

    @Test
    fun `on call function getPullRequests should call repository once`() {
        coEvery {
            repositoryTest.getPullRequests(mockCreatorRepository, mockRepository)
        } returns MutableLiveData(Resource.success(mockk()))

        viewModelTest.loadPullRequests(mockCreatorRepository, mockRepository)

        coVerify(exactly = 1) {
            repositoryTest.getPullRequests(mockCreatorRepository, mockRepository)
        }
    }

    override fun setup() {
        MockKAnnotations.init(this)
    }
}