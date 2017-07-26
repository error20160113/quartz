package com.zy.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.TriggerKey;

public class HelloJob implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// 打印当前的执行时间，格式为2017-01-01 00:00:00
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("Current Exec Time Is : " + sf.format(date));
		System.out.println("Hello World");
		//获取
//		JobKey jKey=context.getJobDetail().getKey();
//		System.out.println("job:"+jKey.getName()+"**"+jKey.getGroup());
//		
//		TriggerKey tKey= context.getTrigger().getKey();
//		System.out.println("trigger:"+tKey.getName()+"**"+tKey.getGroup());
//		
//		JobDataMap jobDataMap=context.getJobDetail().getJobDataMap();
//		JobDataMap tJobDataMap = context.getTrigger().getJobDataMap();
//		System.out.println(jobDataMap.get("message"));
//		System.out.println(jobDataMap.get("floatJobValue"));
//		System.out.println(tJobDataMap.get("message"));
//		System.out.println(tJobDataMap.get("doubleValue"));
		
		
	}
	

}
