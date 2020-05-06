package com.softaai.synerzipassignment.model
import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Id(
    @Json(name = "attributes")
    val attributes: AttributesX,
    @Json(name = "label")
    val label: String
) : Parcelable