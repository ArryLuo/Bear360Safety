package com.bear.safety.data;

import java.util.ArrayList;
import java.util.List;

import com.bear.safety.R;
import com.bear.safety.model.MainGridViewItem;

public class MainDataSet {

	// ������������ ��ͼƬԴ main1
	public static int[][] mImageIds = { { R.drawable.disk_sysclear_alert,// �ֻ�����
			R.drawable.disk_phone_block,// ɧ������
			R.drawable.disk_phone_exam_default,// �ֻ����
			R.drawable.disk_privacy_protection,// ��˽�ռ�
			R.drawable.disk_anti_scan,// �ֻ�ɱ��
			R.drawable.disk_power_manager,// �ڵ����
			R.drawable.disk_program_manager,// �ֻ��ܼ�
			R.drawable.disk_active_defense,// ��˽��Ϊ���

	}, { R.drawable.disk_flow_traffic,// �������
			R.drawable.disk_secure_bak,// ͨѶ¼����
			R.drawable.disk_phone_anti_open,// �ֻ�����
			R.drawable.disk_app_market,// ��ȫ�г�
			R.drawable.disk_advertise_block,// ����������
			R.drawable.qr_code,// ��ȫ��ά��
			R.drawable.disk_use_tools,// Ӧ�ù���
	} };
	// ������1GridViewItem��
	public static String[][] itemName = {
			{ "�ֻ�����", "ɧ������", "�ֻ����", "��˽�ռ�", "�ֻ�ɱ��", "�ڵ����", "�ֻ��ܼ�", "��˽��Ϊ���" },
			{ "�������", "ͨѶ¼����", "�ֻ�����", "��ȫ�г�", "����������", "��ȫ��ά��", "Ӧ�ù���" } };

	/**
	 * ��ȡGridView������Դ
	 * 
	 * @param num
	 *            ֻ��ȡֵ0����1
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
