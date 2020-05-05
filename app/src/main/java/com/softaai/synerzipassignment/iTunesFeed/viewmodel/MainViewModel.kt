package com.softaai.synerzipassignment.iTunesFeed.viewmodel

import androidx.lifecycle.*
import com.softaai.synerzipassignment.base.LiveCoroutinesViewModel
import com.softaai.synerzipassignment.model.Entry
import com.softaai.synerzipassignment.repository.MainRepository
import timber.log.Timber

class MainViewModel constructor(
    private val mainRepository: MainRepository
) : LiveCoroutinesViewModel() {

    private var feedEntryFetchingLiveData: MutableLiveData<Boolean> = MutableLiveData()
    val feedEntryListLiveData: LiveData<List<Entry>>

    val toastLiveData: MutableLiveData<String> = MutableLiveData()

    init {

        Timber.d("injection MainViewModel")

        this.feedEntryListLiveData = this.feedEntryFetchingLiveData.switchMap {
            launchOnViewModelScope {
                this.mainRepository.loadApiFeedResponse {
                    this.toastLiveData.postValue(it)
                }
            }
        }
    }

    fun fetchFeedEntryList() = this.feedEntryFetchingLiveData.postValue(true)

}

