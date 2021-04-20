package com.example.projectmax.feature.dog.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.projectmax.feature.dog.components.DogCard
import org.koin.androidx.viewmodel.ext.android.viewModel

@ExperimentalFoundationApi
class DogListFragment : Fragment() {

    private val viewModel: DogListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                val dogs = viewModel.dogs.value
                LazyVerticalGrid(
                    cells = GridCells.Fixed(2)
                ) {
                    itemsIndexed(
                        items = dogs
                    ) { index, dog ->
                        DogCard(
                            dog = dog,
                            onClick = { navigateToDetail(dog.dogId) }
                        )
                    }
                }
            }
        }
    }

    private fun navigateToDetail(dogId: Long) {
        DogListFragmentDirections.actionDogListFragmentToDogDetailFragment(dogId = dogId).also {
            findNavController().navigate(it)
        }
    }
}