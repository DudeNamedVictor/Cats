package com.example.cats.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.example.cats.R
import com.example.cats.databinding.CatsActivityLayoutBinding
import com.google.android.material.tabs.TabLayout


class CatsActivity : AppCompatActivity() {
    private lateinit var binding: CatsActivityLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = CatsActivityLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainTabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val navigation =
                    Navigation.findNavController(this@CatsActivity, R.id.nav_host_fragment)
                when (tab?.position) {
                    0 -> navigation.popBackStack(R.id.mainFragment, false)
                    else -> navigation.navigate(R.id.action_mainFragment_to_secondFragment)
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