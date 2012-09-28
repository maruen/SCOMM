package br.com.supportcomm.virtualgoods.listener;

import static org.quartz.DateBuilder.futureDate;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.quartz.DateBuilder.IntervalUnit;
import org.quartz.JobDetail;
import org.quartz.ObjectAlreadyExistsException;
import org.quartz.Scheduler;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import br.com.supportcomm.virtualgoods.job.MTJob;
import br.com.supportcomm.virtualgoods.job.ProcessBillingJob;
import br.com.supportcomm.virtualgoods.job.ProcessFlowCheckJob;
import br.com.supportcomm.virtualgoods.job.ProcessTransactionJob;
import br.com.supportcomm.virtualgoods.job.ProcessTransactionResponseJob;
import br.com.supportcomm.virtualgoods.properties.BeanProperties;

public class VGScheduler implements ServletContextListener {

	public static Scheduler 		sched;
	public static final String 	VIRTUAL_GOODS_URL = "virtualGoodsUrl";
	private BeanProperties 			properties;

	public VGScheduler() {}

	@SuppressWarnings("static-access")
	protected void init() throws ObjectAlreadyExistsException {

		try {
			
			
			StdSchedulerFactory schedFactory = new StdSchedulerFactory();
			VGScheduler.sched = schedFactory.getScheduler();
			
			JobDetail processTransactionJob 		= newJob(ProcessTransactionJob.class)
															.withIdentity("processTransaction",sched.DEFAULT_GROUP)
															.build();
			
			JobDetail processBillingJob 			= newJob(ProcessBillingJob.class)
															.withIdentity("processBilling",sched.DEFAULT_GROUP)
															.build();
			
			
			JobDetail processTransactionResponseJob = newJob(ProcessTransactionResponseJob.class)
															.withIdentity("processTransactionResponse",sched.DEFAULT_GROUP)
															.build();
			
			JobDetail processMTJob					= newJob(MTJob.class)
															.withIdentity("processMTJob",sched.DEFAULT_GROUP)
															.build();
			
			JobDetail processFlowCheckJob			= newJob(ProcessFlowCheckJob.class)
															.withIdentity("processFlowCheckJob",sched.DEFAULT_GROUP)
															.build();
			
			processTransactionJob.getJobDataMap().put(VIRTUAL_GOODS_URL, properties.getVirtualGoodsUrl());
			processBillingJob.getJobDataMap().put(VIRTUAL_GOODS_URL, properties.getVirtualGoodsUrl());
			processTransactionResponseJob.getJobDataMap().put(VIRTUAL_GOODS_URL, properties.getVirtualGoodsUrl());
			processMTJob.getJobDataMap().put(VIRTUAL_GOODS_URL, properties.getVirtualGoodsUrl());
			processFlowCheckJob.getJobDataMap().put(VIRTUAL_GOODS_URL, properties.getVirtualGoodsUrl());
			
			
			Integer processTransactionInterval 			=	Integer.parseInt(properties.getProcessTransactionInterval());
			Integer processBilingInterval				= 	Integer.parseInt(properties.getProcessBillingInterval());
			Integer processTransactionResponseInterval	= 	Integer.parseInt(properties.getProcessTransactionResponseInterval());
			Integer processMTInterval					= 	Integer.parseInt(properties.getProcessMTInterval());
			Integer processFlowCheckInterval			= 	Integer.parseInt(properties.getProcessFlowCheckInterval());
			

			 SimpleTrigger processTransactionTrigger = newTrigger()
			            .withIdentity("processTransactionTrigger", sched.DEFAULT_GROUP)
			            .startAt(futureDate(1, IntervalUnit.MINUTE))
			            .withSchedule(simpleSchedule()
			                    .withIntervalInSeconds(processTransactionInterval)
			                    .repeatForever())
			            .build();
			
			
			 SimpleTrigger processBillingTrigger = newTrigger()
			            .withIdentity("processBillingTrigger", sched.DEFAULT_GROUP)
			            .startAt(futureDate(1, IntervalUnit.MINUTE))
			            .withSchedule(simpleSchedule()
			                    .withIntervalInSeconds(processBilingInterval)
			                    .repeatForever())
			            .build();
			 
			 
			 SimpleTrigger processTransactionResponseTrigger = newTrigger()
			            .withIdentity("processTransactionResponseTrigger", sched.DEFAULT_GROUP)
			            .startAt(futureDate(1, IntervalUnit.MINUTE))
			            .withSchedule(simpleSchedule()
			                    .withIntervalInSeconds(processTransactionResponseInterval)
			                    .repeatForever())
			            .build();
			 
			 SimpleTrigger processMTTrigger = newTrigger()
			            .withIdentity("processMTTrigger", sched.DEFAULT_GROUP)
			            .startAt(futureDate(1, IntervalUnit.MINUTE))
			            .withSchedule(simpleSchedule()
			                    .withIntervalInSeconds(processMTInterval)
			                    .repeatForever())
			            .build();
			
			 SimpleTrigger processFlowCheckTrigger = newTrigger()
			            .withIdentity("processFlowCheckTrigger", sched.DEFAULT_GROUP)
			            .startAt(futureDate(1, IntervalUnit.MINUTE))
			            .withSchedule(simpleSchedule()
			                    .withIntervalInSeconds(processFlowCheckInterval)
			                    .repeatForever())
			            .build();
																		  		  
		  sched.scheduleJob(processTransactionJob, processTransactionTrigger);
		  sched.scheduleJob(processBillingJob, processBillingTrigger);
		  sched.scheduleJob(processTransactionResponseJob, processTransactionResponseTrigger);
		  sched.scheduleJob(processMTJob,processMTTrigger);
		  sched.scheduleJob(processFlowCheckJob,processFlowCheckTrigger);
		  
		  VGScheduler.sched.start();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void contextInitialized(ServletContextEvent ce) {
		try {
			ApplicationContext ctx 	=  WebApplicationContextUtils.getWebApplicationContext(ce.getServletContext());
			properties 	= (BeanProperties) ctx.getBean("beanProperties");

			if(this.properties.getVirtualGoodsUrl() == null) {
				this.properties.setVirtualGoodsUrl(ce.getServletContext().getContextPath());
			}
			
			if (this.properties.getExecuteJobsFromThisMachine() != null && 
				this.properties.getExecuteJobsFromThisMachine().equalsIgnoreCase("TRUE")) {
				init();
			}
			
		} catch (Exception ex) {
			ex.getStackTrace();
		}
	}

	public void contextDestroyed(ServletContextEvent arg0) {
		restart();
	}

	public void restart() {
		try {
			if (VGScheduler.sched != null) {
				VGScheduler.sched.shutdown(true);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
