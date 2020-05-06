package com.softaai.synerzipassignment.persistence

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.softaai.synerzipassignment.model.Entry
import com.softaai.synerzipassignment.model.Id


@Dao
interface ApiFeedResponseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEntryList(entries: List<Entry>)

    @Query("SELECT * FROM Entry WHERE id = :id_")
    fun getEntry(id_: Id): Entry

    @Query("SELECT * FROM Entry")
    fun getEntryList(): List<Entry>
}