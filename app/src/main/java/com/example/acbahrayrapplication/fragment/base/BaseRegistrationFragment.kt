package com.example.acbahrayrapplication.fragment.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.acbahrayrapplication.adapter.ViewPagerAdapter
import com.example.acbahrayrapplication.databinding.FragmentBaseRegistrationBinding

abstract class BaseRegistrationFragment : BaseFragment(), View.OnClickListener {

    private lateinit var binding: FragmentBaseRegistrationBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBaseRegistrationBinding.inflate(inflater, container, false);
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar()
        initViewPagerAdapter()
        initViewpagerCallBack()
        handleBackClick()
    }

    private fun initToolbar() {
        binding.toolbar.title = getTitle()
        binding.toolbar.navigationIcon = ContextCompat.getDrawable(requireContext(), getResId());
    }

    private fun initViewPagerAdapter() {
        binding.viewPager.adapter =
            ViewPagerAdapter(getFragmentList(), this.childFragmentManager, lifecycle)
    }

    private fun initViewpagerCallBack() {
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.toolbar.title = getFragmentList()[position].getPageTitle()

            }
        })
    }

    private fun handleBackClick() {
        binding.toolbar.setNavigationOnClickListener {
            handlePopBack()
        }
    }

    private fun handlePopBack() {
        if (binding.viewPager.currentItem > 0) {
            binding.viewPager.currentItem--
        } else {
            requireActivity().onBackPressed()
        }
    }

    override fun onClick(p0: View?) {
        if (binding.viewPager.currentItem < getFragmentList().size - 1) {
            binding.viewPager.currentItem++
        } else {
            //TODO
        }
    }

    abstract fun getTitle(): String
    abstract fun getResId(): Int
    abstract fun getFragmentList(): List<BaseRegistrationPageFragment>

}