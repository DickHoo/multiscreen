package com.multi.screen.builder

import android.content.Context
import android.media.MediaRouter
import android.view.Display
import android.view.View
import com.multi.screen.log.ScreenLog
import com.multi.screen.presentation.PresentationScreen

class MediaRouterBuilder(context: Context) : Builder {
    private var display: Display? = null
    private var mContext = context
    private var isSupport = true
    private var presentationScreen: PresentationScreen? = null

    init {
        var mediaRouter = context.applicationContext.getSystemService(Context.MEDIA_ROUTER_SERVICE) as MediaRouter
        var route = mediaRouter.getSelectedRoute(MediaRouter.ROUTE_TYPE_LIVE_AUDIO)
        if (route != null) {
            display = route.presentationDisplay
        } else {
            isSupport = false
        }
    }

    override fun addView(view: View): Builder {
        if (display != null) {
            presentationScreen = PresentationScreen(mContext, display, view)
        } else {
            isSupport = false
        }
        if(!isSupport) ScreenLog.e("不支持分屏")
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