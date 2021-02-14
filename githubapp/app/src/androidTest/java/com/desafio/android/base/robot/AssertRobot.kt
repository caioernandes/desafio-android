package com.desafio.android.base.robot

import androidx.annotation.LayoutRes
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText

open class AssertRobot {

    fun viewWithText(resId: Int, text: String): ViewInteraction = matchText(textView(resId), text)

    fun viewWithTextIsVisible(text: String): ViewInteraction = onView(withText(text)).check(
        ViewAssertions.matches(
            ViewMatchers.isDisplayed()
        )
    )

    fun viewIsVisible(@LayoutRes resId: Int): ViewInteraction = textView(resId).check(
        ViewAssertions.matches(
            ViewMatchers.isDisplayed()
        )
    )

    private fun textView(@LayoutRes resId: Int): ViewInteraction = onView(withId(resId))

    private fun matchText(viewInteraction: ViewInteraction, text: String): ViewInteraction =
        viewInteraction.check(ViewAssertions.matches(withText(text)))
}