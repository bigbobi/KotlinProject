package com.test.bobi.kotlinproject;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import java.util.ArrayList;
import java.util.List;

/**
 * banner用的adapter
 * Created by bobi on 2017/5/17.
 */

public class MyBannerAdapter extends BaseBannerAdapter {
    private List<String> listData;
    private Context context;
    private ImageView ivClip;
//    private

    public MyBannerAdapter(Context context) {
        this.context = context;
        listData = new ArrayList<>();
    }

    public void setData(List<? extends String> datas) {
        listData.clear();
        listData.addAll(datas);
        notifyDataSetChanged();
    }

    public String getItem(int position) {
        if (position < listData.size() && position >= 0)
            return listData.get(position);
        else
            return null;
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public void setData(Object listData) {
        this.listData = (List<String>) listData;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        int size = listData.size();
        return size > 2 ? size - 2 : size;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        if (object != null && object instanceof View)
            container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View v = View.inflate(context, R.layout.item_loop, null);
        ImageView ivTest= (ImageView) v.findViewById(R.id.ivTest);

        ivClip = (ImageView) v.findViewById(R.id.ivClip);
        ivTest.setBackgroundResource(Integer.parseInt(listData.get(position)));
        container.addView(v);
        return v;
    }

//    public void showCradBg(){
//        get
//    }
}
