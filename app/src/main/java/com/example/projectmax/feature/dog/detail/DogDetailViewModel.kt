package com.example.projectmax.feature.dog.detail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.projectmax.feature.dog.common.domain.Dog
import com.example.projectmax.feature.dog.common.repository.DogRepository

class DogDetailViewModel(
    private val dogId: Long,
    private val repository: DogRepository
) : ViewModel() {

    val selectedDog: MutableState<Dog?> = mutableStateOf(null)

    init {
        selectedDog.value = repository.dogList.find { it.dogId == dogId }
    }
}