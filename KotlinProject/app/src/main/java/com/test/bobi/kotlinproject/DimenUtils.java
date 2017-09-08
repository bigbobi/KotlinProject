package com.test.bobi.kotlinproject;

import android.content.Context;

public class DimenUtils {

	public static float density;
	public static float scaledDensity;

	/**
	 * 根据手机的分辨率从 dip 的单位 转成为 px(像素)
	 */
	public static int dip2px(Context context, float dipValue){
		if (density == 0)density = context.getResources().getDisplayMetrics().density;
        return (int)(dipValue * density + 0.5f);
	}

	/**
	 * 根据手机的分辨率从 px(像素) 的单位 转成为 dp/dip
	 */
	public static int px2dip(Context context, float pxValue){
		if (density == 0)density = context.getResources().getDisplayMetrics().density;
	        return (int)(pxValue / density + 0.5f);
	}

	public static float sp2px(Context context, float spValue) {
		if (scaledDensity == 0)scaledDensity = context.getResources().getDisplayMetrics().scaledDensity;
		return (int) (spValue * scaledDensity + 0.5f);
	}

}
