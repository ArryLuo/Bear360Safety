package com.bear.safety.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;

import com.bear.safety.R;
import com.bear.safety.adapter.BearViewAdapter;

/**
 * �ֻ����� 
 *  
 * @author Administrator
 *
 */
public class PhoneClearActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_phone_clear);
		setupViews();
	}
	
	private void setupViews(){
		BearViewAdapter bearViewAdapter = new BearViewAdapter(this,
				R.layout.actionbar_layout,
				(ViewGroup) findViewById(R.id.LinearLayout1));
		
		bearViewAdapter.setButtonText(R.id.bar_left_btn, "����")
			.setButtonText(R.id.bar_right_btn, "��ʱ")
			.setText(R.id.bar_center_textview, "�ֻ�����")
			.setViewOnClickedListener(R.id.bar_left_btn, new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					
				}
			}).setViewOnClickedListener(R.id.bar_right_btn, new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					
				}
			});
	}

}
