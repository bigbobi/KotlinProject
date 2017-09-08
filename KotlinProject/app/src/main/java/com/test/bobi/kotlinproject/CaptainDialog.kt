package com.test.bobi.kotlinproject

import android.app.Dialog
import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.view.WindowManager


/**
 * name:Dialog队长
 * 描述:真·自定义Dialog·真鸡儿Dick
 * Created by bobi on 2017/2/6.
 */

class CaptainDialog : Dialog {
    private var height: Int = 0
    private var width: Int = 0
    private var cancelTouchout: Boolean = false
    private var view: View? = null

    constructor(builder: Builder) : super(builder.context) {
        height = builder.height
        width = builder.width
        cancelTouchout = builder.cancelTouchout
        view = builder.rootView
    }

    constructor(builder: Builder, themeResId: Int) : super(builder.context, themeResId) {
        height = builder.height
        width = builder.width
        cancelTouchout = builder.cancelTouchout
        view = builder.rootView
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view!!)

        setCanceledOnTouchOutside(cancelTouchout)
        val win = window
        val lp = win!!.attributes
        lp.gravity = Gravity.CENTER
        lp.height = height
        lp.width = width
        win.attributes = lp
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
    }

    class Builder( val context: Context) {
        var height: Int = 0
         var width: Int = 0
        var cancelTouchout: Boolean = false
        var rootView: View? = null
         var resStyle = -1

        fun view(resView: Int): Builder {
            rootView = LayoutInflater.from(context).inflate(resView, null)
            return this
        }

        fun view(v: View): Builder {
            rootView = v
            return this
        }

        fun heightpx(`val`: Int): Builder {
            height = `val`
            return this
        }

        fun widthpx(`val`: Int): Builder {
            width = `val`
            return this
        }

        fun heightdp(`val`: Int): Builder {
            height = DimenUtils.dip2px(context, `val`.toFloat())
            return this
        }

        fun widthdp(`val`: Int): Builder {
            width = DimenUtils.dip2px(context, `val`.toFloat())
            return this
        }

        fun heightDimenRes(dimenRes: Int): Builder {
            height = context.resources.getDimensionPixelOffset(dimenRes)
            return this
        }

        fun widthDimenRes(dimenRes: Int): Builder {
            width = context.resources.getDimensionPixelOffset(dimenRes)
            return this
        }

        fun style(resStyle: Int): Builder {
            this.resStyle = resStyle
            return this
        }

        fun cancelTouchout(`val`: Boolean): Builder {
            cancelTouchout = `val`
            return this
        }

        fun addViewOnclick(viewRes: Int, listener: View.OnClickListener): Builder {
            rootView!!.findViewById(viewRes).setOnClickListener(listener)
            return this
        }

        //        public Builder loadPic(int viewRes,String url){
        //            ((SimpleDraweeView)view.findViewById(viewRes)).setImageURI(Uri.parse(url));
        //            return this;
        //        }

        fun getView(viewRes: Int): View {
            return rootView!!.findViewById(viewRes)
        }

        fun build(): Dialog {
            if (resStyle != -1) {
                return CaptainDialog(this, resStyle)
            } else {
                return CaptainDialog(this)
            }
        }
    }
}
