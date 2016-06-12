package com.bear.safety.ui;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bear.safety.R;
import com.bear.safety.adapter.BearViewAdapter;
import com.bear.safety.adapter.CommonListViewAdapter;
import com.bear.safety.adapter.CommonListViewItemHolder;
import com.bear.safety.adapter.CommonPagerAdapter;
import com.bear.safety.data.MainDataSet;
import com.bear.safety.listener.BearAnimationListener;
import com.bear.safety.listener.BearPageChangedListener;
import com.bear.safety.model.MainGridViewItem;
import com.bear.safety.ui.base.BaseActivity;
import com.bear.safety.util.ViewUtils;
import com.slidingmenu.lib.SlidingMenu;

public class MainActivity extends BaseActivity implements OnClickListener, OnItemClickListener {

	private ViewPager mViewPager;
	private ImageView mMenuView; // 弹出侧滑菜单控件
	private ImageView mSettingsView;
	private ImageView mNotiModelView;
	private ImageView mPageNumView; // 页码指示控件
	private View coverView; // 遮盖控件

	private SlidingMenu slidingMenu; // 侧滑菜单

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		setupViews();
	}

	private void setupViews() {
		mViewPager = (ViewPager) findViewById(R.id.main_viewpager);
		mMenuView = (ImageView) findViewById(R.id.imageView3);
		mSettingsView = (ImageView) findViewById(R.id.imageView4);
		mNotiModelView = (ImageView) findViewById(R.id.imageView5);
		mPageNumView = (ImageView) findViewById(R.id.imageView6);
		coverView = findViewById(R.id.main_cover_view);

		mMenuView.setOnClickListener(this);
		mPageNumView.setOnClickListener(this);

		GridView gridView1 = (GridView) ViewUtils.getChildViewById(this,
				R.layout.gridview_main, R.id.gridView1);
		GridView gridView2 = (GridView) ViewUtils.getChildViewById(this,
				R.layout.gridview_main, R.id.gridView1);

		CommonListViewAdapter<MainGridViewItem> adapter1 = getCommonListViewAdapter(0);
		CommonListViewAdapter<MainGridViewItem> adapter2 = getCommonListViewAdapter(1);

		gridView1.setAdapter(adapter1);
		gridView2.setAdapter(adapter2);
		
		gridView1.setOnItemClickListener(this);
		gridView2.setOnItemClickListener(this);

		View[] arr = new View[2];
		arr[0] = gridView1;
		arr[1] = gridView2;
		CommonPagerAdapter pagerAdapter = new CommonPagerAdapter(arr);
		mViewPager.setAdapter(pagerAdapter);

		mViewPager.setOnPageChangeListener(new BearPageChangedListener() {
			@Override
			public void onPageSelected(int position) {
				showPageNumAnim();
			}
		});

		initSlidingMenu();
	}

	/**
	 * 获取GridView的Adapter
	 * 
	 * @param num
	 * @return
	 */
	private CommonListViewAdapter<MainGridViewItem> getCommonListViewAdapter(
			int num) {
		CommonListViewAdapter<MainGridViewItem> adapter = new CommonListViewAdapter<MainGridViewItem>(
				MainActivity.this, MainDataSet.getList(num),
				R.layout.item_gridview_main) {

			@Override
			protected void setupListItemViews(CommonListViewItemHolder holder,
					MainGridViewItem t) {
				holder.setImageByResId(R.id.item_gridview_main_iamgeview,
						t.getImgId()).setText(R.id.item_gridview_main_textview,
						t.getName());
			}
		};

		return adapter;
	}

	/**
	 * 展示pagenum图片动画
	 */
	private void showPageNumAnim() {
		Animation animPageIn = AnimationUtils.loadAnimation(this,
				R.anim.page_in);

		animPageIn.setAnimationListener(new BearAnimationListener() {
			@Override
			public void onAnimationEnd(Animation animation) {
				Animation animPageOut = AnimationUtils.loadAnimation(
						MainActivity.this, R.anim.page_out);
				int currentViewItem = mViewPager.getCurrentItem(); // 因为只有两个view，所以值是0或者1
				switch (currentViewItem) {
				case 0:
					mPageNumView.setImageResource(R.drawable.main_page_one);
					break;
				case 1:
					mPageNumView.setImageResource(R.drawable.main_page_two);
					break;
				}
				mPageNumView.startAnimation(animPageOut);
			}
		});

		mPageNumView.startAnimation(animPageIn);
	}

	/**
	 * 初始化侧滑菜单
	 */
	private void initSlidingMenu() {
		slidingMenu = new SlidingMenu(this);
		slidingMenu.setMode(SlidingMenu.RIGHT);
		slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
		slidingMenu.setBehindWidth(120); // 设置菜单宽度
		slidingMenu.setFadeDegree(0.35f);
		slidingMenu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
		slidingMenu.setMenu(R.layout.slidingmenu_main); // 设置菜单布局
		
		//为slidingmenu的子控件设置监听器
		BearViewAdapter slidingMenuAdapter = new BearViewAdapter(slidingMenu.getMenu());
		slidingMenuAdapter.setViewOnClickedListener(R.id.slidingmenu_item_01, this)
			.setViewOnClickedListener(R.id.slidingmenu_item_02, this)
			.setViewOnClickedListener(R.id.slidingmenu_item_03, this)
			.setViewOnClickedListener(R.id.slidingmenu_item_04, this)
			.setViewOnClickedListener(R.id.slidingmenu_item_05, this);
		
		slidingMenu.setOnClosedListener(new SlidingMenu.OnClosedListener() {

			@Override
			public void onClosed() {
				coverView.setVisibility(View.GONE);
				mMenuView.setBackgroundResource(R.drawable.main_menu_normal);
			}
		});
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.imageView3:
			// mMenuView clicked
			slidingMenu.showMenu();
			coverView.setVisibility(View.VISIBLE);
			mMenuView.setBackgroundResource(R.drawable.main_menu_negative_normal);
			break;
		case R.id.imageView6:
			int currentViewItem = mViewPager.getCurrentItem();
			if(currentViewItem == 0){
				mViewPager.setCurrentItem(1);
			}else{
				mViewPager.setCurrentItem(0);
			}
			break;
		case R.id.slidingmenu_item_01:
			//TODO
			break;
		case R.id.slidingmenu_item_02:
			//TODO
			break;
		case R.id.slidingmenu_item_03:
			//TODO
			break;
		case R.id.slidingmenu_item_04:
			//TODO
			break;
		case R.id.slidingmenu_item_05:
			//TODO
			break;
			
		}
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View view, int position, long id) {
		TextView tv = (TextView) view.findViewById(R.id.item_gridview_main_textview);
		String txt = tv.getText().toString();
		if("手机清理".equals(txt)){
			gotoActivity(PhoneClearActivity.class);
		}
	}

}
