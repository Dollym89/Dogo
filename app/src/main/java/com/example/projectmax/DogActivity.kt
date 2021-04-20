package com.example.projectmax

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.projectmax.common.ui.DogApplication

class DogActivity : AppCompatActivity() {

    private val app: DogApplication by lazy {
        application as DogApplication
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        app.init()
        setContentView(R.layout.activity_main)
    }
}