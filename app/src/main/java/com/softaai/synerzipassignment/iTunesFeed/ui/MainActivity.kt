package com.softaai.synerzipassignment.iTunesFeed.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.softaai.synerzipassignment.R
import com.softaai.synerzipassignment.base.DatabindingActivity
import org.koin.android.ext.android.get
import com.softaai.synerzipassignment.databinding.ActivityMainBinding
import com.softaai.synerzipassignment.iTunesFeed.adapter.FeedEntryListRecyclerAdapter
import com.softaai.synerzipassignment.iTunesFeed.adapter.GridItemDecoration
import com.softaai.synerzipassignment.iTunesFeed.viewmodel.MainViewModel
import org.koin.android.viewmodel.ext.android.getViewModel

class MainActivity : DatabindingActivity() {
    private val binding: ActivityMainBinding by binding(R.layout.activity_main)

    //    private lateinit var binding: ActivityMainBinding
//    val feedEntryListRecyclerAdapter = FeedEntryListRecyclerAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //initView()
        binding.viewModel = getViewModel<MainViewModel>().apply { fetchFeedEntryList() }
        binding.lifecycleOwner = this@MainActivity
        binding.adapter = FeedEntryListRecyclerAdapter()


//        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//
//        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)
//
//        binding.recyclerView.addItemDecoration(GridItemDecoration(10, 2))
//
//        binding.lifecycleOwner = this@MainActivity
//
//        val mainViewModel: MainViewModel = get()
//        binding.viewModel = mainViewModel
//        //val y = mainViewModel.getFeedEntryList()
//        binding.adapter = feedEntryListRecyclerAdapter

        //mainViewModel.launchOnViewModelScope { mainViewModel.feedEntryListLiveData }
        //binding.adapter!!.updateEntryList(binding.viewModel!!.getFeedEntryList())


    }

    private fun initView() {


    }

}
