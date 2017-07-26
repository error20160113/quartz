package com.zy.springquartz.quartz;

import org.springframework.stereotype.Component;

/**
 * 这个pojo是为了体验一下给jobDataMap传值
 * @author error
 *
 */
@Component("anotherBean")
public class AnotherBean {
	public void printAnotherMessage() {
		System.out.println("这是CronTrigger传的jobDataMap");
	}
}
