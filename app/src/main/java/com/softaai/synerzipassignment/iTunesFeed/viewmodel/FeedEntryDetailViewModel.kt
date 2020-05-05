package com.softaai.synerzipassignment.iTunesFeed.viewmodel

import com.softaai.synerzipassignment.base.LiveCoroutinesViewModel
import com.softaai.synerzipassignment.repository.DetailRepository

class FeedEntryDetailViewModel(
    private val repository: DetailRepository
) : LiveCoroutinesViewModel() {

    fun getEntry(id: Long) = repository.getEntryById(id)
}