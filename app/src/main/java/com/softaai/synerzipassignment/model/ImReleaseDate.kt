package com.softaai.synerzipassignment.model
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ImReleaseDate(
    @Json(name = "attributes")
    val attributes: AttributesXXXXXX,
    @Json(name = "label")
    val label: String
)