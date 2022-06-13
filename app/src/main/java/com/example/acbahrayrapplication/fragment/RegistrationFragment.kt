package com.example.acbahrayrapplication.fragment

import com.example.acbahrayrapplication.R
import com.example.acbahrayrapplication.fragment.base.BaseRegistrationFragment
import com.example.acbahrayrapplication.fragment.base.BaseRegistrationPageFragment

class RegistrationFragment : BaseRegistrationFragment() {

    override fun getTitle(): String {
        return "Registration"
    }

    override fun getResId(): Int {
        return R.drawable.ic_back
    }


    override fun getFragmentList(): List<BaseRegistrationPageFragment> {
        return listOf(ScanFragment(), PassportFragment(), RegistrationUserDataFragment())
    }


}