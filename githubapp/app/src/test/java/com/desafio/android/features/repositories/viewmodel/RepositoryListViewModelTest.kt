package com.desafio.android.features.repositories.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.desafio.android.commons.network.Resource
import com.desafio.android.features.repositories.repository.RepositoriesRepository
import com.desafio.android.helper.MainCoroutinesScopeRule
import com.desafio.android.helper.pageIndexInt
import com.desafio.android.helper.pageIndexString
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class RepositoryListViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @InjectMockKs
    internal lateinit var viewModelTest: RepositoryListViewModel

    @MockK
    internal lateinit var repositoryTest: RepositoriesRepository

    @ExperimentalCoroutinesApi
    @get:Rule
    val coroutinesScopeRule = MainCoroutinesScopeRule.create()

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `on call function getRepositories should call repository once`() {
        coEvery {
            repositoryTest.getRepositories(pageIndexString)
        } returns MutableLiveData(Resource.success(mockk()))

        viewModelTest.getRepositories(pageIndexInt)

        coVerify(exactly = 1) {
            repositoryTest.getRepositories(pageIndexString)
        }
    }
}