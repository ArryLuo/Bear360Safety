package com.bear.safety.ui.base;

import com.bear.safety.util.TimerTaskUtil;
import com.bear.safety.util.itf.TimerTaskDelayable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * 所有Activity的基类
 * 
 * @author bear
 *
 */
public class BaseActivity extends Activity implements TimerTaskDelayable{
	
	private Class<?> targetActivity;
	private boolean finishSelf;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	/**
	 * 延时跳转
	 * 
	 * @param cls
	 * @param delayedMills
	 */
	protected void gotoActivityDelayed(Class<?> cls, long delayedMills,boolean finishSelf){
		gotoActivityDelayed(cls, delayedMills, null, finishSelf);
	}
	
	/**
	 * 带参数延时跳转
	 * 
	 * @param cls
	 * @param delayedMills
	 * @param bundle
	 */
	protected void gotoActivityDelayed(Class<?> cls, long delayedMills, Bundle bundle, boolean finishSelf){
		TimerTaskUtil ttu = new TimerTaskUtil(this, delayedMills);
		this.targetActivity = cls;
		this.finishSelf = finishSelf;
		ttu.work();
	}
	
	/**
	 * 跳转
	 * 
	 * @param cls
	 */
	protected void gotoActivity(Class<?> cls) {
		gotoActivity(cls, null);
	}
	
	/**
	 * 带参数跳转
	 * 
	 * @param cls
	 * @param bundle
	 */
	protected void gotoActivity(Class<?> cls, Bundle bundle) {
		Intent intent = new Intent(this, cls);
		if(bundle != null){
			intent.putExtras(bundle);
		}
		startActivity(intent);
	}

	@Override
	public void executeDelayedTask() {
		if(targetActivity != null){
			gotoActivity(targetActivity);
			targetActivity = null;
			if(finishSelf){
				this.finish();
				finishSelf = false;
			}
		}
	}

}
