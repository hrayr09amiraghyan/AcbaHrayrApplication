package com.example.hrayracbalibrary

import java.util.regex.Pattern

object Validator {

    private val validEmailAddressRegex =
        Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE)

    private val validPasswordAddressRegex =
        Pattern.compile(
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–{}]:;',?/*~\$^+=<>]).{8,20}\$",
            Pattern.CASE_INSENSITIVE
        )

    fun isValidEmail(emailStr: String): Boolean {
        val matcher = validEmailAddressRegex.matcher(emailStr)
        return matcher.find()
    }

    fun isValidPassword(password: String): Boolean {
        val matcher = validPasswordAddressRegex.matcher(password)
        return matcher.find()
    }
}