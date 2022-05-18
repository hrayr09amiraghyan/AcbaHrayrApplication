package com.example.acbahrayrapplication

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import com.example.acbahrayrapplication.databinding.ActivityMainBinding
import com.example.hrayracbalibrary.ViewValidator

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)
            login.setOnClickListener {
                validateViews(root)
            }
        }
    }

    private fun validateViews(root: View) {
        if (root is ViewGroup) {
            for (view in root.children) {
                validateViews(view)
            }
        } else if (root is ViewValidator) {
            root.validate()
        }
    }
}