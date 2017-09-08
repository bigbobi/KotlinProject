package com.test.bobi.kotlinproject;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;

/**
 * B式banner的baseAdapter
 * Created by bobi on 2017/5/24.
 */

public abstract class BaseBannerAdapter extends PagerAdapter {
    public Context context;

    public abstract void setData(Object listData);

    public abstract int getItemCount();

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return false;
    }
}
