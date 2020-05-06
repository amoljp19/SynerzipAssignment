package com.softaai.synerzipassignment.iTunesFeed.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.softaai.synerzipassignment.R
import com.softaai.synerzipassignment.iTunesFeed.ui.FeedEntryDetailActivity
import com.softaai.synerzipassignment.model.Entry

class FeedEntryListRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var listOfEntries : List<Entry>? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return EntryListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_feed_entry, parent, false))
    }

    override fun getItemCount(): Int {
        if(listOfEntries == null){
            return 0
        }
        else{
            return listOfEntries!!.size
        }
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        val movieViewHolder = viewHolder as EntryListViewHolder
        movieViewHolder.bindView(listOfEntries!!.get(position))
        movieViewHolder.itemView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
//                val i = Intent(v?.context, FeedEntryDetailActivity::class.java)
//                v?.context?.startActivity(i)
                FeedEntryDetailActivity.startActivity(v?.context, listOfEntries!!.get(movieViewHolder.adapterPosition))
            }
        })
    }

    fun setEntryList(listOfEntries: List<Entry>?) {
        listOfEntries.let {
            this.listOfEntries = listOfEntries
            notifyDataSetChanged()
        }
    }

    fun updateEntryList(listOfEntries: List<Entry>) {
        this.listOfEntries = listOfEntries
        notifyDataSetChanged()
    }

}