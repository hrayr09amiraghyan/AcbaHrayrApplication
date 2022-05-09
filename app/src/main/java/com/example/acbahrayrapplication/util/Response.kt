package com.example.acbahrayrapplication.util

data class Response<out T>(
    val status: Status,
    val data: T?,
    val exception: Exception?
) {
    companion object {
        fun <T> success(data: T?): Response<T> {
            return Response(
                Status.SUCCESS,
                data,
                null
            )
        }
        fun <T> error(exception: Exception?): Response<T> {
            return Response(
                Status.ERROR,
                null,
                exception
            )
        }

        fun <T> loading(data: T?): Response<T> {
            return Response(
                Status.LOADING,
                data,
                null
            )
        }
    }
}