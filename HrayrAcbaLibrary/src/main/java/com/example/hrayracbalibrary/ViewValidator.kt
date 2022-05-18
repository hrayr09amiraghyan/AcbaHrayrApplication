package com.example.hrayracbalibrary

interface ViewValidator {

    fun validate(): Boolean
    fun setDeafaultState()
    fun setErrorSate(errorMessage: String)
}