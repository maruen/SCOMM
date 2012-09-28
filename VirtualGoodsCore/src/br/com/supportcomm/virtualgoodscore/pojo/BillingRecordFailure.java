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
@Table(name = "billing_record_failure")
public class BillingRecordFailure implements Serializable{

	private static final long serialVersionUID = -2824653127641629836L;
	
	@Id
	@GeneratedValue(generator = "billing_record_failure", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "billing_record_failure", sequenceName = "billing_record_failure_seq")
	@Column(name = "id_billrec_failure")
	private long id;
	
	@Column(name = "id_transacao", nullable = false, unique = true)	private long idTransacao;
	@Column(name = "cd_msisdn", nullable = false, length = 50)			private String msisdn;
	@Column(name = "msg_failure_sent", nullable = false)				private Integer msgFailureSent;
	@Column(name = "vl_compra", nullable=false)							private Double valorCompra;
	@Column(name = "dt_compra", nullable=false)							private Date dtCompra;
	@Column(name = "cd_operadora", nullable=false)						private Integer codigoOperadora;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getIdTransacao() {
		return idTransacao;
	}

	public void setIdTransacao(long idTransacao) {
		this.idTransacao = idTransacao;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
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

	public Integer getMsgFailureSent() {
    	return msgFailureSent;
    }

	public void setMsgFailureSent(Integer msgFailureSent) {
    	this.msgFailureSent = msgFailureSent;
    }
	
	
}
