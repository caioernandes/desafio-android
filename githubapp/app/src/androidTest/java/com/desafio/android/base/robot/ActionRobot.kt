package com.desafio.android.base.robot

import androidx.annotation.LayoutRes
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.desafio.android.features.repositories.view.adapter.RepositoryViewHolder
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.anything

open class ActionRobot {

    fun fillEditText(@LayoutRes resId: Int, text: String): ViewInteraction =
        onView(withId(resId)).perform(
            ViewActions.replaceText(text),
            ViewActions.closeSoftKeyboard()
        )

    fun clickButton(@LayoutRes resId: Int): ViewInteraction =
        onView((withId(resId))).perform(ViewActions.click())

    fun clickButton(text: String): ViewInteraction =
        onView((withText(text))).perform(ViewActions.click())

    fun clickListItem(@LayoutRes listRes: Int, position: Int) {
        onData(anything())
            .inAdapterView(allOf(withId(listRes)))
            .atPosition(position).perform(ViewActions.click())
    }

    fun recyclerViewScrollToItemPosition(@LayoutRes listRes: Int, position: Int) {
        onView(withId(listRes))
            .perform(
                RecyclerViewActions.scrollToPosition<RepositoryViewHolder>(position)
            )
    }
}


