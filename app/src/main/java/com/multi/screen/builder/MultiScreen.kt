package com.multi.screen.builder

import android.content.Context
import com.multi.screen.log.ScreenLog


class MultiScreen {

    private var mediaRouterBuilder: MediaRouterBuilder? = null

    private var displayManagerBuilder: DisplayManagerBuilder? = null


    companion object {

        private var multiScreen = MultiScreen()

        fun getInstance(): MultiScreen {
            return multiScreen
        }

        fun openLog() {
            ScreenLog.debug = true
        }
    }

    fun getMediaRouterBuilder(context: Context): Builder {
        if (mediaRouterBuilder == null)
            mediaRouterBuilder = MediaRouterBuilder(context)
        return mediaRouterBuilder as MediaRouterBuilder
    }

    fun showMediaRouter() {
        mediaRouterBuilder?.showPresentation()
    }

    fun hideMediaRouter() {
        mediaRouterBuilder?.hidePresentation()
    }


    fun getDisplayManagerBuilder(context: Context): Builder {
        if (displayManagerBuilder == null)
            displayManagerBuilder = DisplayManagerBuilder(context)
        return displayManagerBuilder as DisplayManagerBuilder
    }

    fun showDisplayManager() {
        displayManagerBuilder?.showPresentation()
    }

    fun hideDisplayManager() {
        displayManagerBuilder?.hidePresentation()
    }


}

