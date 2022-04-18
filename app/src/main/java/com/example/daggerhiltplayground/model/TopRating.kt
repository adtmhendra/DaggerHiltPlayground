package com.example.daggerhiltplayground.model

import com.squareup.moshi.Json

data class TopRating(
    @Json(name = "name")
    val name: String? = null,
)
