package com.victor.financekotlinapp.extensions

import android.widget.Toast
import androidx.fragment.app.Fragment


fun Fragment.showToast(text: String) {
    Toast.makeText(
        context,
        text,
        Toast.LENGTH_SHORT
    ).show()
}


