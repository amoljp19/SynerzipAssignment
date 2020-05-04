package com.softaai.synerzipassignment.iTunesFeed.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.softaai.synerzipassignment.R
import com.softaai.synerzipassignment.model.Entry

class FeedEntryListRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var listOfEntries : List<Entry>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return EntryListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_feed_entry, parent, false))
    }

    override fun getItemCount(): Int {
        return if (::listOfEntries.isInitialized) listOfEntries.size else 0
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        val movieViewHolder = viewHolder as EntryListViewHolder
        movieViewHolder.bindView(listOfEntries.get(position))
    }

    fun setEntryList(listOfEntries: List<Entry>) {
        this.listOfEntries = listOfEntries
        notifyDataSetChanged()
    }

    fun updateEntryList(listOfEntries: List<Entry>) {
        this.listOfEntries = listOfEntries
        notifyDataSetChanged()
    }

}