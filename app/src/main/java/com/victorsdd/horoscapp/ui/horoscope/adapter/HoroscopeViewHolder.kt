package com.victorsdd.horoscapp.ui.horoscope.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.victorsdd.horoscapp.databinding.ItemHoroscopeBinding
import com.victorsdd.horoscapp.domain.model.HoroscopeInfo

class HoroscopeViewHolder(view : View) : RecyclerView.ViewHolder(view) {
    /** create a new binding instance */
    private val binding = ItemHoroscopeBinding.bind(view)

    /** render the view with the data */
    fun render(horoscopeInfo : HoroscopeInfo, onItemSelected : (HoroscopeInfo) -> Unit){
        binding.ivHoroscope.setImageResource(horoscopeInfo.img)
        binding.tvHoroscope.text = binding.tvHoroscope.context.getString(horoscopeInfo.name)

        binding.parent.setOnClickListener{
            startRotationAnimation(binding.ivHoroscope, newLambda = {onItemSelected(horoscopeInfo)})
        }
    }

    private fun startRotationAnimation(view : View, newLambda : () -> Unit){
        view.animate().apply {
            duration = 800
            interpolator = LinearInterpolator()
            rotationBy(360f)
            withEndAction{ newLambda() }
            start()
        }
    }
}