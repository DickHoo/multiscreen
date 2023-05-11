package com.multi.screen.builder

import android.view.View

interface Builder {

    fun addView(view: View):Builder

    fun builder(): MultiScreen
}