package com.example.cats.presentation.mainFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import coil.load
import coil.size.Scale
import com.example.cats.databinding.MainFragmentLayoutBinding
import com.example.cats.presentation.MainApplication
import com.example.data.utils.CatsService
import javax.inject.Inject

class MainFragment : Fragment() {

    @Inject
    lateinit var catsService: CatsService

    private lateinit var binding: MainFragmentLayoutBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = MainFragmentLayoutBinding.inflate(inflater, container, false)

        initializeView()
        setObservers()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (context?.applicationContext as MainApplication).appComponent.inject(this)
    }

    private fun initializeView() {
        binding.loadCatButton.setOnClickListener {
            viewModel.getUserData(catsService)
        }
    }

    private fun setObservers() {
        viewModel.catsListMLD.observe(this, {
            binding.imageView.load(it) {
                scale(Scale.FILL)
            }
        })
    }

}