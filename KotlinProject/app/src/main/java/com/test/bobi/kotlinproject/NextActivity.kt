package com.test.bobi.kotlinproject

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_next.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

/**
 * 对列表的实验activity
 */
class NextActivity : AppCompatActivity(){


    val datas= listOf("test1","test2","test3")
    var adapter:Test1Adapter?=null
    var dialog:TestDialog?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)

        listTest.layoutManager=LinearLayoutManager(this)
        adapter= Test1Adapter(this,datas)
        listTest.adapter=adapter

        /**
         * 震惊！！！通过把java代码转换为kotlin才知道回调的内部类写法是这个样子
         */
        adapter!!.setOnMyItemClickListener(object :Test1Adapter.mOnItemClickListener{
            override fun onItemClick(position: Int) {
                when(position){
                    0->{
                        TestDialog(this@NextActivity).show()
                    }
                    1->{
                        startActivity<AnimationActivity>()
                    }
                }
            }
        })
        /**
         * 下面这个则是通过类实现接口的方式
         */
//        adapter!!.setOnMyItemClickListener(this)
    }

    /**
     * 这里则是实现接口后的点击事件的方法
     */
//    override fun onItemClick(position: Int) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
}
