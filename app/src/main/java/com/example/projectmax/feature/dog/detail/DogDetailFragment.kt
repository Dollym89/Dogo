package com.example.projectmax.feature.dog.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.projectmax.feature.dog.components.DogoDetail
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class DogDetailFragment : Fragment() {

    private val arguments: DogDetailFragmentArgs by navArgs()

    private val viewModel: DogDetailViewModel by viewModel { parametersOf(arguments.dogId) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                viewModel.selectedDog.value?.let {
                    DogoDetail(dog = it)
                }
            }
        }
    }
}