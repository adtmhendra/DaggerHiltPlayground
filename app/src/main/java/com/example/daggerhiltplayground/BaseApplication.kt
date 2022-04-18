package com.example.daggerhiltplayground

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp // Anotasi wajib agar hilt mengenali application class
class BaseApplication : Application()