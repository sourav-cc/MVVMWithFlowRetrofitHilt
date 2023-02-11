package com.example.setup1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.example.setup1.data.NetworkResult
import com.example.setup1.data.model.SampleResponse
import com.example.setup1.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.getDataFromApi()
        observeData()
    }

    private fun observeData() {
        viewModel.souravResponse.observe(this) {
            when (it) {
                is NetworkResult.Loading -> {
                    binding.progressbar.isVisible = it.isLoading
                }
                is NetworkResult.Success -> {
                    updateUI(it.data)
                    binding.progressbar.isVisible = false
                }
                is NetworkResult.Failure -> {
                    binding.progressbar.isVisible = false
                }
            }
        }
    }

    private fun updateUI(data: SampleResponse) {
        binding.title.text = data.tile
        binding.description.text = data.description
    }

}