package com.example.hrayracbalibrary

import java.util.regex.Pattern

object Validator {

    private val validEmailAddressRegex =
        Pattern.compile("^(.+)@(.+)\$", Pattern.CASE_INSENSITIVE)

    //Minimum eight characters, at least one letter and one number:
    private val validPasswordRegex =
        Pattern.compile(
            "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}\$",
            Pattern.CASE_INSENSITIVE
        )

    fun isValidEmail(emailStr: String): Boolean {
        val matcher = validEmailAddressRegex.matcher(emailStr.trim())
        return matcher.find()
    }

    fun isValidPassword(password: String): Boolean {
        val matcher = validPasswordRegex.matcher(password.trim())
        return matcher.find()
    }
}