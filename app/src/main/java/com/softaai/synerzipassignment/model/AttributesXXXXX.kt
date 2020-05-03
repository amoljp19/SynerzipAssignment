package com.softaai.synerzipassignment.model
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AttributesXXXXX(
    @Json(name = "amount")
    val amount: String,
    @Json(name = "currency")
    val currency: String
)