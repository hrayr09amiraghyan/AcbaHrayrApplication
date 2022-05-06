package com.example.acbahrayrapplication.formatter

import android.annotation.SuppressLint
import java.text.ParseException
import java.text.SimpleDateFormat

object DateFormat {

    @SuppressLint("SimpleDateFormat")
    open fun convertDaterFormatTo(pDate: String?, pFrom: String?, pTo: String?): String? {
        var sDate: String? = ""
        try {
            val date = SimpleDateFormat(pFrom).parse(pDate)
            sDate = SimpleDateFormat(pTo).format(date)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return sDate
    }
}