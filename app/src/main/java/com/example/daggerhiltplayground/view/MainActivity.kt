package com.example.daggerhiltplayground.view

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.daggerhiltplayground.Engine
import com.example.daggerhiltplayground.R
import com.example.daggerhiltplayground.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint // Anotasi yg berguna utk memberitahu Hilt agar meng-inject ke dalam class ini
class MainActivity : AppCompatActivity() {

    // Inisialisasi akan dilakukan ketika anotasi @Inject ditambahkan ke variabel
    @Inject
    lateinit var engine: Engine

    @Inject
    @Named("string")
    lateinit var injectedString: String

    @Inject
    @Named("string2")
    lateinit var injectedString2: String

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        engine.startEngine() // Superjet engine started

        println(injectedString)  // Ini adalah string pertama yang akan diinject
        println(injectedString2) // Ini adalah string kedua yang akan diinject

        viewModel.stopEngine() // Engine stopped by Hendra Pratik Aditama

        viewModel.listData.observe(this) {
            Log.d("RawgViewModelFromActivity", it.toString())
        }

        /*
            Normal way :
            val engine = Engine("Superjet")
            engine.startEngine()
        */
    }
}