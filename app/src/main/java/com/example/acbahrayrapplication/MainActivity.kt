package com.example.acbahrayrapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.acbahrayrapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)
        }
    }

}