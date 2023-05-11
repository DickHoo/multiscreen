package com.multi.screen.log

import android.util.Log

object ScreenLog {
    private val TAG = ScreenLog.javaClass.name
    var debug = false
    fun e(msg: String) {
        if (debug)
            Log.e(TAG, msg)
    }
}