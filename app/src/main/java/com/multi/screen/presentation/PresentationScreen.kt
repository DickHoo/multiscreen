package com.multi.screen.presentation

import android.app.Presentation
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.Display
import android.view.View
import android.view.WindowManager

class PresentationScreen(outerContext: Context?, display: Display?, rootView: View) :
    Presentation(outerContext, display) {
    private var rootView: View

    init {
        this.rootView = rootView
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(rootView)
//        if (Build.VERSION.SDK_INT >= 23) {
//            window?.setType(WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY)
//        } else {
//            window?.setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT)
//        }
    }

}