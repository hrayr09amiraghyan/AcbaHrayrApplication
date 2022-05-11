package com.example.acbahrayrapplication.data.converter

interface DtoUIModelConverter<T, R> {
    fun dtoToModel(dtoObject: T): R
}