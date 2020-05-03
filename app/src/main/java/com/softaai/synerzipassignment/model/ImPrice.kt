package com.softaai.synerzipassignment.model
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ImPrice(
    @Json(name = "attributes")
    val attributes: AttributesXXXXX,
    @Json(name = "label")
    val label: String
)