package com.example.projectmax.common.networking

import com.example.projectmax.common.utils.lazyAndroid
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private val okHttpClientInterceptor by lazyAndroid {
    HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BASIC
    }
}

private val okHttpClient: OkHttpClient by lazyAndroid {
    OkHttpClient.Builder()
        .addInterceptor(okHttpClientInterceptor)
        .build()
}

private val retrofit by lazyAndroid {
    Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl("https://dog.ceo/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

val networkModule = module {
    single { retrofit }
}
