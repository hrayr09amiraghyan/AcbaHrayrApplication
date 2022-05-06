package com.example.acbahrayrapplication.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.acbahrayrapplication.R
import com.example.acbahrayrapplication.databinding.FragmentWeatherBinding
import com.example.acbahrayrapplication.formatter.DateFormat
import com.example.acbahrayrapplication.viewModel.WeatherViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class WeatherFragment : Fragment() {

    private val vmWeatherViewModel: WeatherViewModel by viewModel()
    private lateinit var binding: FragmentWeatherBinding

    companion object {
        @JvmStatic
        fun newInstance() = WeatherFragment()
        val DATE_FORMAT_1 = "dd/MM/yyyy"
        val DATE_FORMAT_2 = "yyyy-MM-dd'T'HH:mm:ssZZ"
        val yerevanLocationKey: Long = 16890
        val weatherApiKey: String = "eBwSfxV17hUfJAC6zvR9UmA1cYWbAKPX"

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWeatherBinding.inflate(inflater, container, false);
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.login.setOnClickListener {
            binding.etEmail.validate()
            binding.etPassword.validate()
        }
        vmWeatherViewModel.getWeatherData(yerevanLocationKey, weatherApiKey)

        vmWeatherViewModel.getWeatherData.observe(viewLifecycleOwner, androidx.lifecycle.Observer {

            it.DailyForecasts.let {
                binding.tvDate.setText(
                    context?.getString(
                        R.string.yerevan_weather, DateFormat.convertDaterFormatTo(
                            it.get(0).Date,
                            DATE_FORMAT_2,
                            DATE_FORMAT_1
                        )
                    )
                )

                val minimumDegree = it.get(0).Temperature.Minimum.Value.toString()
                val minimumDegreeType = it.get(0).Temperature.Minimum.Unit
                val weatherMinimumText = minimumDegree.plus(minimumDegreeType)
                binding.minDegree.setText(
                    context?.getString(
                        R.string.yerevan_minimal_weather, weatherMinimumText
                    )
                )

                val maximumDegree = it.get(0).Temperature.Maximum.Value.toString()
                val maximumDegreeType = it.get(0).Temperature.Maximum.Unit
                val weatherMaximumText = maximumDegree.plus(maximumDegreeType)
                binding.maxdegree.setText(
                    context?.getString(
                        R.string.yerevan_maximal_weather, weatherMaximumText
                    )
                )
            }

        })
    }

}