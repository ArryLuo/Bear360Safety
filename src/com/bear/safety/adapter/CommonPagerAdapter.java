package com.bear.safety.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public class CommonPagerAdapter extends PagerAdapter {

	private View[] viewsArr;

	public CommonPagerAdapter(View[] arr) {
		this.viewsArr = arr;
	}

	@Override
	public int getCount() {
		return viewsArr.length;
	}

	@Override
	public boolean isViewFromObject(View view, Object obj) {
		return view == obj;
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		View view = viewsArr[position];
		container.addView(view);
		return view;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		View view = viewsArr[position];
		container.removeView(view);
	}

}
