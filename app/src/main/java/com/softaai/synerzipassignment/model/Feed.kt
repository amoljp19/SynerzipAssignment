package com.softaai.synerzipassignment.model
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Feed(
    @Json(name = "author")
    val author: Author,
    @Json(name = "entry")
    val entry: List<Entry>,
    @Json(name = "icon")
    val icon: Icon,
    @Json(name = "id")
    val id: IdX,
    @Json(name = "link")
    val link: List<LinkX>,
    @Json(name = "rights")
    val rights: RightsX,
    @Json(name = "title")
    val title: TitleX,
    @Json(name = "updated")
    val updated: Updated
)