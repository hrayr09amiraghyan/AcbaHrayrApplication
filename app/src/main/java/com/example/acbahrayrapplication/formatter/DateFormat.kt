package com.example.acbahrayrapplication.formatter

import android.annotation.SuppressLint
import java.text.ParseException
import java.text.SimpleDateFormat

object DateFormat {

    @SuppressLint("SimpleDateFormat")
    fun convertDateFormatTo(pDate: String?, pFrom: String?, pTo: String?): String? {
        var sDate: String? = ""
        try {
            val date = pDate?.let { SimpleDateFormat(pFrom).parse(it) }
            sDate = date?.let { SimpleDateFormat(pTo).format(it) }
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return sDate
    }
}