package br.com.supportcomm.virtualgoods.services.controller;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.w3c.dom.Document;

import br.com.supportcomm.virtualgoods.smsmo.MORequest;
import br.com.supportcomm.virtualgoodscore.constantes.MessageStatus;
import br.com.supportcomm.virtualgoodscore.constantes.StatusType;
import br.com.supportcomm.virtualgoodscore.constantes.TransactionStatus;
import br.com.supportcomm.virtualgoodscore.dao.BillingRecordSuccessDAO;
import br.com.supportcomm.virtualgoodscore.dao.BuyConfigDAO;
import br.com.supportcomm.virtualgoodscore.dao.BuyingLimitExceedDAO;
import br.com.supportcomm.virtualgoodscore.dao.CampanhaDAO;
import br.com.supportcomm.virtualgoodscore.dao.ConfigDAO;
import br.com.supportcomm.virtualgoodscore.dao.OptionInDAO;
import br.com.supportcomm.virtualgoodscore.dao.DuplicatedMessageDAO;
import br.com.supportcomm.virtualgoodscore.dao.HistoricoDAO;
import br.com.supportcomm.virtualgoodscore.dao.KeycodeDAO;
import br.com.supportcomm.virtualgoodscore.dao.LADAO;
import br.com.supportcomm.virtualgoodscore.dao.LoggerMessageDAO;
import br.com.supportcomm.virtualgoodscore.dao.MensagemDAO;
import br.com.supportcomm.virtualgoodscore.dao.OperadoraDAO;
import br.com.supportcomm.virtualgoodscore.dao.TransacaoDAO;
import br.com.supportcomm.virtualgoodscore.dao.WithoutCampaignMsgDAO;
import br.com.supportcomm.virtualgoodscore.pojo.BuyConfig;
import br.com.supportcomm.virtualgoodscore.pojo.BuyingLimitExceed;
import br.com.supportcomm.virtualgoodscore.pojo.Campanha;
import br.com.supportcomm.virtualgoodscore.pojo.OptionIn;
import br.com.supportcomm.virtualgoodscore.pojo.DuplicatedMessage;
import br.com.supportcomm.virtualgoodscore.pojo.Historico;
import br.com.supportcomm.virtualgoodscore.pojo.Keycode;
import br.com.supportcomm.virtualgoodscore.pojo.LA;
import br.com.supportcomm.virtualgoodscore.pojo.Mensagem;
import br.com.supportcomm.virtualgoodscore.pojo.Regra;
import br.com.supportcomm.virtualgoodscore.pojo.Sharecode;
import br.com.supportcomm.virtualgoodscore.pojo.Transacao;
import br.com.supportcomm.virtualgoodscore.pojo.WithoutCampaignMsg;

/**
 * 
 * @author maruen.mehana
 * @author fabio.galvao
 *
 */
 
public class SMSMOController extends AbstractController {

	
	private MensagemDAO 				msgDAO;
	private HistoricoDAO 				historicoDAO;
	private LADAO 						laDAO;
	private KeycodeDAO 					keycodeDAO;
	private CampanhaDAO 				campanhaDAO;
	private TransacaoDAO 				transacaoDAO;
	private BuyConfigDAO				buyConfigDAO;
	private ConfigDAO				    configDAO;
	private BillingRecordSuccessDAO 	billingRecordSuccessDAO;
	private LoggerMessageDAO			loggerMessageDAO;
	private OperadoraDAO				operadoraDAO;
	private WithoutCampaignMsgDAO		withoutCampaignMsgDAO;
	private BuyingLimitExceedDAO		buyingLimitExceedDAO;
	private DuplicatedMessageDAO		duplicatedMessageDAO;
	private OptionInDAO					optionInDAO;
	
	private LA							la;
	private Keycode						keycode;
	private Regra						rule;
	private Campanha					campaign;
		
	private MORequest 					moRequest;
	private String 						delimiter = " ";
	
	private static final String DUPLICATED_CHECK_INTERVAL  	= 	"duplicated.check.interval";
	private static final String OPTION_IN_ANSWER			 	=	"option.in.answer";
	private static final String VOUCHER_AUTHORIZED			=	"voucher_authorized";
	private static final String VOUCHER_CANCELED				=	"voucher_canceled";
	
	private static SimpleDateFormat dateTimeFormat 	= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Date currentDate = new Date();
		
		try {
			moRequest = parseInputParameters(request);
			logger.info("MO Message: " + moRequest);
		} catch (Exception e) {
			logger.warn(loggerMessageDAO.getMessageById(5, e.getMessage()) );
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, loggerMessageDAO.getMessageById(6));
			return null;
		}

		String strLa = moRequest.getDestinationNumber();
		if(moRequest.getDestinationNumber().contains("-")) {
			strLa = moRequest.getDestinationNumber().substring(0, moRequest.getDestinationNumber().indexOf("-"));
		}
		
		la = laDAO.findByNome(strLa);
		if (la == null) {
			logger.warn(loggerMessageDAO.getMessageById(7, moRequest.getDestinationNumber()));
			response.sendError(HttpServletResponse.SC_BAD_REQUEST,loggerMessageDAO.getMessageById(7, moRequest.getDestinationNumber()));
			return null;
		}
		
		if (isOptionIn()) {
			return null;
		}

		Mensagem msg = new Mensagem();
		msg.setLa(la);
		msg.setMensagem(moRequest.getTextMessage());
		msg.setMsisdn(moRequest.getOriginationNumber());
		msg.setOperadora(Integer.parseInt(moRequest.getCarrier()));
		msg.setProcessamento(currentDate);
		msg.setRequest(currentDate);
		
		Historico hist = new Historico();
		hist.setDtCriacao(currentDate);
		hist.setLa(la);
		hist.setMensagem(msg);
		hist.setTxMensagem(msg.getMensagem());
		hist.setMsisdn(msg.getMsisdn());
		hist.setOperadora(msg.getOperadora());
		hist.setStatusType(StatusType.FLOW_START);

		boolean isDuplicate = isDuplicate(msg.getMsisdn());
		
		if ( isDuplicate ) {
			msg.setMessageStatus(MessageStatus.DUPLICATE);
			hist.setMessageStatus(MessageStatus.DUPLICATE);
		} else {
			msg.setMessageStatus(MessageStatus.FLOW_START);
			hist.setMessageStatus(MessageStatus.FLOW_START);
		}
		
		try {
			
			msgDAO.save(msg);
			historicoDAO.save(hist);
			
			if (isDuplicate) {
				DuplicatedMessage dupMessage = new DuplicatedMessage();
				dupMessage.setCodigoOperadora(msg.getOperadora());
				dupMessage.setMensagem(msg);
				dupMessage.setSmsMtSent(0);
				dupMessage.setMsisdn(msg.getMsisdn());
				dupMessage.setDtCompra(Calendar.getInstance().getTime());
				duplicatedMessageDAO.save(dupMessage);
				return null;
			}
			
			if(!existsCampaign()) {
				
				hist.setMessageStatus(MessageStatus.CAMPAIGN_NOT_FOUND);
				msg.setMessageStatus(MessageStatus.CAMPAIGN_NOT_FOUND);
				msgDAO.update(msg);
				historicoDAO.update(hist);
				
				WithoutCampaignMsg withoutCampaignMsg = new WithoutCampaignMsg();
				withoutCampaignMsg.setCodigoOperadora(msg.getOperadora());
				withoutCampaignMsg.setMensagem(msg);
				withoutCampaignMsg.setSmsMtSent(0);
				withoutCampaignMsg.setTxtMensagem(msg.getMensagem());
				withoutCampaignMsg.setMsisdn(msg.getMsisdn());
				withoutCampaignMsgDAO.save(withoutCampaignMsg);
				return null;
			}
					
			if(reachedLimitOfBuying(msg)) {
				
				hist.setMessageStatus(MessageStatus.BUY_LIMIT_REACHED);
				msg.setMessageStatus(MessageStatus.BUY_LIMIT_REACHED);
				msgDAO.update(msg);
				historicoDAO.update(hist);
				
				BuyingLimitExceed  bl = new BuyingLimitExceed();
				bl.setMensagem(msg);
				bl.setMsisdn(msg.getMsisdn());
				bl.setSmsMtSent(0);
				bl.setCodigoOperadora(msg.getOperadora());
				bl.setDtCompra(Calendar.getInstance().getTime());
				buyingLimitExceedDAO.save(bl);
				return null;
			}
		
			Sharecode sharecode = campaign.getRegra().getSharecode(msg.getOperadora());
			Transacao tr = new Transacao();
			tr.setDtSchedule(currentDate);
			tr.setDtTransacao(currentDate);
			tr.setKeycode(campaign.getRegra().getKeycode());
			tr.setLa(la);
			tr.setMensagem(msg);
			tr.setMsisdn(msg.getMsisdn());
			tr.setOperadora(msg.getOperadora());
			tr.setParceiro(keycode.getParceiro());
			tr.setRegra(campaign.getRegra());
			tr.setCampanha(campaign);
			tr.setSharecode(sharecode);
			tr.setValorTarifacao(sharecode.getTarifacao());
			tr.setDoubleOptionIn(0);
			
			switch (campaign.getFlowType()) {
			
				case Campanha.REQUIRES_AUTHORIZATION_FLOW:
					tr.setTransactionStatus(TransactionStatus.WAITING_TO_PROCESS);
					break;
					
				case Campanha.SIMPLIFIED_FLOW:
					tr.setTransactionStatus(TransactionStatus.TRANSACTION_AUTHORIZED);
					break;
			
				case Campanha.VOUCHER_FLOW:
					tr.setTransactionStatus(TransactionStatus.WAITING_TO_PROCESS);
					break;
			}
			
			transacaoDAO.save(tr);
			
		} catch (Exception e) {
			
			logger.error(loggerMessageDAO.getMessageById(8, e.getMessage()));
			hist.setMessageStatus(MessageStatus.ERROR);
			msg.setMessageStatus(MessageStatus.ERROR);
			msgDAO.update(msg);
			historicoDAO.update(hist);
		}
		
		return null; 
	}

	private boolean isDuplicate(String msisdn) {
		
		Mensagem lastMessage = msgDAO.findLastMessageByMsisdn(msisdn);
		if (lastMessage == null) {
			return false;
		}
		
		String interval = configDAO.findByName(DUPLICATED_CHECK_INTERVAL);
		Integer intervalAsInt;
		
		try {
			intervalAsInt = Integer.parseInt(interval);
		} catch (NumberFormatException exp) {
			intervalAsInt = 0;
		}
		
		Date dtEnd = lastMessage.getRequest();
		
		long dtBeginInMillis = System.currentTimeMillis();
		long dtEndInMillis   = dtEnd.getTime();
		long diffInSeconds   = (dtBeginInMillis - dtEndInMillis ) / 1000;
				
		if (diffInSeconds > intervalAsInt) {
			return false;
		}
 		
		return true;
	}
	
	private boolean existsCampaign() {

		String[] msgMo = moRequest.getTextMessage().split(delimiter);
		
		if (msgMo == null) {
			return false;
		}
		
		if (msgMo.length == 1) { 				
			String keycodeAsString	= msgMo[0];
			keycode					= keycodeDAO.findByNome(keycodeAsString);
			campaign 				= campanhaDAO.findByKeyword(keycodeAsString);
		
		} else if (msgMo.length == 2) {			
			String keycodeAsString	= msgMo[0];
			String keyword 			= msgMo[1];
			keycode					= keycodeDAO.findByNome(keycodeAsString);
			campaign 				= campanhaDAO.findByKeyword(keyword);
		}
		
		Integer carrier	= Integer.parseInt(moRequest.getCarrier());	
		
		if (keycode != null && campaign != null) {
			rule = campaign.getRegra();
			if (rule != null && rule.getKeycode().getId() == keycode.getId() &&  
				rule.getLa().getId() == la.getId() && rule.getSharecode(carrier) != null ) {
				return true;
			}
		}
		
		return false;
	}
	
	private boolean reachedLimitOfBuying(Mensagem msg) {
		boolean reachedLimit = false;
		try {
			BuyConfig config = buyConfigDAO.findConfigByOperadora(msg.getOperadora());
			
			if (config != null) {
			
				if (config.getMesCorrenteAtivo() == 1) {
					Double sum = billingRecordSuccessDAO.getBuyingSumByCurrentMonth(msg.getMsisdn());
					if( sum >= config.getVlMax()) {
						logger.info(loggerMessageDAO.getMessageById(2,sum));
						reachedLimit = true;
					} else {
						logger.info(loggerMessageDAO.getMessageById(3,sum));
					}
				} else {
					Integer numberOfDays = config.getNuDias();
					Double sum = billingRecordSuccessDAO.getBuyingSumByDaysBeforeCurrent(msg.getMsisdn(), numberOfDays);
					if( sum >= config.getVlMax()) {
						logger.info(loggerMessageDAO.getMessageById(10,numberOfDays,sum));
						reachedLimit = true;
					} else {
						logger.info(loggerMessageDAO.getMessageById(9,numberOfDays,sum));
					}
				}
			} else {
				String carrier = operadoraDAO.getCarrierById(moRequest.getCarrier());
				logger.error(loggerMessageDAO.getMessageById(1,carrier));
			}
		} catch (Exception exp) {
			logger.error(loggerMessageDAO.getMessageById(4,exp.getMessage()));
		}
		
		return reachedLimit;
	}

	private MORequest parseInputParameters(HttpServletRequest request) throws Exception {
		MORequest moRequest = new MORequest();

		InputStream is = request.getInputStream();

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(is);

		XPath xpath = XPathFactory.newInstance().newXPath();

		String msisdn = xpath.evaluate("/DeliveryRequest/ShortMessage/Header/Source/Number", document);
		moRequest.setOriginationNumber(msisdn);

		String carrier = xpath.evaluate("/DeliveryRequest/ShortMessage/Header/Source/Number/@carrierId",document);
		moRequest.setCarrier(carrier);

		String destination = xpath.evaluate("/DeliveryRequest/ShortMessage/Header/Destination/Number",document);
		moRequest.setDestinationNumber(destination);

		String textMessage = xpath.evaluate("/DeliveryRequest/ShortMessage/Body/Text", document);
		moRequest.setTextMessage(textMessage);

		Map<String, String> sessionData = parseSessionData(xpath.evaluate("/DeliveryRequest/Session", document));
		moRequest.setSessionData(sessionData);

		String extraInfo = xpath.evaluate("/DeliveryRequest/ShortMessage/Header/ExtraInfo", document);
		moRequest.setExtraInfo(extraInfo);

		return moRequest;
	}

	
	private Map<String, String> parseSessionData(String sessionDataString) {
		Map<String, String> sessionData = new HashMap<String, String>();
		StringTokenizer parameters = new StringTokenizer(sessionDataString, "&");
		while (parameters.hasMoreTokens()) {
			StringTokenizer parameter = new StringTokenizer(parameters.nextToken(), "=");
			if (parameter.countTokens() == 2) {
				sessionData.put(parameter.nextToken(), parameter.nextToken());
			}
		}
		return sessionData;
	}

	
	
	private boolean isOptionIn() {
		
		String optionInMsg 		= 	moRequest.getTextMessage();
		String expectedAnswer 	= 	configDAO.findByName(OPTION_IN_ANSWER);
		
		if (optionInMsg.equalsIgnoreCase(expectedAnswer)) {
			
			String originator 	= 	moRequest.getOriginationNumber();
			Transacao tr 		= 	transacaoDAO.findLastByMsisdnAndStatus(originator,TransactionStatus.WAIT_OPTION_IN_ANSWER);
			if (tr != null) {
				
				tr.setTransactionStatus(TransactionStatus.TRANSACTION_AUTHORIZED);
				transacaoDAO.update(tr);
				insertToMsgHist( tr,  optionInMsg, StatusType.WAIT_OPTION_IN_ANSWER , MessageStatus.TRANSACTION_AUTHORIZED);
				
				OptionIn optionIn = optionInDAO.findByTransactionId(tr.getId());
				optionIn.setTimeOfAuthorization(Calendar.getInstance().getTime());
				optionIn.setIsAuthorized(1);
				optionInDAO.update(optionIn);
				
				
				logger.info(loggerMessageDAO.getMessageByShortcode(	VOUCHER_AUTHORIZED, 
																	tr.getCampanha().getKeyword(),
																	tr.getMsisdn(),
																	tr.getId(),
																	dateTimeFormat.format(Calendar.getInstance().getTime())));
				
				
				
				List<Transacao> trList = transacaoDAO.findAllByMsisdnAndStatus(originator, TransactionStatus.WAIT_OPTION_IN_ANSWER);
				for (Transacao t : trList) {
					t.setTransactionStatus(TransactionStatus.TRANSACTION_CANCELED);
					transacaoDAO.update(t);
					insertToMsgHist( t, null, StatusType.WAIT_OPTION_IN_ANSWER, MessageStatus.TRANSACTION_CANCELED);
					
					logger.info(loggerMessageDAO.getMessageByShortcode(	VOUCHER_CANCELED, 
																		tr.getCampanha().getKeyword(),
																		tr.getMsisdn(),
																		tr.getId(),
																		dateTimeFormat.format(Calendar.getInstance().getTime())));
				}
				
				return true;

			} else {
			
				return false;
			
			}
		}
		
		return false;
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

	
	
	public void setMsgDAO(MensagemDAO msgDAO) {
		this.msgDAO = msgDAO; 
	}

	public void setLaDAO(LADAO laDAO) {
		this.laDAO = laDAO;
	}

	public void setHistoricoDAO(HistoricoDAO historicoDAO) {
		this.historicoDAO = historicoDAO;
	}

	public void setKeycodeDAO(KeycodeDAO keycodeDAO) {
		this.keycodeDAO = keycodeDAO;
	}

	public void setCampanhaDAO(CampanhaDAO campanhaDAO) {
		this.campanhaDAO = campanhaDAO;
	}

	public void setTransacaoDAO(TransacaoDAO transacaoDAO) {
		this.transacaoDAO = transacaoDAO;
	}

	public void setDelimitador(String delimitador) {
		if(delimitador != null && !delimitador.isEmpty()) 
			this.delimiter = delimitador;
	}

	public void setBuyConfigDAO(BuyConfigDAO buyConfigDAO) {
		this.buyConfigDAO = buyConfigDAO;
	}

	public void setBillingRecordSuccessDAO(BillingRecordSuccessDAO billingRecordSuccessDAO) {
		this.billingRecordSuccessDAO = billingRecordSuccessDAO;
	}

	public void setLoggerMessageDAO(LoggerMessageDAO loggerMessageDAO) {
		this.loggerMessageDAO = loggerMessageDAO;
	}

	public void setOperadoraDAO(OperadoraDAO operadoraDAO) {
		this.operadoraDAO = operadoraDAO;
	}

	public void setBuyingLimitExceedDAO(BuyingLimitExceedDAO buyingLimitExceedDAO) {
    	this.buyingLimitExceedDAO = buyingLimitExceedDAO;
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

	public void setOptionInDAO(OptionInDAO optionInDAO) {
		this.optionInDAO = optionInDAO;
	}
}
