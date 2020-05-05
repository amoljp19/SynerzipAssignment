package com.softaai.synerzipassignment.di


import com.softaai.synerzipassignment.iTunesFeed.viewmodel.FeedEntryDetailViewModel
import com.softaai.synerzipassignment.iTunesFeed.viewmodel.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {

    viewModel { MainViewModel(get()) }

    viewModel { FeedEntryDetailViewModel(get()) }
}