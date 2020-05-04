package com.softaai.synerzipassignment.binding

import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.softaai.synerzipassignment.iTunesFeed.adapter.FeedEntryListRecyclerAdapter
import com.softaai.synerzipassignment.model.Entry

@BindingAdapter("adapter")
fun bindAdapter(view: RecyclerView, baseAdapter: FeedEntryListRecyclerAdapter) {
    view.adapter = baseAdapter
}

@BindingAdapter("toast")
fun bindToast(view: RecyclerView, text: LiveData<String>) {
    text.value.let {
        Toast.makeText(view.context, it, Toast.LENGTH_SHORT).show()
    }
}

//@BindingAdapter("adapterFeedEntryList")
//fun bindAdapterEntryList(view: RecyclerView, entries: List<Entry>) {
//    entries.let {
//        (view.adapter as? FeedEntryListRecyclerAdapter)?.setEntryList(it)
//    }
//}