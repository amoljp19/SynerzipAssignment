package com.softaai.synerzipassignment.model
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ImContentType(
    @Json(name = "attributes")
    val attributes: AttributesXXX
)