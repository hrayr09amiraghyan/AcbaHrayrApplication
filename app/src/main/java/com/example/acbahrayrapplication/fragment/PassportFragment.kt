package com.example.acbahrayrapplication.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.acbahrayrapplication.databinding.FragmentRegistrationPassportBinding
import com.example.acbahrayrapplication.fragment.base.BaseRegistrationPageFragment

class PassportFragment : BaseRegistrationPageFragment(){

    private lateinit var binding: FragmentRegistrationPassportBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrationPassportBinding.inflate(inflater, container, false);
        return binding.root
    }

    override fun getPageTitle(): String {
       return "Passport"
    }

    override fun getNextButton(): Button {
        TODO("Not yet implemented")
    }
}