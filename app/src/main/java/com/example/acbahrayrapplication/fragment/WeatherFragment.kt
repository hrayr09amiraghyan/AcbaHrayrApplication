package com.example.acbahrayrapplication.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.acbahrayrapplication.R
import com.example.acbahrayrapplication.databinding.FragmentWeatherBinding
import com.example.acbahrayrapplication.formatter.DateFormat
import com.example.acbahrayrapplication.util.Constants.DATE_FORMAT_1
import com.example.acbahrayrapplication.util.Constants.DATE_FORMAT_2
import com.example.acbahrayrapplication.util.Constants.weatherApiKey
import com.example.acbahrayrapplication.util.Constants.yerevanLocationKey
import com.example.acbahrayrapplication.util.Response
import com.example.acbahrayrapplication.viewModel.WeatherViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class WeatherFragment : BaseFragment() {

    private val vmWeatherViewModel: WeatherViewModel by viewModel()
    private lateinit var binding: FragmentWeatherBinding

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

        makeRequestIfNetworkAvailable(requireContext()) {
            vmWeatherViewModel.getWeatherData(yerevanLocationKey, weatherApiKey)
        }

        vmWeatherViewModel.getWeatherData.observe(viewLifecycleOwner) {
            when (it) {
                is Response.Loading -> {

                }
                is Response.Success -> {
                    it.data?.DailyForecasts?.get(0).let {
                        binding.tvDate.setText(
                            context?.getString(
                                R.string.yerevan_weather, DateFormat.convertDateFormatTo(
                                    it?.Date,
                                    DATE_FORMAT_2,
                                    DATE_FORMAT_1
                                )
                            )
                        )

                        val minimumDegree = it?.Temperature?.Minimum?.Value.toString()
                        val minimumDegreeType = it?.Temperature?.Minimum?.Unit
                        val weatherMinimumText = minimumDegree.plus(minimumDegreeType)
                        binding.minDegree.setText(
                            context?.getString(
                                R.string.yerevan_minimal_weather, weatherMinimumText
                            )
                        )

                        val maximumDegree = it?.Temperature?.Maximum?.Value.toString()
                        val maximumDegreeType = it?.Temperature?.Maximum?.Unit
                        val weatherMaximumText = maximumDegree.plus(maximumDegreeType)
                        binding.maxdegree.setText(
                            context?.getString(
                                R.string.yerevan_maximal_weather, weatherMaximumText
                            )
                        )
                    }
                }
                is Response.Error -> {
                    Toast.makeText(
                        requireContext(),
                        it.message.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

}