package com.softaai.synerzipassignment.model
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AttributesX(
    @Json(name = "im:bundleId")
    val imBundleId: String,
    @Json(name = "im:id")
    val imId: String
)