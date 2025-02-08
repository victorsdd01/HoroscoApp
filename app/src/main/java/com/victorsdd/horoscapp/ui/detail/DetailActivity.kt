package com.victorsdd.horoscapp.ui.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.victorsdd.horoscapp.R
import com.victorsdd.horoscapp.databinding.ActivityDetailBinding
import com.victorsdd.horoscapp.domain.model.HoroscopeModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailBinding
    private val detailViewModel : DetailViewModel by viewModels()

    private val args : DetailActivityArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        detailViewModel.getHoroscope(args.type)
        initUI()
    }

    private fun initUI() {
        listeners()
        initUiState()
    }

    private fun listeners() {
        binding.backBtn.setOnClickListener { onBackPressed() }
    }

    private fun initUiState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                detailViewModel.state.collect{
                    when(it){
                        DetailState.Loading -> {
                            binding.detailProgressBar.isVisible = true
                        }
                        is DetailState.Error -> {
                            binding.detailProgressBar.isVisible = false
                        }
                        is DetailState.Success -> {
                            binding.detailProgressBar.isVisible = false
                            binding.tvTitle.text = it.sign

                            binding.tvDesc.text = it.prediction

                            val image = when(it.horoscopeModel){
                                HoroscopeModel.Aries -> R.drawable.aries
                                HoroscopeModel.Taurus -> R.drawable.tauro
                                HoroscopeModel.Gemini -> R.drawable.geminis
                                HoroscopeModel.Cancer -> R.drawable.cancer
                                HoroscopeModel.Leo -> R.drawable.leo
                                HoroscopeModel.Virgo -> R.drawable.virgo
                                HoroscopeModel.Libra -> R.drawable.libra
                                HoroscopeModel.Scorpio -> R.drawable.escorpio
                                HoroscopeModel.Sagittarius -> R.drawable.sagitario
                                HoroscopeModel.Capricorn -> R.drawable.capricornio
                                HoroscopeModel.Aquarius -> R.drawable.aquario
                                HoroscopeModel.Pisces -> R.drawable.piscis
                            }
                            binding.ivDetail.setImageResource(image)
                        }
                    }
                }
            }
        }
    }
}