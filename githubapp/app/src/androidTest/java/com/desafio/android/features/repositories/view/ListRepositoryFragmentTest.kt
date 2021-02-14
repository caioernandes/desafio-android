package com.desafio.android.features.repositories.view

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.desafio.android.base.InstrumentedTestBase
import com.desafio.android.features.repositories.view.robot.ListRepositoryFragmentActionRobot
import com.desafio.android.features.repositories.view.robot.ListRepositoryFragmentArrangeRobot
import com.desafio.android.features.repositories.view.robot.ListRepositoryFragmentAssertRobot
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ListRepositoryFragmentTest : InstrumentedTestBase() {

    private val arrange by lazy { ListRepositoryFragmentArrangeRobot(mockWebServer) }

    private val action by lazy { ListRepositoryFragmentActionRobot() }

    private val assert by lazy { ListRepositoryFragmentAssertRobot() }

    @Test
    fun test_recyclerview_elements_for_expected_response() {
        arrange {
            openListRepositoryFragment()
            mockNetworkSuccessResponseRepositories()
        }
        action {
            scrollToItemListRepository(1)
        }
        assert {
            itemListRepositoryNameIs("elasticsearch")
        }
    }
}
