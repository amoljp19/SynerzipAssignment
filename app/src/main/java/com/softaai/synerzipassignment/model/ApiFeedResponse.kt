package com.softaai.synerzipassignment.model
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiFeedResponse(
    @Json(name = "feed")
    val feed: Feed
)