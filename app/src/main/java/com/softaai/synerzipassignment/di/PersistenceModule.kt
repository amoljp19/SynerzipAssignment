package com.softaai.synerzipassignment.di

import androidx.room.Room
import com.softaai.synerzipassignment.R
import com.softaai.synerzipassignment.persistence.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val persistenceModule = module {

    single {
        Room
            .databaseBuilder(
                androidApplication(), AppDatabase::class.java,
                androidApplication().getString(R.string.database)
            )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    single { get<AppDatabase>().apiFeedResponseDao() }
}
