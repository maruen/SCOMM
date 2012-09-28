package br.com.supportcomm.virtualgoods.services.controller;
 
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import br.com.supportcomm.virtualgoodscore.constantes.MessageStatus;
import br.com.supportcomm.virtualgoodscore.constantes.StatusType;
import br.com.supportcomm.virtualgoodscore.constantes.TransactionStatus;
import br.com.supportcomm.virtualgoodscore.dao.OptionInDAO;
import br.com.supportcomm.virtualgoodscore.dao.HistoricoDAO;
import br.com.supportcomm.virtualgoodscore.dao.TransacaoDAO;
import br.com.supportcomm.virtualgoodscore.pojo.Campanha;
import br.com.supportcomm.virtualgoodscore.pojo.OptionIn;
import br.com.supportcomm.virtualgoodscore.pojo.Historico;
import br.com.supportcomm.virtualgoodscore.pojo.Transacao;

public class ProcessTransactionController extends AbstractController {

	private TransacaoDAO 		transacaoDAO;
	private HistoricoDAO 		historicoDAO;
	private OptionInDAO			optionInDAO;
	
	private final String PARAM_MSISDN 		= "msisdn";
	private final String PARAM_MSG			= "message";
	private final String PARAM_ID_MSG 		= "mid";
	private final String PARAM_LA 			= "sc";
	private final String PARAM_OPERADORA 	= "operator";

	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		List<Transacao> list = transacaoDAO.findByScheduleAndStatus(new Date(),
																		TransactionStatus.WAITING_TO_PROCESS,
																		TransactionStatus.ASK_PARTNER_AUTHORIZATION);
		
		logger.info("Start ProcessTransactionController: " + list.size() + " records processed");
		
		for (Transacao tr : list) {
			
			tr.setTransactionStatus(TransactionStatus.PROCESS_TRANSACTION);
			transacaoDAO.update(tr);
			insertToMsgHist(tr,null, StatusType.PROCESS_TRANSACTION, MessageStatus.PROCESS_TRANSACTION);
			
			Campanha campaign = tr.getCampanha();
			switch (campaign.getFlowType()) {
			
				case Campanha.REQUIRES_AUTHORIZATION_FLOW:
					askPartnerAuthorization(tr);
					break;
					
				case Campanha.VOUCHER_FLOW:
					handleOptionIn(tr);
					break;
			}
		} 

		logger.info("Finish ProcessTransactionController ");
		return null;
	}

	private void askPartnerAuthorization(Transacao tr) {
		
		Integer numberOfRetries = getNumberOfRetries(tr);
		if (numberOfRetries >= tr.getParceiro().getRetentativa() ) {
			return;
		}
		
		PostMethod method = null;
	
		try {
			
			HttpClient client = new HttpClient();
			method = new PostMethod(tr.getCampanha().getUrlPedido());

			method.addParameter(PARAM_MSISDN, 		tr.getMsisdn());
			method.addParameter(PARAM_MSG, 			tr.getMensagem().getMensagem());
			method.addParameter(PARAM_ID_MSG, 		new Long(tr.getMensagem().getId()).toString());
			method.addParameter(PARAM_LA, 			tr.getLa().getNome());
			method.addParameter(PARAM_OPERADORA,	new Integer(tr.getOperadora()).toString());
			
			client.executeMethod(method);
			if (method.getStatusCode() == HttpStatus.SC_OK) {
				
				String httpStatus = method.getStatusText();
				logger.info(httpStatus);
				
				tr.setTransactionStatus(TransactionStatus.WAIT_PARTNER_AUTHORIZATION);
				transacaoDAO.update(tr);
			
				insertToMsgHist(tr,httpStatus, StatusType.ASK_PARTNER_AUTHORIZATION, MessageStatus.ASK_PARTNER_AUTHORIZATION_SENT);
				
			} else {
				
				String httpStatus =  method.getStatusText();
				logger.info(httpStatus);
				
				tr.setTransactionStatus(TransactionStatus.ASK_PARTNER_AUTHORIZATION);
				transacaoDAO.update(tr);
				
				insertToMsgHist(tr,httpStatus, StatusType.ASK_PARTNER_AUTHORIZATION, MessageStatus.ASK_PARTNER_AUTHORIZATION_NOT_SENT);
			}
			

		} catch (Exception e) {
		
			logger.error("Error: " + e.getMessage());
			Date dt = new Date(tr.getDtSchedule().getTime() + tr.getParceiro().getTimeSchedule() * 60 * 1000);
			tr.setTransactionStatus(TransactionStatus.ASK_PARTNER_AUTHORIZATION);
			tr.setDtSchedule(dt);
			transacaoDAO.update(tr);
			insertToMsgHist(tr,e.getMessage(), StatusType.ASK_PARTNER_AUTHORIZATION, MessageStatus.ASK_PARTNER_AUTHORIZATION_NOT_SENT);
		
		} finally {
			method.releaseConnection();
		}
		
	}
	
	private void handleOptionIn(Transacao tr) {
		
		OptionIn optionIn = new OptionIn();
		optionIn.setMsgOptionInSent(0);
		optionIn.setMsisdn(tr.getMsisdn());
		optionIn.setValorCompra(tr.getValorTarifacao());
		optionIn.setIdTransacao(tr.getId());
		optionIn.setCodigoOperadora(tr.getOperadora());
		optionIn.setDtCompra(Calendar.getInstance().getTime());
		optionIn.setIdCampanha(tr.getCampanha().getId());
		optionIn.setIsAuthorized(0);
		optionInDAO.save(optionIn);

		tr.setTransactionStatus(TransactionStatus.WAIT_OPTION_IN_ANSWER);
		transacaoDAO.update(tr);
		insertToMsgHist(tr, null, StatusType.WAIT_OPTION_IN_ANSWER, MessageStatus.WAITING_OPTION_IN_ANSWER);
	
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
		
		List<Historico> list = historicoDAO.findByStatusType(tr.getMensagem(), StatusType.ASK_PARTNER_AUTHORIZATION);
		return list.size(); 
		
	}
	
	private String getURL(Transacao tr) {
		
		
		String url = tr.getCampanha().getUrlPedido() 										+ "?" + 
				PARAM_MSISDN 		+ "=" + tr.getMsisdn() 									+ "&" + 
				PARAM_MSG		 	+ "=" + tr.getMensagem().getMensagem() 					+ "&" +
				PARAM_ID_MSG 		+ "=" + new Long(tr.getMensagem().getId()).toString() 	+ "&" +
				PARAM_LA 			+ "=" + tr.getLa().getNome() 							+ "&" +
				PARAM_OPERADORA 	+ "=" + new Integer(tr.getOperadora()).toString();
		return url;
	
	}
	

	public void setTransacaoDAO(TransacaoDAO transacaoDAO) {
		this.transacaoDAO = transacaoDAO;
	}

	public void setHistoricoDAO(HistoricoDAO historicoDAO) {
		this.historicoDAO = historicoDAO;
	}
	
	public void setOptionInDAO(OptionInDAO optionInDAO) {
		this.optionInDAO = optionInDAO;
	}
}
