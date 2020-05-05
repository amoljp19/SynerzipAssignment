package com.softaai.synerzipassignment.model
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Entity
data class Entry(
    @Json(name = "category")
    val category: Category,
    @field:PrimaryKey
    @Json(name = "id")
    val id: Id,
    @Json(name = "im:artist")
    val imArtist: ImArtist,
    @Json(name = "im:contentType")
    val imContentType: ImContentType,
    @Json(name = "im:image")
    val imImage: List<ImImage>,
    @Json(name = "im:name")
    val imName: ImName,
    @Json(name = "im:price")
    val imPrice: ImPrice,
    @Json(name = "im:releaseDate")
    val imReleaseDate: ImReleaseDate,
    @Json(name = "link")
    val link: Link,
    @Json(name = "rights")
    val rights: Rights,
     @Json(name = "title")
    val title: Title
)