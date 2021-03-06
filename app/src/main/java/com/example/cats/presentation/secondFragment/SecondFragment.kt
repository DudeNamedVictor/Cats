package com.example.cats.presentation.secondFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cats.databinding.SecondFragmentLayoutBinding

class SecondFragment : Fragment() {

    private lateinit var binding: SecondFragmentLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = SecondFragmentLayoutBinding.inflate(inflater, container, false)

        return binding.root
    }

}