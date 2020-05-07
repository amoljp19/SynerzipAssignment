package com.softaai.synerzipassignment.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.atLeastOnce
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.softaai.synerzipassignment.MainCoroutinesRule
import com.softaai.synerzipassignment.model.Entry
import com.softaai.synerzipassignment.network.ApiUtil.getCall
import com.softaai.synerzipassignment.network.ITunesClient
import com.softaai.synerzipassignment.network.ITunesService
import com.softaai.synerzipassignment.persistence.ApiFeedResponseDao
import com.softaai.synerzipassignment.utils.MockTestUtil.mockApiFeedResponse
import com.softaai.synerzipassignment.utils.MockTestUtil.mockEntryList
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class MainRepositoryTest {

    private lateinit var repository: MainRepository
    private lateinit var client: ITunesClient
    private val service: ITunesService = mock()
    private val apiFeedResponseDao: ApiFeedResponseDao = mock()

    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesRule = MainCoroutinesRule()

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @Before
    fun setup() {
        client = ITunesClient(service)
        repository = MainRepository(client, apiFeedResponseDao)
    }

    @Test
    fun loadDisneyPostersTest() = runBlocking {
        val mockData = mockApiFeedResponse()
        whenever(apiFeedResponseDao.getEntryList()).thenReturn(emptyList())
        whenever(service.fetchApiFeedResponse()).thenReturn(getCall(mockData))

        val loadData = repository.loadApiFeedResponse { }
        verify(apiFeedResponseDao, atLeastOnce()).getEntryList()
        verify(service, atLeastOnce()).fetchApiFeedResponse()

        val observer: Observer<List<Entry>> = mock()
        loadData.observeForever(observer)

        val updatedData = mockEntryList()
        whenever(apiFeedResponseDao.getEntryList()).thenReturn(updatedData)

        loadData.postValue(updatedData)
        verify(observer).onChanged(updatedData)
        loadData.removeObserver(observer)
    }
}
