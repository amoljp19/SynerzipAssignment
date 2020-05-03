package com.softaai.synerzipassignment.model
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Attributes(
    @Json(name = "im:id")
    val imId: String,
    @Json(name = "label")
    val label: String,
    @Json(name = "scheme")
    val scheme: String,
    @Json(name = "term")
    val term: String
)