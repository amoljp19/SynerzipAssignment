package com.softaai.synerzipassignment.iTunesFeed.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.softaai.synerzipassignment.model.Entry
import kotlinx.android.synthetic.main.item_feed_entry.view.*

class EntryListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindView(entry: Entry) {

        Glide.with(itemView.context).load(entry.imImage[0]).into(itemView.item_entry_image)

        itemView.item_entry_title.text = entry.title.label
        itemView.item_entry_rights.text = entry.rights.label
    }
}