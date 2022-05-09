package com.example.acbahrayrapplication.util

open class ResponseHandler {
    fun <T : Any?> handleSuccess(data: T): Response<T> {
        return Response.success(data)
    }

    fun <T : Any?> handleException(e: Exception): Response<T> {
        e.printStackTrace()

        return Response.error(e)
    }
}