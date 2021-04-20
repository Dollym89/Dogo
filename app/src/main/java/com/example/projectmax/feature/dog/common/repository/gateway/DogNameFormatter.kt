package com.example.projectmax.feature.dog.common.repository.gateway

interface Formatter<D, V> {
    fun format(domainModel: D): V
}

interface ToStringFormatter<T> : Formatter<T, String>

class DogNameFormatter() : ToStringFormatter<String> {
    override fun format(domainModel: String): String {
        return domainModel
            .replace("https://images.dog.ceo/breeds/", "")
            .substringBefore("/")
            .toUpperCase()
    }
}