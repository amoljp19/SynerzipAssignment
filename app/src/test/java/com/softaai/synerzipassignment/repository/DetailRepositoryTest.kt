package com.softaai.synerzipassignment.repository

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.softaai.synerzipassignment.persistence.ApiFeedResponseDao
import com.softaai.synerzipassignment.utils.MockTestUtil.mockApiFeedResponse
import com.softaai.synerzipassignment.utils.MockTestUtil.mockEntry
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class DetailRepositoryTest {

    private lateinit var repository: DetailRepository
    private val apiFeedResponseDao: ApiFeedResponseDao = mock()

    @Before
    fun setup() {
        repository = DetailRepository(apiFeedResponseDao)
    }

    @Test
    fun getEntryByIdTest() {
        val mockData = mockApiFeedResponse().feed.entry
        whenever(apiFeedResponseDao.getEntry(mockEntry().id)).thenReturn(mockEntry())

        val loadFromDB = repository.getEntryById(mockEntry().id)
        verify(apiFeedResponseDao).getEntry(mockEntry().id)
        assertEquals(loadFromDB.id.label, mockData[0].id.label)

    }
}