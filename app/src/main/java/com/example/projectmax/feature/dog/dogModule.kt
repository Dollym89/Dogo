package com.example.projectmax.feature.dog

import com.example.projectmax.feature.dog.common.repository.DogRepository
import com.example.projectmax.feature.dog.common.repository.DogRepositoryImpl
import com.example.projectmax.feature.dog.common.repository.DogService
import com.example.projectmax.feature.dog.common.repository.gateway.DogDtoMapper
import com.example.projectmax.feature.dog.common.repository.gateway.DogNameFormatter
import com.example.projectmax.feature.dog.detail.DogDetailViewModel
import com.example.projectmax.feature.dog.list.DogListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

private fun provideDogRemoteSource(retrofit: Retrofit): DogService = retrofit.create(
    DogService::class.java
)

val dogModule = module {

    single { DogNameFormatter() }
    single { DogDtoMapper(get()) }
    single { provideDogRemoteSource(get()) }
    single<DogRepository> { DogRepositoryImpl(get(), get()) }

    viewModel { DogListViewModel(get()) }
    viewModel { param -> DogDetailViewModel(dogId = param.get(), get()) }
}