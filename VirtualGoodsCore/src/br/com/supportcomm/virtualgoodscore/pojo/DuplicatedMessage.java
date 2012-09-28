package br.com.supportcomm.virtualgoodscore.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author maruen.mehana
 *
 */

@Entity
@Table ( name = "duplicated_message")
public class DuplicatedMessage implements Serializable {
    
    private static final long serialVersionUID = -6587562372238866540L;

	@Id
    @GeneratedValue(generator = "duplicated_message", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "duplicated_message", sequenceName = "duplicated_message_seq")
    @Column( name = "id_duplicated_message", nullable=false)		   private Long id;
    
    @OneToOne
    @JoinColumn( name = "id_mensagem", nullable=false)					private Mensagem  mensagem;
    
    @Column( name = "cd_msisdn",    nullable = false)					private String 	msisdn;
    @Column( name = "cd_operadora", nullable=false)						private Integer codigoOperadora;
	@Column( name = "dt_compra",    nullable=false)						private Date 	dtCompra;
	@Column( name = "sms_mt_sent",  nullable=false)						private Integer	smsMtSent;
	
	public Long getId() {
    	return id;
    }
	public void setId(Long id) {
    	this.id = id;
    }
	public String getMsisdn() {
    	return msisdn;
    }
	public void setMsisdn(String msisdn) {
    	this.msisdn = msisdn;
    }
	public Integer getCodigoOperadora() {
    	return codigoOperadora;
    }
	public void setCodigoOperadora(Integer codigoOperadora) {
    	this.codigoOperadora = codigoOperadora;
    }
	public Date getDtCompra() {
    	return dtCompra;
    }
	public void setDtCompra(Date dtCompra) {
    	this.dtCompra = dtCompra;
    }
	public Mensagem getMensagem() {
    	return mensagem;
    }
	public void setMensagem(Mensagem mensagem) {
    	this.mensagem = mensagem;
    }
	public Integer getSmsMtSent() {
    	return smsMtSent;
    }
	public void setSmsMtSent(Integer smsMtSent) {
    	this.smsMtSent = smsMtSent;
    }
}