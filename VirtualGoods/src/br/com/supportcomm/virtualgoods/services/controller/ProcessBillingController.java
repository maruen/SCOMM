package br.com.supportcomm.virtualgoods.services.controller;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Hex;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import br.com.supportcomm.virtualgoodscore.billing.ChargeStatus;
import br.com.supportcomm.virtualgoodscore.billing.service.platform.BillingPlatform;
import br.com.supportcomm.virtualgoodscore.constantes.MessageStatus;
import br.com.supportcomm.virtualgoodscore.constantes.StatusType;
import br.com.supportcomm.virtualgoodscore.constantes.TransactionStatus;
import br.com.supportcomm.virtualgoodscore.dao.BillingRecordFailureDAO;
import br.com.supportcomm.virtualgoodscore.dao.BillingRecordSuccessDAO;
import br.com.supportcomm.virtualgoodscore.dao.HistoricoDAO;
import br.com.supportcomm.virtualgoodscore.dao.TransacaoDAO;
import br.com.supportcomm.virtualgoodscore.dao.VoucherDAO;
import br.com.supportcomm.virtualgoodscore.pojo.BillingRecordFailure;
import br.com.supportcomm.virtualgoodscore.pojo.BillingRecordSuccess;
import br.com.supportcomm.virtualgoodscore.pojo.Campanha;
import br.com.supportcomm.virtualgoodscore.pojo.Historico;
import br.com.supportcomm.virtualgoodscore.pojo.Transacao;
import br.com.supportcomm.virtualgoodscore.pojo.Voucher;

public class ProcessBillingController extends AbstractController {

	private TransacaoDAO 					transacaoDAO;
	private HistoricoDAO				 	historicoDAO;
	private BillingRecordSuccessDAO 		billingRecordSuccessDAO;
	private BillingRecordFailureDAO 		billingRecordFailureDAO;
	private VoucherDAO 						voucherDAO;
	private BillingPlatform 				billingPlatform;
	
	private final String PARAM_MSISDN 		= "msisdn";
	private final String PARAM_MSG			= "message";
	private final String PARAM_ID_MSG 		= "mid";
	private final String PARAM_LA 			= "sc";
	private final String PARAM_OPERADORA 	= "operator";

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,HttpServletResponse arg1) throws Exception {

		List<Transacao> list = transacaoDAO.findByStatus(TransactionStatus.TRANSACTION_AUTHORIZED);		
		logger.info("Start ProcessBillingController....: " + list.size() + " records processed");
		
		for (Transacao tr : list) {
			tr.setTransactionStatus(TransactionStatus.PROCESS_BILLING);
			transacaoDAO.update(tr);
			insertToMsgHist(tr,null, StatusType.PROCESS_BILLING, MessageStatus.PROCESS_BILLING);
			
			ChargeStatus chargeStatus = billingPlatform.executeCharge(tr).getChargeStatus();
			
			if(ChargeStatus.CHARGED.equals(chargeStatus)) {

				tr.setTransactionStatus(TransactionStatus.BILLING_SUCCESS);
				transacaoDAO.update(tr);
				insertToBillingRecordSuccess(tr);
				insertToMsgHist(tr,ChargeStatus.CHARGED.toString(), StatusType.PROCESS_BILLING, MessageStatus.BILLING_SUCCESS);
			
			} else {
				
				tr.setTransactionStatus(TransactionStatus.BILLING_FAILED);
				transacaoDAO.update(tr);
				insertToBillingRecordFailure(tr);
				insertToMsgHist(tr, chargeStatus.toString(),StatusType.PROCESS_BILLING, MessageStatus.BIllING_FAILED);
			}
		
		
			Campanha campaign = tr.getCampanha();
			switch (campaign.getFlowType()) {
					
				case Campanha.VOUCHER_FLOW:
					  handleVoucherAfterBilling(tr,chargeStatus);
					  break;
					
				}
		}	

		logger.info("Finish ProcessBillingController");
		return null;
	}

	
	private void handleVoucherAfterBilling(Transacao tr, ChargeStatus chargeStatus) {
	
		if ( tr.getTransactionStatus() == TransactionStatus.BILLING_SUCCESS ) {
			tr.setTransactionStatus(TransactionStatus.VOUCHER_GENERATED);
			transacaoDAO.update(tr);
			String voucherCode = generateVoucher(tr);
			insertToMsgHist(tr, voucherCode , StatusType.GENERATE_VOUCHER, MessageStatus.VOUCHER_GENERATED);
			
		} else {
			tr.setTransactionStatus(TransactionStatus.VOUCHER_NOT_GENERATED);
			transacaoDAO.update(tr);
			insertToMsgHist(tr, null, StatusType.GENERATE_VOUCHER, MessageStatus.VOUCHER_NOT_GENERATED);
		}
	}

	private String generateVoucher(Transacao tr) {
		String voucherCode = tr.getMsisdn() + tr.getDtTransacao();
		Integer voucherSize = tr.getParceiro().getVoucherSize();
				
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		messageDigest.reset();
		messageDigest.update(voucherCode.getBytes(Charset.forName("UTF8")));
		final byte[] resultByte = messageDigest.digest();
		final String result = new String(Hex.encodeHex(resultByte));
		
		Voucher newVoucher = new Voucher();
		newVoucher.setVoucherMTSent(0);
		newVoucher.setIdCampanha(tr.getCampanha().getId());
		newVoucher.setIdTransacao(tr.getId());
		newVoucher.setIsConsumed(0);
		newVoucher.setConsumptionDate(null);
		newVoucher.setVoucherValue(tr.getValorTarifacao());
		newVoucher.setVoucherCode(result.substring(0,voucherSize));
		newVoucher.setMsisdn(tr.getMsisdn());
		newVoucher.setPurchaseDate(Calendar.getInstance().getTime());
		newVoucher.setExpirationDate(null);
		newVoucher.setIdMensagem(tr.getMensagem().getId());
		voucherDAO.save(newVoucher);
		return result.substring(0,voucherSize);
	}
	
	private void insertToBillingRecordSuccess(Transacao tr) {
		BillingRecordSuccess entity = new BillingRecordSuccess();
		entity.setDtCompra(tr.getDtTransacao());
		entity.setIdTransacao(tr.getId());
		entity.setMsisdn(tr.getMsisdn());
		entity.setValorCompra(tr.getValorTarifacao());
		entity.setCodigoOperadora(tr.getOperadora());
		entity.setSentProtocol(0);
		entity.setProtocol(getProtocol());
		billingRecordSuccessDAO.save(entity);
	}

	private long getProtocol() {
	    long protocol = billingRecordSuccessDAO.getProtocolNumber();
		logger.info("Generating protocol number: " + String.valueOf(protocol));
	    return protocol;
    }
	
	private void insertToBillingRecordFailure(Transacao tr) {
		BillingRecordFailure entity = new BillingRecordFailure();
		entity.setDtCompra(tr.getDtTransacao());
		entity.setIdTransacao(tr.getId());
		entity.setMsisdn(tr.getMsisdn());
		entity.setValorCompra(tr.getValorTarifacao());
		entity.setCodigoOperadora(tr.getOperadora());
		entity.setMsgFailureSent(0);
		billingRecordFailureDAO.save(entity);
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
	
	public void setTransacaoDAO(TransacaoDAO transacaoDAO) {
		this.transacaoDAO = transacaoDAO;
	}

	public void setHistoricoDAO(HistoricoDAO historicoDAO) {
		this.historicoDAO = historicoDAO;
	}
	
	public void setBillingRecordSuccessDAO(BillingRecordSuccessDAO billingRecordSuccessDAO) {
		this.billingRecordSuccessDAO = billingRecordSuccessDAO;
	}

	public void setBillingRecordFailureDAO(BillingRecordFailureDAO billingRecordFailureDAO) {
		this.billingRecordFailureDAO = billingRecordFailureDAO;
	}

	public void setBillingPlatform(BillingPlatform billingPlatform) {
		this.billingPlatform = billingPlatform;
	}

	public void setVoucherDAO(VoucherDAO voucherDAO) {
		this.voucherDAO = voucherDAO;
	}
	
}
