package br.com.supportcomm.virtualgoods.services.controller;

import java.io.PrintWriter;
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
import br.com.supportcomm.virtualgoodscore.pojo.Historico;
import br.com.supportcomm.virtualgoodscore.pojo.Transacao;

public class AuthorizeBillingController extends AbstractController {
		
	private static final String PARAM_MSISDN 			= "msisdn";
	private static final String PARAM_MENSAGEM_ID 	= "mid";
	//private static final String PARAM_MSG 			= "message";
	
	private static final String RESPOSTA = "RX_OK mid=";
	
	private HistoricoDAO historicoDAO;
	private TransacaoDAO transacaoDAO;

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		PrintWriter out = response.getWriter();
		
		String idMsg 	= request.getParameter(PARAM_MENSAGEM_ID);
		String msisdn 	= request.getParameter(PARAM_MSISDN);
	
		
		Transacao t = null;
		try {
 
			if (idMsg == null || idMsg.isEmpty() || msisdn == null	|| msisdn.isEmpty()) {
				return null;
			}
			
			t = transacaoDAO.findByMensagem(new Long(idMsg));
			

			if(t == null) {
				return null;
			}
			
			List<Historico> histList = historicoDAO.findByStatusType(t.getMensagem(), StatusType.ASK_PARTNER_AUTHORIZATION);				
			

			if(histList != null && histList.size() == 0) {
				return null;
			}	
 
			if(t.getTransactionStatus() != TransactionStatus.WAIT_PARTNER_AUTHORIZATION) {
				return null;
			}
			

			if(!t.getMsisdn().equalsIgnoreCase(msisdn)) {
				return null;
			}
			

			Historico hist = new Historico();
			hist.setDtCriacao(new Date());
			hist.setLa(t.getLa());
			hist.setMensagem(t.getMensagem());
			hist.setMsisdn(msisdn);
			hist.setOperadora(t.getOperadora());
			hist.setParceiro(t.getParceiro());
			hist.setStatusType(StatusType.WAIT_PARTNER_AUTHORIZATION);
			hist.setMessageStatus(MessageStatus.TRANSACTION_AUTHORIZED);
			t.setTransactionStatus(TransactionStatus.TRANSACTION_AUTHORIZED);
			hist.setTxMensagem("Autorização Rebebida do Host: " + request.getRemoteHost()  );
			
			historicoDAO.save(hist);
			transacaoDAO.update(t);
			
			out.println(RESPOSTA.concat(new Long(t.getMensagem().getId()).toString()));
			return null;
		} catch (Exception e) {				
		}
		return null;
	}

	public void setHistoricoDAO(HistoricoDAO historicoDAO) {
		this.historicoDAO = historicoDAO;
	}

	public void setTransacaoDAO(TransacaoDAO transacaoDAO) {
		this.transacaoDAO = transacaoDAO;
	}
}
