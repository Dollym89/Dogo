package com.example.projectmax.feature.dog.common.repository

import com.example.projectmax.feature.dog.common.repository.resources.DogDto
import retrofit2.http.GET

interface DogService {
    @GET("api/breeds/image/random/50")
    suspend fun getDogs(): DogDto
}