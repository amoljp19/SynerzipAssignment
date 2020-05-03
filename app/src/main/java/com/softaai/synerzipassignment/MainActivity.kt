package com.softaai.synerzipassignment

import android.os.Bundle
import com.softaai.synerzipassignment.base.DatabindingActivity
import com.softaai.synerzipassignment.databinding.ActivityMainBinding

class MainActivity : DatabindingActivity() {

    private val binding: ActivityMainBinding by binding(R.layout.activity_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
    }
}
