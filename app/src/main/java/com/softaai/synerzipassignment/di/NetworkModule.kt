package com.softaai.synerzipassignment.di

import com.softaai.synerzipassignment.network.ITunesClient
import com.softaai.synerzipassignment.network.RequestInterceptor
import com.softaai.synerzipassignment.network.ITunesService
import com.softaai.synerzipassignment.utils.Constants
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

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
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    single { get<Retrofit>().create(ITunesService::class.java) }

    single { ITunesClient(get()) }
}
