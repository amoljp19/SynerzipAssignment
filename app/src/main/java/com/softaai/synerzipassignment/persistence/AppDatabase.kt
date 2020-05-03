package com.softaai.synerzipassignment.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.softaai.synerzipassignment.model.ApiFeedResponse

@Database(entities = [ApiFeedResponse::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {

    abstract fun apiFeedResponseDao(): ApiFeedResponseDao
}