package com.example.projectmax.feature.dog.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.projectmax.feature.dog.common.domain.Dog

@ExperimentalFoundationApi
@Composable
fun DogList(
    dogs: List<Dog>,
    onItemClick: (Dog) -> Unit
) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2)
    ) {
        itemsIndexed(
            items = dogs
        ) { index, dog ->
            DogCard(
                dog = dog,
                modifier = Modifier.clickable {
                    onItemClick(dog)
                }
            )
        }
    }
}