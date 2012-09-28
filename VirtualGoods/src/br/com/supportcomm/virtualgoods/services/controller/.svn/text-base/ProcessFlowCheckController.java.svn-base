package br.com.supportcomm.virtualgoods.services.controller;
 
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import br.com.supportcomm.virtualgoodscore.constantes.MessageStatus;
import br.com.supportcomm.virtualgoodscore.constantes.StatusType;
import br.com.supportcomm.virtualgoodscore.constantes.TransactionStatus;
import br.com.supportcomm.virtualgoodscore.dao.HistoricoDAO;
import br.com.supportcomm.virtualgoodscore.dao.TransacaoDAO;
import br.com.supportcomm.virtualgoodscore.pojo.Campanha;
import br.com.supportcomm.virtualgoodscore.pojo.Historico;
import br.com.supportcomm.virtualgoodscore.pojo.Transacao;

public class ProcessFlowCheckController extends AbstractController {

	private TransacaoDAO 		transacaoDAO;
	private HistoricoDAO 		historicoDAO;

	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		List<Transacao> list = transacaoDAO.getAllNotFinished();
		logger.info("Start ProcessFlowCheckController: " + list.size() + " records processed");
		
		for (Transacao tr : list) {
			

			Campanha campaign = tr.getCampanha();
			switch (campaign.getFlowType()) {
			
				case Campanha.SIMPLIFIED_FLOW:
					checkSimplifiedFlow(tr);
					break;
			
				case Campanha.REQUIRES_AUTHORIZATION_FLOW:
					checkRequiresAuthorizationFlow(tr);
					break;
					
				case Campanha.VOUCHER_FLOW:
					checkVoucherFlow(tr);
					break;
			}

		} 

		logger.info("Finish ProcessFlowCheckController ");
		return null;
	}


	@SuppressWarnings("unchecked")
	private void checkSimplifiedFlow(Transacao tr) {
		
		List<Historico> list1,list2,list3;
		
		list1 = historicoDAO.findByStatusTypeAndMessageStatus( tr.getMensagem(),
															   StatusType.PROCESS_BILLING,
															   MessageStatus.BILLING_SUCCESS);
		
		list2 = historicoDAO.findByStatusTypeAndMessageStatus( tr.getMensagem(),
															   StatusType.PROCESS_TRANSACTION_RESPONSE,
															   MessageStatus.TRANSACTION_RESPONSE_SENT);
		
		list3 = historicoDAO.findByStatusTypeAndMessageStatus( tr.getMensagem(),
				   											   StatusType.SEND_MT_MESSAGE,
				   											   MessageStatus.MT_SENT);
		
		
		if (checkLists(list1,list2,list3)) {
			
			tr.setTransactionStatus(TransactionStatus.TRANSACTION_FINISHED);
			transacaoDAO.update(tr);
			
			Long totalTime = historicoDAO.getFlowTotalTime(tr.getMensagem().getId());
			insertToMsgHist(tr, totalTime.toString(), StatusType.FLOW_END, MessageStatus.FLOW_END);
		}
	
	}
	
	
	@SuppressWarnings("unchecked")
	private void checkRequiresAuthorizationFlow(Transacao tr) {
		
		List<Historico> list1,list2,list3,list4,list5;
		

		list1 = historicoDAO.findByStatusTypeAndMessageStatus( tr.getMensagem(),
				   											   StatusType.ASK_PARTNER_AUTHORIZATION,
				   											   MessageStatus.ASK_PARTNER_AUTHORIZATION_SENT);
		
		list2 = historicoDAO.findByStatusTypeAndMessageStatus( tr.getMensagem(),
				   											   StatusType.WAIT_PARTNER_AUTHORIZATION,
				   											   MessageStatus.TRANSACTION_AUTHORIZED);
		
		list3 = historicoDAO.findByStatusTypeAndMessageStatus( tr.getMensagem(),
															   StatusType.PROCESS_BILLING,
															   MessageStatus.BILLING_SUCCESS);
		
		list4 = historicoDAO.findByStatusTypeAndMessageStatus( tr.getMensagem(),
															   StatusType.PROCESS_TRANSACTION_RESPONSE,
															   MessageStatus.TRANSACTION_RESPONSE_SENT);
		
		list5 = historicoDAO.findByStatusTypeAndMessageStatus( tr.getMensagem(),
				   											   StatusType.SEND_MT_MESSAGE,
				   											   MessageStatus.MT_SENT);
		
		if (checkLists(list1,list2,list3,list4,list5)) {
			
			tr.setTransactionStatus(TransactionStatus.TRANSACTION_FINISHED);
			transacaoDAO.update(tr);
			
			Long totalTime = historicoDAO.getFlowTotalTime(tr.getMensagem().getId());
			insertToMsgHist(tr, totalTime.toString(), StatusType.FLOW_END, MessageStatus.FLOW_END);
		
		}
	
	}
	
	@SuppressWarnings("unchecked")
	private void checkVoucherFlow(Transacao tr) {
		
		List<Historico> list1,list2,list3,list4,list5,list6;
		
		
		list1 = historicoDAO.findByStatusTypeAndMessageStatus( tr.getMensagem(),
															   StatusType.SEND_OPTION_IN,
															   MessageStatus.OPTION_IN_SENT);
		
		list2 = historicoDAO.findByStatusTypeAndMessageStatus( tr.getMensagem(),
				   												StatusType.WAIT_OPTION_IN_ANSWER,
				   												MessageStatus.TRANSACTION_AUTHORIZED);
		
		list3 = historicoDAO.findByStatusTypeAndMessageStatus( tr.getMensagem(),
				   											   StatusType.PROCESS_BILLING,
				   											   MessageStatus.BILLING_SUCCESS);
		
		list4 = historicoDAO.findByStatusTypeAndMessageStatus( tr.getMensagem(),
				   											   StatusType.GENERATE_VOUCHER,
				   											   MessageStatus.VOUCHER_GENERATED);

		list5 = historicoDAO.findByStatusTypeAndMessageStatus( tr.getMensagem(),
				   											   StatusType.SEND_MT_MESSAGE,
				   											   MessageStatus.MT_SENT);
		
		list6 = historicoDAO.findByStatusTypeAndMessageStatus( tr.getMensagem(),
				   											   StatusType.SEND_VOUCHER,
				   											   MessageStatus.VOUCHER_SENT);
		
		
		if (checkLists(list1,list2,list3,list4,list5,list6)) {
			
			tr.setTransactionStatus(TransactionStatus.TRANSACTION_FINISHED);
			transacaoDAO.update(tr);
			
			Long totalTime = historicoDAO.getFlowTotalTime(tr.getMensagem().getId());
			insertToMsgHist(tr, totalTime.toString(), StatusType.FLOW_END, MessageStatus.FLOW_END);
			
		}
	}
	
	public boolean checkLists(List<Historico>... list) {
		boolean check = true;
		
		for (int i=0 ; i < list.length ; i++) {
			if (list == null || list[i].size() == 0) {
				check = false;
			}
		}
	
		return check;
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
		hist.setUrl(null);
		historicoDAO.save(hist);
	}
	
	
	public void setTransacaoDAO(TransacaoDAO transacaoDAO) {
		this.transacaoDAO = transacaoDAO;
	}

	public void setHistoricoDAO(HistoricoDAO historicoDAO) {
		this.historicoDAO = historicoDAO;
	}
	

}
