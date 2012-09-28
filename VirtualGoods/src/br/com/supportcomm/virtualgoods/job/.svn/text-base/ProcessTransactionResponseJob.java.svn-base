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

@DisallowConcurrentExecution
public class ProcessTransactionResponseJob implements Job {
	
	private final String PROCESS_TRANSACTION_RESPONSE_URL = "/services/processTransactionResponse";
	private static Logger 	 log  = LoggerFactory.getLogger(ProcessTransactionResponseJob.class);
	
	@Override
	public void execute(JobExecutionContext job) throws JobExecutionException {
		
		log.debug("Executing ProcessTransactionResponseJob");
		
		String url 			= (String) job.getJobDetail().getJobDataMap().get(VGScheduler.VIRTUAL_GOODS_URL) + PROCESS_TRANSACTION_RESPONSE_URL;
		HttpClient client 	= new HttpClient();
		GetMethod method	= new GetMethod(url);
	
		try {
			client.executeMethod(method);
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			method.releaseConnection();
		}
		
	}	
}
