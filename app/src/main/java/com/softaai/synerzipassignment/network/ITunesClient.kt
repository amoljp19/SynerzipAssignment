package com.softaai.synerzipassignment.network

import com.softaai.synerzipassignment.model.ApiFeedResponse

class ITunesClient(private val iTunesService: ITunesService) {

    fun fetchApiFeedResponse(
        onResult: (response: ApiResponse<ApiFeedResponse>) -> Unit
    ) {
        this.iTunesService.fetchApiFeedResponse().transform(onResult)
    }
}