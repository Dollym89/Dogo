package com.example.projectmax.feature.dog.list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projectmax.feature.dog.common.domain.Dog
import com.example.projectmax.feature.dog.common.repository.DogRepository
import kotlinx.coroutines.launch

class DogListViewModel(
    private val repository: DogRepository
) : ViewModel() {


    val dogs: MutableState<List<Dog>> = mutableStateOf(listOf())

    init {
        getDogs()
    }

    private fun getDogs() {
        viewModelScope.launch {
            dogs.value = repository.getDogs()
        }
    }
}