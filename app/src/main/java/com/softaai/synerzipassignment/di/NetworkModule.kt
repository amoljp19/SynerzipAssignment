package com.softaai.synerzipassignment.di

import com.softaai.synerzipassignment.network.ITunesClient
import com.softaai.synerzipassignment.network.RequestInterceptor
import com.softaai.synerzipassignment.network.ITunesService
import com.softaai.synerzipassignment.utils.Constants
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

    single {
        OkHttpClient.Builder()
            .addInterceptor(RequestInterceptor())
            .build()
    }

    single {
        Retrofit.Builder()
            .client(get<OkHttpClient>())
            .baseUrl(Constants.URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single { get<Retrofit>().create(ITunesService::class.java) }

    single { ITunesClient(get()) }
}