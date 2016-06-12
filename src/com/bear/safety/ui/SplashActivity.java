package com.bear.safety.ui;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.bear.safety.R;
import com.bear.safety.listener.BearAnimationListener;
import com.bear.safety.ui.base.BaseActivity;
import com.bear.safety.util.ViewUtils;

public class SplashActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		View view = ViewUtils.getViewById(this, R.layout.activity_splash);
		setContentView(view);
		Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
		anim.setAnimationListener(new BearAnimationListener() {
			@Override
			public void onAnimationEnd(Animation animation) {
				gotoActivityDelayed(MainActivity.class, 500,true);
			}
		});
		view.startAnimation(anim);
	}
}
