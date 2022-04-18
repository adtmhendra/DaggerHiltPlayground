package com.example.daggerhiltplayground.network

import com.example.daggerhiltplayground.model.TopRatingResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    companion object {
        const val BASE_URL = "https://api.rawg.io/api/"
        const val API_KEY = "4d601705c8324648b378d5e18e98d78e"
    }

    @GET("games?key=${API_KEY}&page_size=10&ordering=-rating&platforms=4&page=1")
    suspend fun getTopRatingData(): Response<TopRatingResponse>
}