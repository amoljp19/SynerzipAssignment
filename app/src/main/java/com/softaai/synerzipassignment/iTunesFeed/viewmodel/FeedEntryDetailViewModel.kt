package com.softaai.synerzipassignment.iTunesFeed.viewmodel

import com.softaai.synerzipassignment.base.LiveCoroutinesViewModel
import com.softaai.synerzipassignment.model.Id
import com.softaai.synerzipassignment.repository.DetailRepository

class FeedEntryDetailViewModel(
    private val repository: DetailRepository
) : LiveCoroutinesViewModel() {

    fun getEntry(id: Id) = repository.getEntryById(id)
}