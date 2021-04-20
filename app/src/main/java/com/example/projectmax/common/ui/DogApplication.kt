package com.example.projectmax.common.ui

import android.app.Application
import com.example.projectmax.common.module
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class DogApplication : Application() {
    private var isInitiated = false

    fun init() = isInitiated.takeIf { !it }?.let {

        startKoin {
            modules(module)
            androidContext(this@DogApplication)
            androidFileProperties()
            androidLogger()
        }
        isInitiated = true
    }
}