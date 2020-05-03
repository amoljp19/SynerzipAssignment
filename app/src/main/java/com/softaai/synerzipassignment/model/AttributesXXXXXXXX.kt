package com.softaai.synerzipassignment.model
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AttributesXXXXXXXX(
    @Json(name = "href")
    val href: String,
    @Json(name = "rel")
    val rel: String
)