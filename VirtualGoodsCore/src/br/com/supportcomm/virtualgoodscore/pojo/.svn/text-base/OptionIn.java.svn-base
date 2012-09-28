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

/**
 * 
 * @author maruen.mehana
 *
 */

@Entity
@Table(name = "option_in")
public class OptionIn implements Serializable{
	
	
	private static final long serialVersionUID = -6699907571830002305L;

	@Id
	@GeneratedValue		(generator = "option_in", strategy = GenerationType.AUTO )
	@SequenceGenerator	(name = "option_in"  	, sequenceName = "option_in_seq")
	@Column(name = "id_option_in")										private Long 		idOptionIn;
	
	@Column(name = "id_transacao", nullable = false, unique = true) 	private Long 		idTransacao;
	@Column(name = "id_campanha", nullable = false ) 					private Long 		idCampanha;
	@Column(name = "cd_msisdn", nullable = false, length = 50) 			private String 		msisdn;
	@Column(name = "msg_option_in_sent", nullable=false)				private Integer 	msgOptionInSent;
	@Column(name = "is_authorized", nullable=false)						private Integer 	isAuthorized;
	@Column(name = "time_of_authorization", nullable=true)				private Date 		timeOfAuthorization;
	@Column(name = "vl_compra", nullable=false)							private Double 		valorCompra;
	@Column(name = "dt_compra", nullable=false)							private Date 		dtCompra;
	@Column(name = "cd_operadora", nullable=false)						private Integer 	codigoOperadora;
	
	public Long getIdOptionIn() {
		return idOptionIn;
	}
	public void setIdOptionIn(Long idOptionIn) {
		this.idOptionIn = idOptionIn;
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
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public Integer getMsgOptionInSent() {
		return msgOptionInSent;
	}
	public void setMsgOptionInSent(Integer msgOptionInSent) {
		this.msgOptionInSent = msgOptionInSent;
	}
	public Integer getIsAuthorized() {
		return isAuthorized;
	}
	public void setIsAuthorized(Integer isAuthorized) {
		this.isAuthorized = isAuthorized;
	}
	public Date getTimeOfAuthorization() {
		return timeOfAuthorization;
	}
	public void setTimeOfAuthorization(Date timeOfAuthorization) {
		this.timeOfAuthorization = timeOfAuthorization;
	}
	public Double getValorCompra() {
		return valorCompra;
	}
	public void setValorCompra(Double valorCompra) {
		this.valorCompra = valorCompra;
	}
	public Date getDtCompra() {
		return dtCompra;
	}
	public void setDtCompra(Date dtCompra) {
		this.dtCompra = dtCompra;
	}
	public Integer getCodigoOperadora() {
		return codigoOperadora;
	}
	public void setCodigoOperadora(Integer codigoOperadora) {
		this.codigoOperadora = codigoOperadora;
	}
	
	
}
