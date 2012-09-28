package br.com.supportcomm.virtualgoodscore.pojo;

import java.io.Serializable;

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
@Table ( name = "without_campaign_msg")
public class WithoutCampaignMsg implements Serializable {

	
    private static final long serialVersionUID = -650762370514633977L;
    
    @Id
    @GeneratedValue(generator = "without_campaign_msg", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "without_campaign_msg", sequenceName = "without_campaign_msg_seq")
    @Column( name = "id", nullable=false)							private Long 	id;
    
    @OneToOne
	@JoinColumn(name="id_mensagem", nullable = false)				private Mensagem mensagem;
    
    @Column( name = "cd_msisdn", 	nullable=false)					private String 	 msisdn;
    @Column( name = "cd_operadora", nullable=false)					private Integer codigoOperadora;
    @Column( name = "tx_mensagem", 	nullable=false)					private String  txtMensagem;
    @Column( name = "sms_mt_sent", 	nullable=false)					private Integer smsMtSent;
	

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
	public Mensagem getMensagem() {
    	return mensagem;
    }
	public void setMensagem(Mensagem mensagem) {
    	this.mensagem = mensagem;
    }
	public String getTxtMensagem() {
    	return txtMensagem;
    }
	public void setTxtMensagem(String txtMensagem) {
    	this.txtMensagem = txtMensagem;
    }
	public Integer getSmsMtSent() {
    	return smsMtSent;
    }
	public void setSmsMtSent(Integer smsMtSent) {
    	this.smsMtSent = smsMtSent;
    }
	

}
