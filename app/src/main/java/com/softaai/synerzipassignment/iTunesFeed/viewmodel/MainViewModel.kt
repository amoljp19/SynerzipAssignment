package com.softaai.synerzipassignment.iTunesFeed.viewmodel

import androidx.lifecycle.*
import com.softaai.synerzipassignment.model.Entry
import com.softaai.synerzipassignment.repository.MainRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.koin.ext.scope
import timber.log.Timber
import kotlin.coroutines.CoroutineContext

class MainViewModel constructor(
    private val mainRepository: MainRepository
) : ViewModel() {

    private var feedEntryFetchingLiveData: MutableLiveData<Boolean> = MutableLiveData()
    //val feedEntryListLiveData: LiveData<List<Entry>>

    val toastLiveData: MutableLiveData<String> = MutableLiveData()

    private val parentJob = Job()

    private val coroutineContext: CoroutineContext get() = parentJob + Dispatchers.Default

    private val scope = CoroutineScope(coroutineContext)


    init {

        Timber.d("injection MainViewModel")

//        this.feedEntryFetchingLiveData.switchMap {
//            launchOnViewModelScope {
//                this.mainRepository.loadApiFeedResponse {
//                    this.toastLiveData.postValue(it)
//                }
//            }
//        }
    }

    fun getFeedEntryList() : List<Entry>{
        var x:List<Entry> = listOf()
        scope.launch {
            x =  mainRepository.loadApiFeedResponse1()
            Timber.d("%s", x)
        }
        return x
    }

    inline fun <T> launchOnViewModelScope(crossinline block: suspend () -> LiveData<T>): LiveData<T> {
        return liveData(viewModelScope.coroutineContext + Dispatchers.IO) {
            emitSource(block())
        }
    }
}

