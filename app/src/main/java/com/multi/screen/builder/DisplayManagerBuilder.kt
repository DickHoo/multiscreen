package com.multi.screen.builder

import android.content.Context
import android.content.Context.DISPLAY_SERVICE
import android.hardware.display.DisplayManager
import android.view.Display
import android.view.View
import com.multi.screen.log.ScreenLog
import com.multi.screen.presentation.PresentationScreen

class DisplayManagerBuilder(context: Context) : Builder {
    private var mContext = context
    private var isSupport = true
    private var presentationScreen: PresentationScreen? = null
    private var displays: Array<Display>

    init {
        var displayManager = context.applicationContext.getSystemService(DISPLAY_SERVICE) as DisplayManager
        displays = displayManager.displays
        //displays[0] 主屏，displays[1] 副屏
        if (displays.size <= 1) {
            isSupport = false
            if(!isSupport) ScreenLog.e("不支持分屏")
        }
    }

    override fun addView(view: View): Builder {
        if (displays.size > 1) {
            presentationScreen = PresentationScreen(mContext, displays[1], view)
        }
        return this
    }

    override fun builder(): MultiScreen = MultiScreen.getInstance()

    fun showPresentation() {
        if(!isSupport) ScreenLog.e("不支持分屏")
        presentationScreen?.show()
    }

    fun hidePresentation() {
        if(!isSupport) ScreenLog.e("不支持分屏")
        presentationScreen?.hide()
    }
}