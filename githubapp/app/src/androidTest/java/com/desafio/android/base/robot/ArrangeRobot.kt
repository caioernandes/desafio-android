package com.desafio.android.base.robot

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.testing.launchFragmentInContainer
import com.desafio.android.R
import com.desafio.android.base.MockWebServerManager
import java.net.HttpURLConnection

open class ArrangeRobot(private val mockWebServerManager: MockWebServerManager? = null) {

    inline fun <reified T : Fragment> launchFragment(
        fragmentArgs: Bundle? = null,
        factory: FragmentFactory? = null
    ) {
        launchFragmentInContainer<T>(
            fragmentArgs = fragmentArgs,
            themeResId = R.style.Theme_GithubApp,
            factory = factory
        )
    }

    fun mockNetworkResponseSuccess(fileName: String) {
        mockWebServerManager?.mockNetworkResponseWithFileContent(
            fileName = fileName,
            responseCode = HttpURLConnection.HTTP_OK
        )
    }

    fun mockNetworkResponseInternalError(fileName: String) {
        mockWebServerManager?.mockNetworkResponseWithFileContent(
            fileName = fileName,
            responseCode = HttpURLConnection.HTTP_INTERNAL_ERROR
        )
    }
}


