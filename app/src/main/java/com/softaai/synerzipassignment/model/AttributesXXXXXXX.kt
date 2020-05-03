package com.softaai.synerzipassignment.model
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AttributesXXXXXXX(
    @Json(name = "href")
    val href: String,
    @Json(name = "rel")
    val rel: String,
    @Json(name = "type")
    val type: String
)