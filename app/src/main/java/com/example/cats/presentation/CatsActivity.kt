package com.example.cats.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.example.cats.R
import com.google.android.material.tabs.TabLayout


class CatsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cats_activity_layout)

        val tabLayout = findViewById<View>(R.id.main_tabs) as TabLayout
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> Navigation.findNavController(this@CatsActivity, R.id.nav_host_fragment)
                        .popBackStack()
                    else -> Navigation.findNavController(this@CatsActivity, R.id.nav_host_fragment)
                        .navigate(R.id.action_mainFragment_to_secondFragment)
                }

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // do nothing
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // do nothing
            }

        })
    }

}