package br.com.supportcomm.virtualgoods.properties;


public class BeanProperties {

	private String virtualGoodsUrl;
	private String processTransactionInterval;
	private String processBillingInterval;
	private String processTransactionResponseInterval;
	private String processMTInterval;
	private String processFlowCheckInterval;
	private String executeJobsFromThisMachine;
	
	public String getVirtualGoodsUrl() {
		return virtualGoodsUrl;
	}
	public void setVirtualGoodsUrl(String virtualGoodsUrl) {
		this.virtualGoodsUrl = virtualGoodsUrl;
	}
	public String getProcessTransactionInterval() {
		return processTransactionInterval;
	}
	public void setProcessTransactionInterval(String processTransactionInterval) {
		this.processTransactionInterval = processTransactionInterval;
	}
	public String getProcessBillingInterval() {
		return processBillingInterval;
	}
	public void setProcessBillingInterval(String processBillingInterval) {
		this.processBillingInterval = processBillingInterval;
	}
	public String getProcessTransactionResponseInterval() {
		return processTransactionResponseInterval;
	}
	public void setProcessTransactionResponseInterval(
			String processTransactionResponseInterval) {
		this.processTransactionResponseInterval = processTransactionResponseInterval;
	}
	public String getProcessMTInterval() {
		return processMTInterval;
	}
	public void setProcessMTInterval(String processMTInterval) {
		this.processMTInterval = processMTInterval;
	}
	public String getExecuteJobsFromThisMachine() {
		return executeJobsFromThisMachine;
	}
	public void setExecuteJobsFromThisMachine(String executeJobsFromThisMachine) {
		this.executeJobsFromThisMachine = executeJobsFromThisMachine;
	}
	public String getProcessFlowCheckInterval() {
		return processFlowCheckInterval;
	}
	public void setProcessFlowCheckInterval(String processFlowCheckInterval) {
		this.processFlowCheckInterval = processFlowCheckInterval;
	}
		
}
