package br.com.supportcomm.virtualgoods.services.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import br.com.supportcomm.virtualgoodscore.constantes.MessageStatus;
import br.com.supportcomm.virtualgoodscore.constantes.TransactionStatus;
import br.com.supportcomm.virtualgoodscore.constantes.StatusType;
import br.com.supportcomm.virtualgoodscore.dao.HistoricoDAO;
import br.com.supportcomm.virtualgoodscore.dao.TransacaoDAO;
import br.com.supportcomm.virtualgoodscore.pojo.Campanha;
import br.com.supportcomm.virtualgoodscore.pojo.Historico;
import br.com.supportcomm.virtualgoodscore.pojo.Transacao;


/**
 * 
 * @author maruen.mehana
 * @author fabio.galvao
 * 
 * Answers the Partner after billing process.
 *
 */

public class ProcessTransactionResponseController extends AbstractController {

	private TransacaoDAO 		transacaoDAO;
	private HistoricoDAO 		historicoDAO;
	private TransactionStatus  	oldStatus;
	
	private final String PARAM_MSISDN 		= "msisdn";
	private final String PARAM_STATUS	 	= "binfo";
	private final String PARAM_ID_MSG 		= "mid";
	private final String PARAM_MSG 		= "message";
	private final String PARAM_LA 			= "sc";
	private final String PARAM_OPERADORA 	= "operator";
	
	private String proxyServer;
	private String proxyPort;
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		
 
		List<Transacao> list = transacaoDAO.findByScheduleAndStatus(	new Date(), 
																		TransactionStatus.CHECK_CREDIT_FAILED,
																		TransactionStatus.BILLING_FAILED,
																		TransactionStatus.BILLING_SUCCESS,
																		TransactionStatus.TRANSACTION_RESPONSE_NOT_SENT
				);
		
		logger.info("Start ProcessTransactionResponseController....: " + list.size() + " records processed");
		
		for (Transacao tr : list) {
			
			Campanha campaign = tr.getCampanha();
			switch (campaign.getFlowType()) {
				
				case Campanha.SIMPLIFIED_FLOW:
					tr.setTransactionStatus(TransactionStatus.PROCESS_TRANSACTION_RESPONSE);
					transacaoDAO.update(tr);
					insertToMsgHist(tr,getURL(tr),StatusType.PROCESS_TRANSACTION_RESPONSE, MessageStatus.PROCESS_TRANSACTION_RESPONSE);
					sendTransactionResponse(tr);
					break;
					
				case Campanha.REQUIRES_AUTHORIZATION_FLOW:
					tr.setTransactionStatus(TransactionStatus.PROCESS_TRANSACTION_RESPONSE);
					transacaoDAO.update(tr);
					insertToMsgHist(tr,getURL(tr),StatusType.PROCESS_TRANSACTION_RESPONSE, MessageStatus.PROCESS_TRANSACTION_RESPONSE);
					sendTransactionResponse(tr);
					break;
					
				case Campanha.VOUCHER_FLOW:
					break;
			}
		
		
		}

		logger.info("Finish ProcessTransactionResponseController....: ");
		return null;
	}
	
	
	private void sendTransactionResponse(Transacao tr) {
		
		Integer numberOfRetries = getNumberOfRetries(tr);
		if (numberOfRetries >= tr.getParceiro().getRetentativa() ) {
			return;
		}
		
		HttpClient client = new HttpClient();
		String url2 = getURL(tr).replace(" ", "+");
		GetMethod method = new GetMethod(url2);

		try {
			
			logger.info(" Accessing URL: " + url2.toString());
			client.executeMethod(method);
			
			if (method.getStatusCode() == HttpStatus.SC_OK) {
			
				String httpStatus = method.getStatusText();
				logger.info(httpStatus);
				
				transacaoDAO.update(tr);
				insertToMsgHist(tr,httpStatus, StatusType.PROCESS_TRANSACTION_RESPONSE, MessageStatus.TRANSACTION_RESPONSE_SENT);
			
			} else { 
				
				String httpStatus = method.getStatusText();
				logger.info(httpStatus);
				tr.setTransactionStatus(TransactionStatus.TRANSACTION_RESPONSE_NOT_SENT);
	
				transacaoDAO.update(tr);
				insertToMsgHist(tr,httpStatus, StatusType.PROCESS_TRANSACTION_RESPONSE, MessageStatus.TRANSACTION_RESPONSE_NOT_SENT);
			
			}				
			
		} catch (Exception e) {
			
			logger.error("Error in connection: " + e.getMessage());
			Date dt = new Date(tr.getDtSchedule().getTime()+ tr.getParceiro().getTimeSchedule() * 60 * 1000);
			tr.setTransactionStatus(TransactionStatus.TRANSACTION_RESPONSE_NOT_SENT);
			tr.setDtSchedule(dt);
			
			transacaoDAO.update(tr);
			insertToMsgHist(tr,e.getMessage(), StatusType.PROCESS_TRANSACTION_RESPONSE, MessageStatus.TRANSACTION_RESPONSE_NOT_SENT);

		} finally {
			method.releaseConnection();
		}

	}
	
	private void insertToMsgHist(Transacao tr, String message, StatusType statusType, MessageStatus messageStatus) {
	
		Historico hist = new Historico();
		hist.setDtCriacao(new Date());
		hist.setLa(tr.getLa());
		hist.setMensagem(tr.getMensagem());
		hist.setTxMensagem(message);
		hist.setMsisdn(tr.getMsisdn());
		hist.setOperadora(tr.getOperadora());
		hist.setMessageStatus(messageStatus);
		hist.setStatusType(statusType);
		hist.setParceiro(tr.getParceiro());
		hist.setValorTarifacao(tr.getValorTarifacao());
		hist.setRetentativa(1);
		hist.setUrl(getURL(tr));
		historicoDAO.save(hist);
	}
			

	private Integer getNumberOfRetries(Transacao tr) {
		
		List<Historico> histList = historicoDAO.findByStatusTypeAndMessageStatus(tr.getMensagem(),
																				 StatusType.PROCESS_TRANSACTION_RESPONSE,
																				 MessageStatus.TRANSACTION_RESPONSE_NOT_SENT);
		return histList.size(); 
		
	}
	
	private String getURL(Transacao tr ) {
	
		String url = tr.getCampanha().getUrlConfirmStatus() 								+ "?" + 
				PARAM_MSISDN 	+ "=" 	+ tr.getMsisdn() 									+ "&" + 
				PARAM_MSG 		+ "=" 	+ tr.getMensagem().getMensagem() 					+ "&" +
				PARAM_ID_MSG 	+ "=" 	+ new Long(tr.getMensagem().getId()).toString() 	+ "&" +
				PARAM_LA 		+ "=" 	+ tr.getLa().getNome() 								+ "&" +
				PARAM_OPERADORA + "=" 	+ new Integer(tr.getOperadora()).toString() 		+ "&" +
				PARAM_STATUS 	+ "=" 	+ oldStatus;
		return url;
	
	}
	
	
	public void setTransacaoDAO(TransacaoDAO transacaoDAO) {
		this.transacaoDAO = transacaoDAO;
	}

	public void setHistoricoDAO(HistoricoDAO historicoDAO) {
		this.historicoDAO = historicoDAO;
	}

	public String getProxyServer() {
		return proxyServer;
	}

	public void setProxyServer(String proxyServer) {
		if(proxyServer != null && !proxyServer.isEmpty()) {
			this.proxyServer = proxyServer;
		}
	}

	public String getProxyPort() {
		return proxyPort;
	}

	public void setProxyPort(String proxyPort) {
		if(proxyPort != null && !proxyPort.isEmpty()) {
			this.proxyPort = proxyPort;
		}
	}

}
