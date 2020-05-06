package com.softaai.synerzipassignment.binding

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import com.google.android.material.appbar.MaterialToolbar
import com.softaai.synerzipassignment.R

fun AppCompatActivity.simpleToolbarWithHome(toolbar: MaterialToolbar, title_: String = "") {
    setSupportActionBar(toolbar)
    supportActionBar?.run {
        setHomeAsUpIndicator(R.drawable.ic_arrow_back)
        setDisplayHomeAsUpEnabled(true)
        title = title_
    }
}

@BindingAdapter("simpleToolbarWithHome", "simpleToolbarTitle")
fun bindToolbarWithTitle(toolbar: MaterialToolbar, activity: AppCompatActivity, title: String) {
    activity.simpleToolbarWithHome(toolbar, title)
}