package com.example.projectmax.feature.dog.common.repository

import com.example.projectmax.feature.dog.common.domain.Dog
import com.example.projectmax.feature.dog.common.repository.gateway.DogDtoMapper

interface DogRepository {
    val dogList: List<Dog>
    suspend fun getDogs(): List<Dog>
}

class DogRepositoryImpl(
    private val dogService: DogService,
    private val mapper: DogDtoMapper
) : DogRepository {

    override var dogList: List<Dog> = listOf()

    override suspend fun getDogs(): List<Dog> {
        dogList = mapper.mapToDomain(dogService.getDogs())
        return dogList
    }
}