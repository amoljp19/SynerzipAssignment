package com.softaai.synerzipassignment.model
import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class AttributesX(
    @Json(name = "im:bundleId")
    val imBundleId: String,
    @Json(name = "im:id")
    val imId: String
):Parcelable