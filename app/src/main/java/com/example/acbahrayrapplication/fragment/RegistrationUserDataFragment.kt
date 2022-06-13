package com.example.acbahrayrapplication.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.acbahrayrapplication.databinding.FragmentRegistrationUserDataBinding
import com.example.acbahrayrapplication.fragment.base.BaseRegistrationPageFragment

class RegistrationUserDataFragment : BaseRegistrationPageFragment() {

    private lateinit var binding: FragmentRegistrationUserDataBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrationUserDataBinding.inflate(inflater, container, false);
        return binding.root
    }

    override fun getPageTitle(): String {
        return "User Data"
    }

    override fun getNextButton(): Button {
        TODO("Not yet implemented")
    }
}