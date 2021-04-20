package com.example.projectmax.feature.dog.common.repository.gateway

import com.example.projectmax.common.utils.Mapper
import com.example.projectmax.feature.dog.common.domain.Dog
import com.example.projectmax.feature.dog.common.repository.resources.DogDto

class DogDtoMapper(
    private val dogNameFormatter: DogNameFormatter
) : Mapper<DogDto, List<Dog>> {

    override fun mapToDomain(from: DogDto) = from.photos.map {
        Dog(
            dogId = it.hashCode().toLong(),
            photoUrl = it,
            name = dogNameFormatter.format(it)
        )
    }
}