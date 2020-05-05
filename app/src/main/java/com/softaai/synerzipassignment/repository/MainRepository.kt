package com.softaai.synerzipassignment.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.softaai.synerzipassignment.model.Entry
import com.softaai.synerzipassignment.network.ApiResponse
import com.softaai.synerzipassignment.network.ITunesClient
import com.softaai.synerzipassignment.network.message
import com.softaai.synerzipassignment.persistence.ApiFeedResponseDao
import kotlinx.coroutines.*
import timber.log.Timber
import kotlin.coroutines.CoroutineContext

class MainRepository constructor(
    private val iTunesClient: ITunesClient,
    private val apiFeedResponseDao: ApiFeedResponseDao
) : Repository {

    override var isLoading = false

    init {
        Timber.d("Injection MainRepository")

    }


    suspend fun loadApiFeedResponse1() : List<Entry>{
        val liveData = MutableLiveData<List<Entry>>()
         var feedEntries = apiFeedResponseDao.getEntryList()
        if (feedEntries.isEmpty()) {
            isLoading = true
            iTunesClient.fetchApiFeedResponse { response ->
                isLoading = false
                when (response) {
                    is ApiResponse.Success -> {
                        response.data.let {
                            feedEntries = it!!.feed.entry
                            liveData.postValue(it.feed.entry)
                            apiFeedResponseDao.insertEntryList(it.feed.entry)
                        }
                    }
                    is ApiResponse.Failure.Error -> error(response.message())
                    is ApiResponse.Failure.Exception -> error(response.message())
                }
            }
        }
        //liveData.apply { postValue(feedEntries) }
        return feedEntries
    }


    suspend fun loadApiFeedResponse(error: (String) -> Unit) = withContext(Dispatchers.IO) {
        val liveData = MutableLiveData<List<Entry>>()
        var feedEntries = apiFeedResponseDao.getEntryList()
        if (feedEntries.isEmpty()) {
            isLoading = true
            iTunesClient.fetchApiFeedResponse { response ->
                isLoading = false
                when (response) {
                    is ApiResponse.Success -> {
                        response.data.let {
                            feedEntries = it!!.feed.entry
                            liveData.postValue(it.feed.entry)
                            apiFeedResponseDao.insertEntryList(it.feed.entry)
                        }
                    }
                    is ApiResponse.Failure.Error -> error(response.message())
                    is ApiResponse.Failure.Exception -> error(response.message())
                }
            }
        }
        liveData.apply { postValue(feedEntries) }
    }
}
