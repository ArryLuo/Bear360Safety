package com.bear.safety.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class CommonListViewAdapter<T extends Object> extends BaseAdapter {

	private Context mContext;
	private List<T> mList;
	private int itemId;

	public CommonListViewAdapter(Context context, List<T> tList, int layoutId) {
		this.mContext = context;
		this.mList = tList;
		this.itemId = layoutId;
	}

	@Override
	public int getCount() {
		return mList.size();
	}

	@Override
	public Object getItem(int position) {
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		//代码的重用
		CommonListViewItemHolder holder = CommonListViewItemHolder
				.getCommonListViewItemHolder(mContext, itemId, position,
						convertView, parent);
		//代码的扩展
		setupListItemViews(holder, mList.get(position));
		return holder.getConvertView();
	}
	
	protected abstract void setupListItemViews(CommonListViewItemHolder holder, T t);
}
