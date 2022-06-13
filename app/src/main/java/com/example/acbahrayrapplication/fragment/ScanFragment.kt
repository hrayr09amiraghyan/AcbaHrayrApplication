package com.example.acbahrayrapplication.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.NavHostFragment
import com.example.acbahrayrapplication.databinding.FragmentRegistrationScanBinding
import com.example.acbahrayrapplication.fragment.base.BaseRegistrationPageFragment

class ScanFragment : BaseRegistrationPageFragment() {

    private lateinit var binding: FragmentRegistrationScanBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrationScanBinding.inflate(inflater, container, false);
        return binding.root
    }

    override fun getPageTitle(): String {
        return "Scan"
    }

    override fun getNextButton(): Button {
        return binding.next
    }


}