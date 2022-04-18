package com.example.daggerhiltplayground.module

import androidx.lifecycle.ViewModel
import com.example.daggerhiltplayground.Engine
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel // Anotasi @HiltViewModel wajib memiliki 1 constructor beranotasi @Inject
class MainViewModel @Inject constructor(private val engine: Engine) : ViewModel() {

    fun stopEngine() {
        engine.stopEngine()
    }
}