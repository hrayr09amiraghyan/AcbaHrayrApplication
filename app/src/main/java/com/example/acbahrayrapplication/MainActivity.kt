package com.example.acbahrayrapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.example.acbahrayrapplication.databinding.ActivityMainBinding
import com.example.acbahrayrapplication.fragment.WeatherFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)
            navigateToWeatherFragment(this@MainActivity)
        }
    }


    fun navigateToWeatherFragment(activity: FragmentActivity) {
        activity
            .supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, WeatherFragment.newInstance())
            .commit()
    }
}