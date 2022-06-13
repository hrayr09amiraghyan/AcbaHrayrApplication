package com.example.acbahrayrapplication.fragment.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.acbahrayrapplication.databinding.FragmentBasePageRegistrationBinding

abstract class BaseRegistrationPageFragment : BaseFragment() {

    private lateinit var binding: FragmentBasePageRegistrationBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBasePageRegistrationBinding.inflate(inflater, container, false);
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (requireParentFragment() is BaseRegistrationFragment) {
            getNextButton().setOnClickListener(requireParentFragment() as BaseRegistrationFragment)
        }

    }

    abstract fun getPageTitle(): String
    abstract fun getNextButton(): Button
}