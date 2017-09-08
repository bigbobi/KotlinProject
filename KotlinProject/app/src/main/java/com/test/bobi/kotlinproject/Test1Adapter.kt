package com.test.bobi.kotlinproject

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * kotlin下adapter的使用方式，没有太大变化
 * Created by bobi on 2017/7/6.
 */
class Test1Adapter(val context: Context,val datas:List<String>):RecyclerView.Adapter<Test1Adapter.ViewHolder>(){

    var myListener:mOnItemClickListener?=null

    interface mOnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnMyItemClickListener(myListener: mOnItemClickListener){
        this.myListener=myListener
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val mInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view=mInflater.inflate(R.layout.layout_test1,null)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder!!.textView!!.setText(datas.get(position))
    }

    /**
     * 依然是viewHolder的模式，但初始化使用kotlin中预设的init代码块
     */
    inner class ViewHolder(item: View) : RecyclerView.ViewHolder(item){
        var rootView:View?=null
        var textView:TextView?=null
        init {
            rootView=item
            textView= rootView!!.findViewById(R.id.tvTest) as TextView?
            textView!!.setOnClickListener {
                if(myListener!=null){
                    myListener!!.onItemClick(layoutPosition)
                }
            }
        }
    }





}