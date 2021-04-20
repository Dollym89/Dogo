package com.example.projectmax.feature.dog.common.repository.resources

import com.google.gson.annotations.SerializedName

data class DogDto(
    @SerializedName("message") val photos: List<String>,
    @SerializedName("status") val status: String
)