package com.softaai.synerzipassignment.model
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AttributesXXX(
    @Json(name = "label")
    val label: String,
    @Json(name = "term")
    val term: String
)