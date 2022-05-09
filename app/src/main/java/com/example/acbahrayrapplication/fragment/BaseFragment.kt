package com.example.acbahrayrapplication.fragment

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.acbahrayrapplication.R
import com.example.acbahrayrapplication.util.NetworkHelper

abstract class BaseFragment : Fragment() {

    protected fun makeRequestIfNetworkAvailable(context: Context, action: () -> Unit) {
        if (NetworkHelper.isNetworkAvailable(context)) {
            action()
        } else {
            Toast.makeText(
                context,
                context.getString(R.string.no_internet_connection_text),
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}