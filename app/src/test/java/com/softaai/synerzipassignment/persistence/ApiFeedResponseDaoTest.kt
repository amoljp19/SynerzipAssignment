package com.softaai.synerzipassignment.persistence

import com.softaai.synerzipassignment.utils.MockTestUtil.mockEntry
import com.softaai.synerzipassignment.utils.MockTestUtil.mockEntryList
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [21])
class ApiFeedResponseDaoTest : LocalDatabase() {

    private lateinit var apiFeedResponseDao: ApiFeedResponseDao

    @Before
    fun init() {
        apiFeedResponseDao = db.apiFeedResponseDao()
    }

    @Test
    fun insertAndLoadFeedEntryList() {
        val mockDataList = mockEntryList()
        apiFeedResponseDao.insertEntryList(mockDataList)

        val loadFromDB = apiFeedResponseDao.getEntryList()
        assertThat(loadFromDB.toString(), `is`(mockDataList.toString()))

        val mockData = mockEntry()
        assertThat(loadFromDB[0].toString(), `is`(mockData.toString()))
    }
}