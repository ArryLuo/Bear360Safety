package com.bear.safety.util;

import java.util.Timer;
import java.util.TimerTask;

import com.bear.safety.util.itf.TimerTaskDelayable;

/**
 * 延时执行任务工具类
 * 
 * @author bear
 *
 */
public class TimerTaskUtil {
	
	private TimerTaskDelayable ttd; //延时执行任务接口对象
	private long delay; //延时时间，单位毫秒
	
	public TimerTaskUtil(TimerTaskDelayable taskDelayable, long delayedMills){
		this.ttd = taskDelayable;
		this.delay = delayedMills;
	}
	
	/**
	 * 延时计划方法 
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
