package com.test.bobi.kotlinproject

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /**kotlinx.android.synthetic.main.activity_main.*通过导入这句，就可以不必进行控件绑定的操作，直接对控件id进行操作*/
        hello.setText("fuck you")//
        /**kotlin的点击事件，至于toast的用法是因为引入了anko的库*/
        hello.setOnClickListener(View.OnClickListener {
            toast("hello")
            /**anko库中的跳转方法*/
            startActivity<NextActivity>()
            /**kotlin的跳转*/
//            startActivity(Intent(this,NextActivity::class.java))
        })
    }
}
