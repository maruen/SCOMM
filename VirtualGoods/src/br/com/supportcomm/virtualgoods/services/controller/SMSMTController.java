package br.com.supportcomm.virtualgoods.services.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import br.com.supportcomm.virtualgoods.utilities.Utils;
import br.com.supportcomm.virtualgoodscore.constantes.MessageStatus;
import br.com.supportcomm.virtualgoodscore.constantes.StatusType;
import br.com.supportcomm.virtualgoodscore.constantes.TransactionStatus;
import br.com.supportcomm.virtualgoodscore.dao.BillingRecordFailureDAO;
import br.com.supportcomm.virtualgoodscore.dao.BillingRecordSuccessDAO;
import br.com.supportcomm.virtualgoodscore.dao.BuyConfigDAO;
import br.com.supportcomm.virtualgoodscore.dao.BuyingLimitExceedDAO;
import br.com.supportcomm.virtualgoodscore.dao.CampanhaDAO;
import br.com.supportcomm.virtualgoodscore.dao.ConfigDAO;
import br.com.supportcomm.virtualgoodscore.dao.OptionInDAO;
import br.com.supportcomm.virtualgoodscore.dao.DuplicatedMessageDAO;
import br.com.supportcomm.virtualgoodscore.dao.HistoricoDAO;
import br.com.supportcomm.virtualgoodscore.dao.MensagemRespostaDAO;
import br.com.supportcomm.virtualgoodscore.dao.TransacaoDAO;
import br.com.supportcomm.virtualgoodscore.dao.VoucherDAO;
import br.com.supportcomm.virtualgoodscore.dao.WithoutCampaignMsgDAO;
import br.com.supportcomm.virtualgoodscore.pojo.BillingRecordFailure;
import br.com.supportcomm.virtualgoodscore.pojo.BillingRecordSuccess;
import br.com.supportcomm.virtualgoodscore.pojo.BuyConfig;
import br.com.supportcomm.virtualgoodscore.pojo.BuyingLimitExceed;
import br.com.supportcomm.virtualgoodscore.pojo.Campanha;
import br.com.supportcomm.virtualgoodscore.pojo.OptionIn;
import br.com.supportcomm.virtualgoodscore.pojo.DuplicatedMessage;
import br.com.supportcomm.virtualgoodscore.pojo.Historico;
import br.com.supportcomm.virtualgoodscore.pojo.LA;
import br.com.supportcomm.virtualgoodscore.pojo.Mensagem;
import br.com.supportcomm.virtualgoodscore.pojo.MensagemResposta;
import br.com.supportcomm.virtualgoodscore.pojo.Transacao;
import br.com.supportcomm.virtualgoodscore.pojo.Voucher;
import br.com.supportcomm.virtualgoodscore.pojo.WithoutCampaignMsg;
import br.com.supportcomm.virtualgoodscore.util.mercuri.mt.MercuriConnection;
import br.com.supportcomm.virtualgoodscore.util.mercuri.mt.MercuriMTQuery;


public class SMSMTController extends AbstractController {

	private static final String PARAM_MT_MESSAGE 					= "message";
	private static final String PARAM_MESSAGE_ID 					= "mid";
	private static final String PARAM_FROM_JOB 					= "fromJob";
 
	private static final String SUCESSO 							= "1";
	private static final String ERRO_PARAMETROS 					= "2";
	private static final String ERRO_MENSAGEM_NAO_ENCONTRADA 		= "3";
	private static final String ERRO_MENSAGEM_ENVIADA 			= "4";
	private static final String ERRO_TRANSACAO_NAO_FINALIZADA 	= "5";
	private static final String ERRO_TAMANHO_MENSAGEM 			= "6";
	private static final String ERRO_DESCONHECIDO 				= "7";
	
	private static final String CONTENT_TYPE 						= "text/html";
	private static final String INVALID_COMMAND					= "invalid.command";
	private static final String DUPLICATED_MESSAGE				= "duplicated.check.message";
	
	private static final String FUNCTION_NAME 					= "mt/InterfaceMT";

	private MensagemRespostaDAO 		msgRespostaDAO;
	private HistoricoDAO 				historicoDAO;
	private TransacaoDAO 				transacaoDAO;
	private BillingRecordSuccessDAO		billingRecordSuccessDAO;
	private BillingRecordFailureDAO		billingRecordFailureDAO;
	private WithoutCampaignMsgDAO		withoutCampaignMsgDAO;
	private BuyingLimitExceedDAO		buyingLimitExceedDAO;
	private BuyConfigDAO				buyConfigDAO;
	private ConfigDAO					configDAO;
	private CampanhaDAO					campanhaDAO;
	private DuplicatedMessageDAO		duplicatedMessageDAO;
	private OptionInDAO					optionInDAO;
	private VoucherDAO					voucherDAO;

	private  MercuriConnection 			connection;
	private  String 					sizeTextMessage;
	
	private final String PARAM_MSISDN 		= "msisdn";
	private final String PARAM_MSG			= "message";
	private final String PARAM_ID_MSG 		= "mid";
	private final String PARAM_LA 			= "sc";
	private final String PARAM_OPERADORA 	= "operator";
	

	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("Send SMS MT Begin");
		String smsmt;
		
		String fromJobAsString	= request.getParameter(PARAM_FROM_JOB);
		boolean fromJob = (fromJobAsString != null) ?  true : false;
		
		if (fromJob) { 
			
			List<BillingRecordSuccess> listOfSuccess = billingRecordSuccessDAO.getRecordsToSendProtocol();

			for (BillingRecordSuccess record : listOfSuccess) {
				Transacao tr = transacaoDAO.findById(record.getIdTransacao());
				smsmt = tr.getCampanha().getMtSuccess();
				String protocol = Utils.getFormattedProtocol(record);
				smsmt = Utils.fomatMTMessage(smsmt,protocol);
				if(sendMessage(smsmt,tr.getLa(),tr.getMsisdn(),tr.getOperadora())) {
					insertToMsgResp(smsmt, tr.getMensagem(), MessageStatus.MT_SENT);
					insertToMsgHist(tr, smsmt, StatusType.SEND_MT_MESSAGE, MessageStatus.MT_SENT);
					record.setSentProtocol(1);
					billingRecordSuccessDAO.update(record);
					
				} else {
					insertToMsgHist(tr, smsmt, StatusType.SEND_MT_MESSAGE, MessageStatus.MT_NOT_SENT);
				}
			}

			List<BillingRecordFailure> listOfFailure = billingRecordFailureDAO.getRecordsToSendFailureMessage();
			for (BillingRecordFailure record : listOfFailure) {
				Transacao tr = transacaoDAO.findById(record.getIdTransacao());
				smsmt = tr.getCampanha().getMtFail();
				if(sendMessage(smsmt,tr.getLa(),tr.getMsisdn(),tr.getOperadora())) {
					insertToMsgResp(smsmt, tr.getMensagem(), MessageStatus.MT_SENT);
					insertToMsgHist(tr, smsmt, StatusType.SEND_MT_MESSAGE, MessageStatus.MT_SENT);
					record.setMsgFailureSent(1);
					billingRecordFailureDAO.update(record);
				} else {
					insertToMsgHist(tr, smsmt, StatusType.SEND_MT_MESSAGE, MessageStatus.MT_NOT_SENT);
				}
			}
			
			smsmt = configDAO.findByName(INVALID_COMMAND);
			List<WithoutCampaignMsg> litOfWithoutCampaign = withoutCampaignMsgDAO.getRocordsToSendMT();
			for (WithoutCampaignMsg record: litOfWithoutCampaign) {
				
				Mensagem msg = record.getMensagem();
				
				if (sendMessage(smsmt,msg.getLa(),msg.getMsisdn(),msg.getOperadora()) ) {
					insertToMsgResp(smsmt, msg, MessageStatus.MT_SENT);
					record.setSmsMtSent(1);
					withoutCampaignMsgDAO.update(record);
				}
			}

			List<BuyingLimitExceed> listOfBuyingExceed = buyingLimitExceedDAO.getRocordsToSendMT();
			for (BuyingLimitExceed record: listOfBuyingExceed) {
				Transacao tr = transacaoDAO.findById(record.getMensagem().getId());
				Mensagem msg = record.getMensagem();
				BuyConfig config = buyConfigDAO.findConfigByOperadora(msg.getOperadora());
				smsmt = config.getMsgLimiteExcedido();
				if (sendMessage(smsmt,msg.getLa(),msg.getMsisdn(),msg.getOperadora()) ) {
					insertToMsgResp(config.getMsgLimiteExcedido(), msg, MessageStatus.MT_SENT);
					insertToMsgHist(tr, smsmt, StatusType.SEND_MT_MESSAGE, MessageStatus.MT_SENT);
					record.setSmsMtSent(1);
					buyingLimitExceedDAO.update(record);
				}
			}
			
			List<DuplicatedMessage> listOfDuplicated = duplicatedMessageDAO.getRecordsToSendMT();
			smsmt = configDAO.findByName(DUPLICATED_MESSAGE);
			List<String> listOfUniqueMsisdns = new ArrayList<String>();
			for (DuplicatedMessage record : listOfDuplicated) {
				
				Mensagem msg = record.getMensagem();
				
				if ( listOfUniqueMsisdns.contains(record.getMsisdn())) {
					record.setSmsMtSent(1);
					duplicatedMessageDAO.update(record);
					continue;
				}
				
				if (sendMessage(smsmt,msg.getLa(),msg.getMsisdn(),msg.getOperadora())) {
					listOfUniqueMsisdns.add(msg.getMsisdn());
					insertToMsgResp(smsmt, msg, MessageStatus.MT_SENT);
					record.setSmsMtSent(1);
					duplicatedMessageDAO.update(record);
				}	
			}
			
			List<Voucher> listOfVoucher = voucherDAO.getRecordsToSendVoucher();
			for (Voucher record : listOfVoucher) {
				
				Transacao tr 			= 	transacaoDAO.findById(record.getIdTransacao()); 
				Campanha campaign 		= 	campanhaDAO.findById(tr.getCampanha().getId());
				smsmt 					= 	campaign.getMtVoucher();

				smsmt = Utils.fomatVoucherMessage	(smsmt,record.getVoucherCode());
				if (sendMessage(smsmt,tr.getLa(),tr.getMsisdn(),tr.getOperadora()) ) {
					
					insertToMsgResp(smsmt, tr.getMensagem(), MessageStatus.VOUCHER_SENT);
					insertToMsgHist(tr, smsmt, StatusType.SEND_VOUCHER, MessageStatus.VOUCHER_SENT);
					
					record.setVoucherMTSent(1);
					voucherDAO.update(record);
					
				} else {
					insertToMsgHist(tr, smsmt, StatusType.SEND_VOUCHER, MessageStatus.VOUCHER_NOT_SENT);
				}
			}
			
			List<OptionIn> listOfOptionIn = optionInDAO.getRecordsToSendOptionIn();
			for (OptionIn record : listOfOptionIn) {
				
				Transacao tr = transacaoDAO.findById(record.getIdTransacao()); 
				Campanha campaign = campanhaDAO.findById(record.getIdCampanha());
				smsmt = campaign.getMtOptionIn();
				
				if (sendMessage(smsmt,tr.getLa(),tr.getMsisdn(),tr.getOperadora()) ) {
					
					insertToMsgResp(smsmt, tr.getMensagem(), MessageStatus.MT_SENT);
					insertToMsgHist(tr, smsmt, StatusType.SEND_OPTION_IN, MessageStatus.OPTION_IN_SENT);
					record.setMsgOptionInSent(1);
					optionInDAO.update(record);
				} else {
					insertToMsgHist(tr, smsmt, StatusType.SEND_OPTION_IN, MessageStatus.OPTION_IN_NOT_SENT);
				}
			}
			
			
		} else {
			logger.info("Sending SMS MT partner message");
			messageFromPartner(request,response);
		}
		
		logger.info("Send SMS MT End");
		return null;
		
	}

	private void messageFromPartner(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		response.setContentType(CONTENT_TYPE);
	    PrintWriter out = response.getWriter();

		String idMsg 	= request.getParameter(PARAM_MESSAGE_ID);
		String smsmt 	= request.getParameter(PARAM_MT_MESSAGE);
		
		if(idMsg == null || idMsg.isEmpty() || smsmt == null || smsmt.isEmpty()) {
			out.println(ERRO_PARAMETROS);
		}

		Transacao tr = null;
		MensagemResposta msgResp = null; 
		
		try {
			tr = transacaoDAO.findByMensagem(new Long(idMsg));
			msgResp = msgRespostaDAO.findByMensagem(new Long(idMsg));
		} catch (Exception e){}

		if(tr == null) {
			out.println(ERRO_MENSAGEM_NAO_ENCONTRADA);
		}

		if(msgResp != null) {
			out.println(ERRO_MENSAGEM_ENVIADA);
		}	

		if(tr != null && tr.getTransactionStatus() != TransactionStatus.TRANSACTION_FINISHED) {
			out.println(ERRO_TRANSACAO_NAO_FINALIZADA);
		}
		
		if(smsmt.length() > Integer.parseInt(sizeTextMessage)) { 
			out.println(ERRO_TAMANHO_MENSAGEM);
		}
		
		if (sendMessage(smsmt,tr.getLa(),tr.getMsisdn(), tr.getOperadora())) {
			insertToMsgHist(tr,smsmt,StatusType.SEND_MT_MESSAGE, MessageStatus.MT_SENT);
			out.println(SUCESSO);
		} else {
			
			insertToMsgHist(tr,smsmt,StatusType.SEND_MT_MESSAGE, MessageStatus.MT_NOT_SENT);
			insertToMsgResp(smsmt,tr.getMensagem(),MessageStatus.MT_NOT_SENT);
			out.println(ERRO_DESCONHECIDO);
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
	
	private String getURL(Transacao tr) {
		
		
		String url = tr.getCampanha().getUrlPedido() 										+ "?" + 
				PARAM_MSISDN 		+ "=" + tr.getMsisdn() 									+ "&" + 
				PARAM_MSG		 	+ "=" + tr.getMensagem().getMensagem() 					+ "&" +
				PARAM_ID_MSG 		+ "=" + new Long(tr.getMensagem().getId()).toString() 	+ "&" +
				PARAM_LA 			+ "=" + tr.getLa().getNome() 							+ "&" +
				PARAM_OPERADORA 	+ "=" + new Integer(tr.getOperadora()).toString();
		return url;
	
	}

	private void insertToMsgResp(String message, Mensagem msg, MessageStatus messageStatus ) {
	    MensagemResposta answerMsg = new MensagemResposta();
	    answerMsg.setLa(msg.getLa());
	    answerMsg.setMensagem(message);
	    answerMsg.setMsg(msg);
	    answerMsg.setMsisdn(msg.getMsisdn());
	    answerMsg.setOperadora(msg.getOperadora());
	    answerMsg.setProcessamento(new Date());
	    answerMsg.setRequest(new Date());
	    answerMsg.setMessageStatus(messageStatus);
	    msgRespostaDAO.save(answerMsg);
    }
	
	public boolean sendMessage( String message,LA la,String msisdn,Integer carrier ) {
		boolean sent = false;

		MercuriMTQuery query = new MercuriMTQuery();
		connection.setUrl(la.getMercuriUrl());
		query.setConnection(connection);
		query.setItemId(String.valueOf(la.getMercuriItemId()));
		query.setOriginator(la.getNome());
		query.setPassword(la.getMercuriPassword());
		query.setServiceId(new Integer(la.getMercuriServiceId()).toString());
		query.setUser(la.getMercuriUsername());
		query.setFunctionName(FUNCTION_NAME);
		query.addParameter(MercuriMTQuery.DESTINATION, msisdn);
		query.addParameter(MercuriMTQuery.MERCURI_CARRIER_ID, String.valueOf(carrier));
		query.addParameter(MercuriMTQuery.TEXT, message);

		try {
			query.doQuery();
			sent = true;
		} catch (Exception e) {	}

		return sent;

	}


	public void setHistoricoDAO(HistoricoDAO historicoDAO) {
		this.historicoDAO = historicoDAO;
	}

	public void setTransacaoDAO(TransacaoDAO transacaoDAO) {
		this.transacaoDAO = transacaoDAO;
	}

	public void setMsgRespostaDAO(MensagemRespostaDAO msgRespostaDAO) {
		this.msgRespostaDAO = msgRespostaDAO;
	}

	public void setSizeTextMessage(String sizeTextMessage) {
		this.sizeTextMessage = sizeTextMessage;
	}

	public void setBillingRecordSuccessDAO(BillingRecordSuccessDAO billingRecordSuccessDAO) {
    	this.billingRecordSuccessDAO = billingRecordSuccessDAO;
    }

	public void setBillingRecordFailureDAO(BillingRecordFailureDAO billingRecordFailureDAO) {
    	this.billingRecordFailureDAO = billingRecordFailureDAO;
    }

	public void setBuyingLimitExceedDAO(BuyingLimitExceedDAO buyingLimitExceedDAO) {
    	this.buyingLimitExceedDAO = buyingLimitExceedDAO;
    }

	public void setBuyConfigDAO(BuyConfigDAO buyConfigDAO) {
    	this.buyConfigDAO = buyConfigDAO;
    }

	public void setConfigDAO(ConfigDAO configDAO) {
    	this.configDAO = configDAO;
    }

	public void setDuplicatedMessageDAO(DuplicatedMessageDAO duplicatedMessageDAO) {
    	this.duplicatedMessageDAO = duplicatedMessageDAO;
    }

	public void setWithoutCampaignMsgDAO(WithoutCampaignMsgDAO withoutCampaignMsgDAO) {
		this.withoutCampaignMsgDAO = withoutCampaignMsgDAO;
	}
	
	public void setConnection(MercuriConnection connection) {
		this.connection = connection;
	}

	public void setCampanhaDAO(CampanhaDAO campanhaDAO) {
		this.campanhaDAO = campanhaDAO;
	}

	public void setVoucherDAO(VoucherDAO voucherDAO) {
		this.voucherDAO = voucherDAO;
	}

	public void setOptionInDAO(OptionInDAO optionInDAO) {
		this.optionInDAO = optionInDAO;
	}
	
}
