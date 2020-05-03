package com.softaai.synerzipassignment.network

import com.softaai.synerzipassignment.model.ApiFeedResponse
import retrofit2.Call
import retrofit2.http.GET

interface ITunesService {

    @GET("/us/rss/newfreeapplications/limit=2/json")
    fun fetchApiFeedResponse(): Call<ApiFeedResponse>
}