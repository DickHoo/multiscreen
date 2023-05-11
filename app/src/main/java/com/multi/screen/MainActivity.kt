package com.multi.screen

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.multi.screen.builder.MultiScreen
import com.multi.screen.databinding.ActivityMainBinding
import com.multi.screen.databinding.PresentationMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    //方式1
    private lateinit var mediaRouterBinding: PresentationMainBinding
    private lateinit var mediaRouterMultiScreen: MultiScreen

    //方式2
    private lateinit var displayManagerBinding: PresentationMainBinding
    private lateinit var displayManagerMultiScreen: MultiScreen
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        MultiScreen.openLog()
        mediaRouterPresentation()
        displayManagerPresentation()
    }

    //方式1
    private fun mediaRouterPresentation() {
        mediaRouterBinding = PresentationMainBinding.inflate(LayoutInflater.from(this))
        mediaRouterMultiScreen =
            MultiScreen.getInstance().getMediaRouterBuilder(this).addView(mediaRouterBinding.root).builder()
        binding.btnMediaRouter.setOnClickListener {
            mediaRouterMultiScreen.showMediaRouter()
        }
        binding.btnMediaRouterClose.setOnClickListener {
            mediaRouterMultiScreen.hideMediaRouter()
        }
        binding.btnMediaRouterChange.setOnClickListener {
            mediaRouterBinding.tvPresentation.text = "修改了方式1数据"
            mediaRouterBinding.root.background = getDrawable(R.mipmap.bg)
            mediaRouterBinding.imgIcon.setImageDrawable(getDrawable(R.mipmap.img_icon))
        }
    }

    //方式2
    private fun displayManagerPresentation() {
        displayManagerBinding = PresentationMainBinding.inflate(LayoutInflater.from(this))
        displayManagerMultiScreen =
            MultiScreen.getInstance().getDisplayManagerBuilder(this).addView(displayManagerBinding.root).builder()
        binding.btnDisplayManager.setOnClickListener {
            displayManagerMultiScreen.showDisplayManager()
        }
        binding.btnDisplayManagerClose.setOnClickListener {
            displayManagerMultiScreen.hideDisplayManager()
        }
        binding.btnDisplayManagerChange.setOnClickListener {
            displayManagerBinding.tvPresentation.text = "修改了方式2数据"
        }
    }

}