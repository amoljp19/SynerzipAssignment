package com.softaai.synerzipassignment.repository

import com.softaai.synerzipassignment.persistence.ApiFeedResponseDao

class DetailRepository constructor(
    private val apiFeedResponseDao: ApiFeedResponseDao
) : Repository {

    override var isLoading = false

    fun getEntryById(id: Long) = apiFeedResponseDao.getEntry(id)
}