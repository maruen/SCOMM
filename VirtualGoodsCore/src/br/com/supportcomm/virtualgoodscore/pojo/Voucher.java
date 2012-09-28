package br.com.supportcomm.virtualgoodscore.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name = "voucher")
public class Voucher  implements Serializable{
	
	private static final long serialVersionUID = -6635140672257953179L;
	
	@Id
	@GeneratedValue    (generator = "voucher", 			strategy 		= GenerationType.AUTO)
	@SequenceGenerator (name 	  = "voucher", 			sequenceName  	= "voucher_seq")
	@Column			   (name 	  = "voucher_id", 		nullable=false)			private Long voucherId;
	
	@Column(name = "id_mensagem", 		nullable=false)							private Long 		idMensagem;
	@Column(name = "id_transacao", 		nullable=false,  unique = true)		private Long 		idTransacao;
	@Column(name = "id_campanha", 		nullable=false)							private Long 		idCampanha;
	@Column(name = "msisdn", 			nullable=false)							private String 		msisdn;
	@Column(name = "voucher_code", 		nullable=false)							private String 		voucherCode;
	@Column(name = "voucher_value",		nullable=false)							private Double 		voucherValue;
	@Column(name = "purchase_date",		nullable=false)							private Date 		purchaseDate;
	@Column(name = "expiration_date",	nullable=true )							private Date 		expirationDate;
	@Column(name = "is_consumed",		nullable=false)							private Integer 	isConsumed;
	@Column(name = "consumption_date",	nullable=true )							private Date 		consumptionDate;
	@Column(name = "voucher_mt_sent",	nullable=false)							private Integer 	voucherMTSent;
	
	
	public Long getVoucherId() {
		return voucherId;
	}
	public void setVoucherId(Long voucherId) {
		this.voucherId = voucherId;
	}
	public Long getIdMensagem() {
		return idMensagem;
	}
	public void setIdMensagem(Long idMensagem) {
		this.idMensagem = idMensagem;
	}
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public String getVoucherCode() {
		return voucherCode;
	}
	public void setVoucherCode(String voucherCode) {
		this.voucherCode = voucherCode;
	}
	public Double getVoucherValue() {
		return voucherValue;
	}
	public void setVoucherValue(Double voucherValue) {
		this.voucherValue = voucherValue;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	public Integer getIsConsumed() {
		return isConsumed;
	}
	public void setIsConsumed(Integer isConsumed) {
		this.isConsumed = isConsumed;
	}
	public Integer getVoucherMTSent() {
		return voucherMTSent;
	}
	public void setVoucherMTSent(Integer voucherMTSent) {
		this.voucherMTSent = voucherMTSent;
	}
	public Long getIdTransacao() {
		return idTransacao;
	}
	public void setIdTransacao(Long idTransacao) {
		this.idTransacao = idTransacao;
	}
	public Long getIdCampanha() {
		return idCampanha;
	}
	public void setIdCampanha(Long idCampanha) {
		this.idCampanha = idCampanha;
	}
	public Date getConsumptionDate() {
		return consumptionDate;
	}
	public void setConsumptionDate(Date consumptionDate) {
		this.consumptionDate = consumptionDate;
	}
	
}
	