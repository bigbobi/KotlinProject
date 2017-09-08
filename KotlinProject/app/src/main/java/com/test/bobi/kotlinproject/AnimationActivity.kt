package com.test.bobi.kotlinproject

import android.graphics.drawable.ClipDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_animation.*

/**
 * 倒计时+viewpager+ClipDrawable的试验activity
 */
class AnimationActivity : AppCompatActivity() {
//    var clipDrawable:ClipDrawable?=null

//    var countDown: CountDownTimer?=null
//
//    var level:Int=10000
//    var maxTime:Float= 2000F

    val pic= listOf(R.mipmap.fgo_test1.toString(),R.mipmap.fgo_test2.toString())
//    var bannerAdapter:MyBannerAdapter?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)

        banner!!.setData(pic)
//        bannerAdapter= MyBannerAdapter(this)


//        /**
//         * 获取ClipDrawable的图像，并让其显示，level的必须是10000才能完整显示，为0便完全消失
//         */
//        clipDrawable= ivClip.background as ClipDrawable?
//        clipDrawable!!.setLevel(level)
//
//        /**
//         * 倒计时控件的内部类实现方式，和设置控件的监听的方式类似
//         */
//        countDown=object:CountDownTimer(maxTime.toLong(),50){
//
//            override fun onTick(millisUntilFinished: Long) {
//                level=((level-(10000*(50f/maxTime))).toInt())
//                clipDrawable!!.setLevel(level)
//            }
//
//            override fun onFinish() {
//                clipDrawable!!.setLevel(0)
//            }
//
//        }
//
        btnClick.setOnClickListener{
//            countDown!!.start()
            banner.drawCard()
        }
    }
}
