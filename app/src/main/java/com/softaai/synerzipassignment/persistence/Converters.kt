package com.softaai.synerzipassignment.persistence

import androidx.room.TypeConverter
import com.google.gson.Gson

import com.google.gson.reflect.TypeToken
import com.softaai.synerzipassignment.model.*
import java.lang.reflect.Type


object Converters {
//    @TypeConverter
//    fun fromString(value: String?): ArrayList<String> {
//        val listType: Type = object : TypeToken<ArrayList<String?>?>() {}.type
//        return Gson().fromJson(value, listType)
//    }
//
//    @TypeConverter
//    fun fromArrayLisr(list: ArrayList<String?>?): String {
//        val gson = Gson()
//        return gson.toJson(list)
//    }


    @TypeConverter
    fun fromStringToCategory(value: String?): Category {
        val categoryType: Type = object : TypeToken<Category>() {}.type
        return Gson().fromJson(value, categoryType)
    }

    @TypeConverter
    fun fromCategoryToString(category: Category?): String {
        val gson = Gson()
        return gson.toJson(category)
    }

    @TypeConverter
    fun fromStringToId(value: String?): Id {
        val idType: Type = object : TypeToken<Id>() {}.type
        return Gson().fromJson(value, idType)
    }

    @TypeConverter
    fun fromIdToString(id: Id?): String {
        val gson = Gson()
        return gson.toJson(id)
    }

    @TypeConverter
    fun fromStringToImArtist(value: String?): ImArtist {
        val imArtistType: Type = object : TypeToken<ImArtist>() {}.type
        return Gson().fromJson(value, imArtistType)
    }

    @TypeConverter
    fun fromImArtistToString(imArtist: ImArtist?): String {
        val gson = Gson()
        return gson.toJson(imArtist)
    }


    @TypeConverter
    fun fromStringToImContentType(value: String?): ImContentType {
        val imContentType: Type = object : TypeToken<ImContentType>() {}.type
        return Gson().fromJson(value, imContentType)
    }

    @TypeConverter
    fun fromImContentTypeToString(imContentType: ImContentType?): String {
        val gson = Gson()
        return gson.toJson(imContentType)
    }

//    @TypeConverter
//    fun fromStringToImImage(value: String?): ImImage {
//        val imImageType: Type = object : TypeToken<ImImage>() {}.type
//        return Gson().fromJson(value, imImageType)
//    }
//
//    @TypeConverter
//    fun fromImImageToString(imImage: ImImage?): String {
//        val gson = Gson()
//        return gson.toJson(imImage)
//    }

    @TypeConverter
    fun fromStringToImImageList(value: String?): List<ImImage> {
        val imImageListType: Type = object : TypeToken<List<ImImage?>?>() {}.type
        return Gson().fromJson(value, imImageListType)
    }

    @TypeConverter
    fun fromImImageListToString(imImageList: List<ImImage?>?): String {
        val gson = Gson()
        return gson.toJson(imImageList)
    }


    @TypeConverter
    fun fromStringToImName(value: String?): ImName {
        val imNameType: Type = object : TypeToken<ImName>() {}.type
        return Gson().fromJson(value, imNameType)
    }

    @TypeConverter
    fun fromImNameToString(imName: ImName?): String {
        val gson = Gson()
        return gson.toJson(imName)
    }

    @TypeConverter
    fun fromStringToImPrice(value: String?): ImPrice {
        val imPriceType: Type = object : TypeToken<ImPrice>() {}.type
        return Gson().fromJson(value, imPriceType)
    }

    @TypeConverter
    fun fromImPriceToString(imPrice: ImPrice?): String {
        val gson = Gson()
        return gson.toJson(imPrice)
    }

    @TypeConverter
    fun fromStringToImReleaseDate(value: String?): ImReleaseDate {
        val imReleaseDateType: Type = object : TypeToken<ImReleaseDate>() {}.type
        return Gson().fromJson(value, imReleaseDateType)
    }

    @TypeConverter
    fun fromImReleaseDateToString(imReleaseDate: ImReleaseDate?): String {
        val gson = Gson()
        return gson.toJson(imReleaseDate)
    }



    @TypeConverter
    fun fromStringToLink(value: String?): Link {
        val linkType: Type = object : TypeToken<Link>() {}.type
        return Gson().fromJson(value, linkType)
    }

    @TypeConverter
    fun fromLinkToString(link: Link?): String {
        val gson = Gson()
        return gson.toJson(link)
    }

    @TypeConverter
    fun fromStringToRights(value: String?): Rights {
        val rightsType: Type = object : TypeToken<Rights>() {}.type
        return Gson().fromJson(value, rightsType)
    }

    @TypeConverter
    fun fromRightsToString(rights: Rights?): String {
        val gson = Gson()
        return gson.toJson(rights)
    }

    @TypeConverter
    fun fromStringToTitle(value: String?): Title {
        val titleType: Type = object : TypeToken<Title>() {}.type
        return Gson().fromJson(value, titleType)
    }

    @TypeConverter
    fun fromTitleToString(title: Title?): String {
        val gson = Gson()
        return gson.toJson(title)
    }
}