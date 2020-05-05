package com.softaai.synerzipassignment.iTunesFeed.ui

import android.os.Bundle
import com.softaai.synerzipassignment.R
import com.softaai.synerzipassignment.base.DatabindingActivity
import com.softaai.synerzipassignment.databinding.ActivityMainBinding
import com.softaai.synerzipassignment.iTunesFeed.adapter.FeedEntryListRecyclerAdapter
import com.softaai.synerzipassignment.iTunesFeed.adapter.GridItemDecoration
import com.softaai.synerzipassignment.iTunesFeed.viewmodel.MainViewModel
import org.koin.android.viewmodel.ext.android.getViewModel

class MainActivity : DatabindingActivity() {
    private val binding: ActivityMainBinding by binding(R.layout.activity_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = getViewModel<MainViewModel>().apply { fetchFeedEntryList() }
        binding.lifecycleOwner = this@MainActivity
        binding.recyclerView!!.addItemDecoration(GridItemDecoration(15, 2))
        binding.adapter = FeedEntryListRecyclerAdapter()
    }
}
