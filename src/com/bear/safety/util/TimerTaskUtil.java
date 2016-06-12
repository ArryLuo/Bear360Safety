package com.bear.safety.util;

import java.util.Timer;
import java.util.TimerTask;

import com.bear.safety.util.itf.TimerTaskDelayable;

/**
 * ��ʱִ�����񹤾���
 * 
 * @author bear
 *
 */
public class TimerTaskUtil {
	
	private TimerTaskDelayable ttd; //��ʱִ������ӿڶ���
	private long delay; //��ʱʱ�䣬��λ����
	
	public TimerTaskUtil(TimerTaskDelayable taskDelayable, long delayedMills){
		this.ttd = taskDelayable;
		this.delay = delayedMills;
	}
	
	/**
	 * ��ʱ�ƻ����� 
	 */
	public void work(){
		Timer timer = new Timer();
		TimerTask tt = new TimerTask() {
			@Override
			public void run() {
				ttd.executeDelayedTask();
			}
		};
		timer.schedule(tt, delay);
	}
}
