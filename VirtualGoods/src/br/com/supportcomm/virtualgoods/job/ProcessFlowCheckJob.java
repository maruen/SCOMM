package br.com.supportcomm.virtualgoods.job;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.supportcomm.virtualgoods.listener.VGScheduler;

/**
 * 
 * @author maruen.mehana
 *
 */

@DisallowConcurrentExecution
public class ProcessFlowCheckJob implements Job {
	
	private static String PROCESS_FLOW_CHECK_URL = "/services/processFlowCheck";
	private static Logger    log = LoggerFactory.getLogger(ProcessFlowCheckJob.class);
	
	@Override
	public void execute(JobExecutionContext jobContext) throws JobExecutionException {
		
		log.debug("Executing ProcessFlowCheckJob");
		
		String url 					= (String) jobContext.getJobDetail().getJobDataMap().get(VGScheduler.VIRTUAL_GOODS_URL) + PROCESS_FLOW_CHECK_URL;  
		HttpClient httpClient 		= new HttpClient();
		GetMethod method 			= new GetMethod(url);
		
		try {
	        httpClient.executeMethod(method);
        } catch (HttpException e) {
	        e.printStackTrace();
        } catch (IOException e) {
	        e.printStackTrace();
        } finally {
        	method.releaseConnection();
        }
	}

}
