package com.example.daggerhiltplayground.model

import com.squareup.moshi.Json

data class TopRatingResponse(
    @Json(name = "results")
    val results: List<TopRating?>? = null,
)