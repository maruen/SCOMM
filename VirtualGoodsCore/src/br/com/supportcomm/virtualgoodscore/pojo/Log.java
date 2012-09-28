package br.com.supportcomm.virtualgoodscore.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Log implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4495383185009966875L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "log")
	@SequenceGenerator(name = "log", sequenceName = "log_seq")
	@Column(name = "id_log")
	private long id;
	

	@ManyToOne
	@JoinColumn(name="id_transacao", nullable = false)
	private Transacao transacao;

	@Column(name = "st_transacao", nullable = false)
	private int statusTransacao;
	
	@Column(name = "dt_criacao", nullable = false)
	private Date dtCriacao;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Transacao getTransacao() {
		return transacao;
	}

	public void setTransacao(Transacao transacao) {
		this.transacao = transacao;
	}

	public int getStatusTransacao() {
		return statusTransacao;
	}

	public void setStatusTransacao(int statusTransacao) {
		this.statusTransacao = statusTransacao;
	}

	public Date getDtCriacao() {
		return dtCriacao;
	}

	public void setDtCriacao(Date dtCriacao) {
		this.dtCriacao = dtCriacao;
	}
}
