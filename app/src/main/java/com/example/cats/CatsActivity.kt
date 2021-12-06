package com.example.cats

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.example.cats.databinding.CatsActivityLayoutBinding

class CatsActivity : AppCompatActivity() {

    private lateinit var binding: CatsActivityLayoutBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CatsActivityLayoutBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initializeView()
        setObservers()
    }

    private fun initializeView() {
        binding.getCat.setOnClickListener {
            viewModel.getUserData()
        }
    }

    private fun setObservers() {
        viewModel.catMLD.observe(this, {
            binding.imageView.load(it)
        })
    }

}