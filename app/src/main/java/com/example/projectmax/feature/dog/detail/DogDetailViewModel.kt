package com.example.projectmax.feature.dog.detail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import com.example.projectmax.feature.dog.common.domain.Dog
import com.example.projectmax.feature.dog.common.repository.DogRepository

class DogDetailViewModel(
    private val dogId: Long,
    private val repository: DogRepository
) : ViewModel() {

    private val _state: MutableState<Dog?> = mutableStateOf(null)
    val selectedDog: State<Dog?> = _state

    init {
        findDog()
    }

    private fun findDog() {
        _state.value = repository.dogList.find { it.dogId == dogId }
    }
}