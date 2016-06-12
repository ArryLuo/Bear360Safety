package com.bear.safety.data;

import java.util.ArrayList;
import java.util.List;

import com.bear.safety.R;
import com.bear.safety.model.MainGridViewItem;

public class MainDataSet {

	// 定义整型数组 即图片源 main1
	public static int[][] mImageIds = { { R.drawable.disk_sysclear_alert,// 手机清理
			R.drawable.disk_phone_block,// 骚扰拦截
			R.drawable.disk_phone_exam_default,// 手机体检
			R.drawable.disk_privacy_protection,// 隐私空间
			R.drawable.disk_anti_scan,// 手机杀毒
			R.drawable.disk_power_manager,// 节电管理
			R.drawable.disk_program_manager,// 手机管家
			R.drawable.disk_active_defense,// 隐私行为监控

	}, { R.drawable.disk_flow_traffic,// 流量监控
			R.drawable.disk_secure_bak,// 通讯录备份
			R.drawable.disk_phone_anti_open,// 手机防盗
			R.drawable.disk_app_market,// 安全市场
			R.drawable.disk_advertise_block,// 恶意广告拦截
			R.drawable.qr_code,// 安全二维码
			R.drawable.disk_use_tools,// 应用工具
	} };
	// 主界面1GridViewItem名
	public static String[][] itemName = {
			{ "手机清理", "骚扰拦截", "手机体检", "隐私空间", "手机杀毒", "节电管理", "手机管家", "隐私行为监控" },
			{ "流量监控", "通讯录备份", "手机防盗", "安全市场", "恶意广告拦截", "安全二维码", "应用工具" } };

	/**
	 * 获取GridView的数据源
	 * 
	 * @param num
	 *            只能取值0或者1
	 * @return
	 */
	public static List<MainGridViewItem> getList(int num) {
		if (num < 0 || num > 1) {
			return null;
		}
		List<MainGridViewItem> list1 = new ArrayList<MainGridViewItem>();
		String[] itemNames = itemName[num];
		int[] imageIds = mImageIds[num];
		for (int i = 0; i < itemNames.length; i++) {
			MainGridViewItem bean = new MainGridViewItem();
			bean.setName(itemNames[i]);
			bean.setImgId(imageIds[i]);
			list1.add(bean);
		}
		return list1;
	}
}
