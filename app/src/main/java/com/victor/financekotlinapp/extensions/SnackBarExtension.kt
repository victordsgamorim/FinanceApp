package com.victor.financekotlinapp.extensions

import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

fun Fragment.showSnackbar(snackbar: View, message: String, time: Int = Snackbar.LENGTH_SHORT) {
    Snackbar.make(
        snackbar,
        message,
        time
    ).show()

}