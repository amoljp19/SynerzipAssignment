package com.softaai.synerzipassignment.model
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Author(
    @Json(name = "name")
    val name: Name,
    @Json(name = "uri")
    val uri: Uri
)