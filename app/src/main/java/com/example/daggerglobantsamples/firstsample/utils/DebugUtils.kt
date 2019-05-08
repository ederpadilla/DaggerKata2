package com.example.daggerglobantsamples.firstsample.utils

import android.util.Log

object DebugUtils {

    const val CHARACTER = "character"

    const val QUOTE = "quote"

    fun showLog(tag : String, message : String) {
        Log.e(tag,message)
    }
}