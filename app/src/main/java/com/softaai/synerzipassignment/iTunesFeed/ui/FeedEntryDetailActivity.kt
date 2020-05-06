package com.softaai.synerzipassignment.iTunesFeed.ui

import android.annotation.SuppressLint
import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import com.bumptech.glide.Glide
import com.softaai.synerzipassignment.R
import com.softaai.synerzipassignment.base.DatabindingActivity
import com.softaai.synerzipassignment.databinding.ActivityFeedEntryDetailBinding
import com.softaai.synerzipassignment.iTunesFeed.viewmodel.FeedEntryDetailViewModel
import com.softaai.synerzipassignment.model.Entry
import com.softaai.synerzipassignment.model.Id
import kotlinx.android.synthetic.main.activity_feed_entry_detail.*
import kotlinx.android.synthetic.main.item_feed_entry.view.*
import org.koin.android.viewmodel.ext.android.getViewModel

class FeedEntryDetailActivity : DatabindingActivity() {

    private val binding: ActivityFeedEntryDetailBinding by binding(R.layout.activity_feed_entry_detail)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Glide.with(itemView.context).load(entry.imImage[0].label).into(itemView.item_entry_image)

        val entry =
            getViewModel<FeedEntryDetailViewModel>().getEntry(intent.getParcelableExtra(entryKey) as Id)
        //applyMaterialTransform(entry.title.label)
        binding.apply {
            this.entry = entry
            activity = this@FeedEntryDetailActivity
            container = detailContainer
            fab = fabMore
//            if(!entry.equals(null)) {
//                Glide.with(this@FeedEntryDetailActivity).load(entry.imImage[0].label)
//                    .into(feed_entry_detail_background)
//            }

        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        private const val entryKey = "entryKey"
        @SuppressLint("NewApi")
        fun startActivityModel(context: Context?, startView: View, entry: Entry) {
            if (context is Activity) {
                val intent = Intent(context, FeedEntryDetailActivity::class.java)
                intent.putExtra(
                    entryKey, entry.id)
                val options = ActivityOptions.makeSceneTransitionAnimation(context,
                    startView, entry.title.label
                )
                context.startActivity(intent, options.toBundle())
            }
        }

        fun startActivity(context: Context?, entry: Entry){
            val i = Intent(context, FeedEntryDetailActivity::class.java)
            i.putExtra(entryKey, entry.id)
            context?.startActivity(i)
        }
    }
}