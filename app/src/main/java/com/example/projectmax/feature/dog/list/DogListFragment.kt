package com.example.projectmax.feature.dog.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.projectmax.feature.dog.common.domain.Dog
import com.example.projectmax.feature.dog.components.DogList
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
                DogList(dogs = dogs) { dog ->
                    navigateToDetail(dog)
                }
            }
        }
    }

    private fun navigateToDetail(dog: Dog) {
        DogListFragmentDirections.actionDogListFragmentToDogDetailFragment(dogId = dog.dogId).also {
            findNavController().navigate(it)
        }
    }
}