package com.softaai.synerzipassignment.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.atLeastOnce
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.softaai.synerzipassignment.MainCoroutinesRule
import com.softaai.synerzipassignment.iTunesFeed.viewmodel.MainViewModel
import com.softaai.synerzipassignment.model.Entry
import com.softaai.synerzipassignment.network.ITunesClient
import com.softaai.synerzipassignment.network.ITunesService
import com.softaai.synerzipassignment.persistence.ApiFeedResponseDao
import com.softaai.synerzipassignment.repository.MainRepository
import com.softaai.synerzipassignment.utils.MockTestUtil
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class MainViewModelTest {

    private lateinit var viewModel: MainViewModel
    private lateinit var mainRepository: MainRepository
    private val iTunesService: ITunesService = mock()
    private val iTunesClient: ITunesClient = ITunesClient(iTunesService)
    private val apiFeedResponseDao: ApiFeedResponseDao = mock()

    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesRule = MainCoroutinesRule()

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @Before
    fun setup() {
        mainRepository = MainRepository(iTunesClient, apiFeedResponseDao)
        viewModel = MainViewModel(mainRepository)
    }

    @Test
    fun fetchDisneyPosterListTest() = runBlocking {
        val mockData = MockTestUtil.mockEntryList()
        whenever(apiFeedResponseDao.getEntryList()).thenReturn(mockData)

        val fetchedData = mainRepository.loadApiFeedResponse{ }
        val observer: Observer<List<Entry>> = mock()
        fetchedData.observeForever(observer)

        viewModel.fetchFeedEntryList()

        verify(apiFeedResponseDao, atLeastOnce()).getEntryList()
        verify(observer).onChanged(mockData)
        fetchedData.removeObserver(observer)
    }
}