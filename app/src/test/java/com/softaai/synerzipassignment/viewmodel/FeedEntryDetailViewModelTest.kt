package com.softaai.synerzipassignment.viewmodel

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.softaai.synerzipassignment.iTunesFeed.viewmodel.FeedEntryDetailViewModel
import com.softaai.synerzipassignment.repository.DetailRepository
import com.softaai.synerzipassignment.utils.MockTestUtil.mockEntry
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test

class FeedEntryDetailViewModelTest {
    private lateinit var viewModel: FeedEntryDetailViewModel
    private val repository: DetailRepository = mock()

    @Before
    fun setup() {
        viewModel = FeedEntryDetailViewModel(repository)
    }

    @Test
    fun getPosterTest() {
        val mockData = mockEntry()
        whenever(repository.getEntryById(mockData.id)).thenReturn(mockEntry())

        val loadFromDB = viewModel.getEntry(mockData.id)
        verify(repository).getEntryById(mockData.id)
        assertThat(loadFromDB, `is`(mockData))
    }
}