package com.test.bobi.kotlinproject

import android.app.Dialog
import android.content.Context
import android.view.WindowManager

/**
 * 一个dialog的类
 * Created by bobi on 2017/8/2.
 */
class TestDialog( context: Context){
    var builder:CaptainDialog.Builder? = null
    var dialog:Dialog?=null
    init {
        builder=CaptainDialog.Builder(context)
        dialog=builder!!.cancelTouchout(true)
                .view(R.layout.dialog_test)
                .heightdp(300)
                .widthdp(200)
                .style(R.style.transparentFrameWindowStyle)
                .build()
        dialog!!.window.setBackgroundDrawableResource(R.color.transparent)

    }

    fun show(){
        if (null!=dialog){
            dialog!!.show()
        }
    }

    fun dismiss(){
        if(null!=dialog){
            dialog!!.dismiss()
        }
    }
}