package com.softaai.synerzipassignment.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.softaai.synerzipassignment.model.Entry

@Database(entities = [Entry::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun apiFeedResponseDao(): ApiFeedResponseDao
}