package com.bear.safety.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

public class ViewUtils {
	
	/**
	 * 简化长语句拿View视图
	 * 
	 * @param context
	 * @param layoutId
	 * @return
	 */
	public static View getViewById(Context context, int layoutId){
		return LayoutInflater.from(context).inflate(layoutId, null);
	}
	
	/**
	 * 获取某个layout布局上的子控件
	 * 
	 * @param context
	 * @param layoutId
	 * @param childViewId
	 * @return
	 */
	public static View getChildViewById(Context context, int layoutId, int childViewId){
		View view = getViewById(context, layoutId);
		return view.findViewById(childViewId);
	}

}
