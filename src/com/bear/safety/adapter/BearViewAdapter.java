package com.bear.safety.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class BearViewAdapter {

	private View rootView;
	private SparseArray<View> viewsList;
	
	
	public BearViewAdapter(View view){
		this.rootView = view;
		this.viewsList = new SparseArray<View>();
	}
	
	/**
	 * 
	 * @param context
	 * @param layoutId  待解析的layout的id
	 * @param root 目标layout的父容器
	 */
	public BearViewAdapter(Context context, int layoutId, ViewGroup root) {
		rootView = LayoutInflater.from(context).inflate(layoutId, root, true);
		viewsList = new SparseArray<View>();
	}
	
	public View getRootView() {
		return rootView;
	}
	
	public View getViewById(int viewId){
		View view = viewsList.get(viewId);
		if(view == null){
			view = rootView.findViewById(viewId);
			viewsList.put(viewId, view);
		}
		return view;
	}
	
	public BearViewAdapter setText(int viewId, String content){
		TextView tv = (TextView) getViewById(viewId);
		tv.setText(content);
		return this;
	}
	
	public BearViewAdapter setButtonText(int viewId, String content){
		Button btn = (Button) getViewById(viewId);
		btn.setText(content);
		return this;
	}
	
	public BearViewAdapter setViewOnClickedListener(int viewId, OnClickListener listener){
		View view = getViewById(viewId);
		view.setOnClickListener(listener);
		return this;
	}
}
