package com.victor.financekotlinapp.extensions


fun String.trimBigMessage(maxCharacters: Int): String {
    val minCharacters = 0
    if (this.length > maxCharacters) {
        return "${this.substring(minCharacters, maxCharacters)}..."
    }

    return this
}