package com.bear.safety.adapter;

import com.bear.safety.util.ViewUtils;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class CommonListViewItemHolder {
	
	private SparseArray<View> viewsMap;
	private View convertView;
	
	private CommonListViewItemHolder(View view){
		this.viewsMap = new SparseArray<View>();
		this.convertView = view;
	}

	/**
	 * 获取CommonListViewItemHolder对象
	 * 
	 * @return
	 */
	public static CommonListViewItemHolder getCommonListViewItemHolder(
			Context context, int layoutId, int position, View convertView,
			ViewGroup parent) {
		CommonListViewItemHolder holder = null;
		if(convertView == null){
			convertView = ViewUtils.getViewById(context, layoutId);
			holder = new CommonListViewItemHolder(convertView);
			convertView.setTag(holder);
		}else{
			holder = (CommonListViewItemHolder) convertView.getTag();
		}
		return holder;
	}

	public View getConvertView() {
		return convertView;
	}
	
	public View getViewById(int viewId){
		View view = viewsMap.get(viewId);
		if(view == null){
			view = getConvertView().findViewById(viewId);
		}
		return view;
	}
	
	public CommonListViewItemHolder setText(int textviewId, String content){
		TextView tv = (TextView) getViewById(textviewId);
		tv.setText(content);
		return this;
	}
	
	public CommonListViewItemHolder setImageByResId(int imageviewId, int resId){
		ImageView iv = (ImageView) getViewById(imageviewId);
		iv.setImageResource(resId);
		return this;
	}
	
}
