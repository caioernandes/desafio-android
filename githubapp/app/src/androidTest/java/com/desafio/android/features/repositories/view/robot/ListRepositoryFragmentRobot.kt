package com.desafio.android.features.repositories.view.robot

import com.desafio.android.R
import com.desafio.android.base.robot.ActionRobot
import com.desafio.android.base.robot.ArrangeRobot
import com.desafio.android.base.robot.AssertRobot
import com.desafio.android.base.MockWebServerManager
import com.desafio.android.features.repositories.view.ListRepositoryFragment
import com.desafio.android.helpers.ResponseWrapper

class ListRepositoryFragmentArrangeRobot(
    private val mockWebServerManager: MockWebServerManager
) : ArrangeRobot(mockWebServerManager) {

    operator fun invoke(func: ListRepositoryFragmentArrangeRobot.() -> Unit) =
        ListRepositoryFragmentArrangeRobot(mockWebServerManager).apply { func() }

    fun openListRepositoryFragment() {
        launchFragment<ListRepositoryFragment>()
    }

    fun mockNetworkSuccessResponseRepositories() {
        mockNetworkResponseSuccess(ResponseWrapper.LIST_REPOSITORY_SUCCESS.path)
    }
}

class ListRepositoryFragmentActionRobot : ActionRobot() {

    operator fun invoke(func: ListRepositoryFragmentActionRobot.() -> Unit) =
        ListRepositoryFragmentActionRobot().apply { func() }

    fun scrollToItemListRepository(position: Int) {
        recyclerViewScrollToItemPosition(R.id.recyclerViewListRepository, position)
    }
}

class ListRepositoryFragmentAssertRobot : AssertRobot() {

    operator fun invoke(func: ListRepositoryFragmentAssertRobot.() -> Unit) =
        ListRepositoryFragmentAssertRobot().apply { func() }

    fun itemListRepositoryNameIs(text: String) = viewWithTextIsVisible(text)
}

