package com.victor.financekotlinapp.extensions

import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputLayout

fun Fragment.getEditTextString(inputLayout: TextInputLayout): String {
    val editTextFiel = inputLayout.editText
        ?: throw NullPointerException("EditText value is null")
    val editTextValue = editTextFiel.text.toString()

    return editTextValue
}