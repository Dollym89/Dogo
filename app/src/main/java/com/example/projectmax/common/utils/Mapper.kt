package com.example.projectmax.common.utils

interface Mapper<From, Domain> {

    fun mapToDomain(from: From): Domain
}