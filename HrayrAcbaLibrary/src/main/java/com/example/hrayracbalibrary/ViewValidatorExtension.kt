package com.example.hrayracbalibrary

import android.util.Patterns
import java.util.regex.Pattern

fun String.validateEmail(): Boolean = Patterns.EMAIL_ADDRESS.matcher(this).matches()
fun String.validatePassword(): Boolean = isValidPassword(this)

private val validPasswordRegex =
    Pattern.compile(
        "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}\$",
        Pattern.CASE_INSENSITIVE
    )

private fun isValidPassword(password: String): Boolean {
    val matcher = validPasswordRegex.matcher(password.trim())
    return matcher.find()
}