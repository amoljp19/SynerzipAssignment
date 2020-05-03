package com.softaai.synerzipassignment.model
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Id(
    @Json(name = "attributes")
    val attributes: AttributesX,
    @Json(name = "label")
    val label: String
)