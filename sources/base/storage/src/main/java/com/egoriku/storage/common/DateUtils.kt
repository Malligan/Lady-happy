package com.egoriku.storage.common

import com.egoriku.storage.common.DateUtils.Holder.newsSimpleDate
import java.text.SimpleDateFormat
import java.util.*

@Deprecated("Should use more convenient way")
class DateUtils private constructor() {

    private object Holder {
        val INSTANCE = DateUtils()
        val newsSimpleDate = SimpleDateFormat("dd MMM, yyyy", Locale.getDefault())
    }

    companion object {
        val instance: DateUtils by lazy { Holder.INSTANCE }
    }

    fun convertNewsDateToString(date: Date): String = newsSimpleDate.format(date)
}