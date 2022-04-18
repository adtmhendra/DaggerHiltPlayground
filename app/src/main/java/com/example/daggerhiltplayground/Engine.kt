package com.example.daggerhiltplayground

import android.content.Context

class Engine(
    private val context: Context,
    private val engineName: String,
    private val owner: String,
) {

    fun startEngine() {
        println("$engineName engine started...")
    }

    fun stopEngine() {
        println("${context.getString(R.string.engine_stopped)} by $owner")
    }

}