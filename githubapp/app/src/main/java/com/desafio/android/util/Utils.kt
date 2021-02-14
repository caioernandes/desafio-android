package com.desafio.android.util

import android.view.View
import androidx.annotation.NonNull
import androidx.annotation.StringRes
import com.google.android.material.snackbar.Snackbar

internal fun notify(@NonNull viewContainer: View, message: String) =
    Snackbar.make(viewContainer, message, Snackbar.LENGTH_LONG).show()

internal fun notify(@NonNull viewContainer: View, @StringRes message: Int) =
    Snackbar.make(viewContainer, message, Snackbar.LENGTH_LONG).show()