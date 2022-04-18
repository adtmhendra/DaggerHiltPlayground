package com.example.daggerhiltplayground.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daggerhiltplayground.Engine
import com.example.daggerhiltplayground.model.TopRating
import com.example.daggerhiltplayground.network.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel // Anotasi @HiltViewModel wajib memiliki 1 constructor beranotasi @Inject
class MainViewModel @Inject constructor(
    private val engine: Engine,
    private val apiService: ApiService,
) : ViewModel() {

    companion object {
        const val TAG = "RawgViewModel"
    }

    private val _listData = MutableLiveData<List<TopRating?>>()
    val listData: LiveData<List<TopRating?>> get() = _listData

    init {
        getTopRatingData()
    }

    private fun getTopRatingData() {
        viewModelScope.launch {
            try {
                val response = apiService.getTopRatingData()
                if (response.isSuccessful) {
                    val listData = response.body()?.results
                    _listData.value = listData
                    Log.d(TAG, listData.toString())
                } else Log.e(TAG, "Error : ${response.code()}")
            } catch (e: Exception) {
                Log.e(TAG, e.message.toString())
            }
        }
    }

    fun stopEngine() {
        engine.stopEngine()
    }
}