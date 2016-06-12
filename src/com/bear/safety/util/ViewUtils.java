package com.bear.safety.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

public class ViewUtils {
	
	/**
	 * �򻯳������View��ͼ
	 * 
	 * @param context
	 * @param layoutId
	 * @return
	 */
	public static View getViewById(Context context, int layoutId){
		return LayoutInflater.from(context).inflate(layoutId, null);
	}
	
	/**
	 * ��ȡĳ��layout�����ϵ��ӿؼ�
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
