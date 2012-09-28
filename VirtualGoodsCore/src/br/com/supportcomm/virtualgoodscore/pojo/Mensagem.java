package br.com.supportcomm.virtualgoodscore.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import br.com.supportcomm.virtualgoodscore.constantes.MessageStatus;

@Entity
public class Mensagem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8177480001310771531L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "mensagem")
	@SequenceGenerator(name = "mensagem", sequenceName = "mensagem_seq")
	@Column(name = "id_mensagem")
	private long id;
	
	@ManyToOne
	@JoinColumn(name="id_la", nullable = false)
	private LA la;
	
	@Column(name = "cd_operadora", nullable = false)
	private int operadora;
	
	@Column(name = "cd_msisdn", nullable = false, length = 50)
	private String msisdn;
	
	@Column(name = "tx_mensagem", nullable = false, length = 255)
	private String mensagem;
	
	@Enumerated(EnumType.STRING)
	private MessageStatus messageStatus;
	
	@Column(name = "dt_request", nullable = false)
	private Date request;
	
	@Column(name = "dt_processamento", nullable = false)
	private Date processamento;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LA getLa() {
		return la;
	}

	public void setLa(LA la) {
		this.la = la;
	}

	public int getOperadora() {
		return operadora;
	}

	public void setOperadora(int operadora) {
		this.operadora = operadora;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Date getRequest() {
		return request;
	}

	public void setRequest(Date request) {
		this.request = request;
	}

	public Date getProcessamento() {
		return processamento;
	}

	public void setProcessamento(Date processamento) {
		this.processamento = processamento;
	}

	public MessageStatus getMessageStatus() {
		return messageStatus;
	}

	public void setMessageStatus(MessageStatus messageStatus) {
		this.messageStatus = messageStatus;
	}
}
