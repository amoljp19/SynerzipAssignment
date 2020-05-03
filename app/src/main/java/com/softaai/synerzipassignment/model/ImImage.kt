package com.softaai.synerzipassignment.model
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ImImage(
    @Json(name = "attributes")
    val attributes: AttributesXXXX,
    @Json(name = "label")
    val label: String
)