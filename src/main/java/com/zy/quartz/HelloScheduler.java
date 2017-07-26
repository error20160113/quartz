package com.zy.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class HelloScheduler {

	public static void main(String[] args) throws SchedulerException, InterruptedException {
		// 打印当前的时间，格式为2017-01-01 00:00:00
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("Current Time Is : " + sf.format(date));
		
		// 创建一个JobDetail实例，将该实例与HelloJob Class绑定
		JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("myJob")
				.usingJobData("message", "hello myjob").usingJobData("floatJobValue", 3.14)
				.build();
//		System.out.println("jobDetail's name : "+jobDetail.getKey().getName());
//		System.out.println("jobDetail's group : "+jobDetail.getKey().getGroup());
//		System.out.println("jobDetail's jobclass: "+jobDetail.getJobClass().getName());
		
		CronTrigger trigger = (CronTrigger) TriggerBuilder
				.newTrigger()
				.withIdentity("myTrigger", "group1")
				.withSchedule(
						CronScheduleBuilder.cronSchedule("* * * * * ?"))
				.build();
		// 创建Scheduler实例
		SchedulerFactory sfact = new StdSchedulerFactory();
		Scheduler scheduler = sfact.getScheduler();
		scheduler.start();
		
		scheduler.scheduleJob(jobDetail, trigger);

	}

}
