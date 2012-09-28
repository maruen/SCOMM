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

import br.com.supportcomm.virtualgoodscore.constantes.TransactionStatus;
import br.com.supportcomm.virtualgoodscore.util.DataUtil;

@Entity
public class Transacao implements Serializable {

	
	private static final long serialVersionUID = -3832181328802506025L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "transacao")
	@SequenceGenerator(name = "transacao", sequenceName = "transacao_seq")
	@Column(name = "id_transacao")
	private long id;
	
	@Column(name = "cd_msisdn", nullable = false, length = 50)
	private String msisdn;
	
	@Column(name = "cd_operadora", nullable = false)
	private int operadora;
	
	@ManyToOne
	@JoinColumn(name="id_parceiro", nullable = false)
	private Parceiro parceiro;
	
	@ManyToOne
	@JoinColumn(name="id_la", nullable = false)
	private LA la;
	
	@ManyToOne
	@JoinColumn(name="id_sharecode", nullable = false)
	private Sharecode sharecode;
	
	@ManyToOne
	@JoinColumn(name="id_keycode", nullable = false)
	private Keycode keycode;
	
	@ManyToOne
	@JoinColumn(name="id_regra", nullable = false)
	private Regra regra;
	
	@ManyToOne
	@JoinColumn(name="id_campanha", nullable = false)
	private Campanha campanha;
	
	@ManyToOne
	@JoinColumn(name="id_mensagem", nullable = false)
	private Mensagem mensagem;
	
	@Column(name = "vl_tarifacao", nullable = false)
	private double valorTarifacao;
	
	@Enumerated(EnumType.STRING)
	private TransactionStatus transactionStatus;
	
	@Column(name = "dt_transacao", nullable = false)
	private Date dtTransacao;
	
	@Column(name = "dt_schedule", nullable = false)
	private Date dtSchedule;
	
	@Column(name = "double_option_in", nullable = false)
	private Integer doubleOptionIn;
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public int getOperadora() {
		return operadora;
	}

	public void setOperadora(int operadora) {
		this.operadora = operadora;
	}

	public Parceiro getParceiro() {
		return parceiro;
	}

	public void setParceiro(Parceiro parceiro) {
		this.parceiro = parceiro;
	}

	public LA getLa() {
		return la;
	}

	public void setLa(LA la) {
		this.la = la;
	}

	public Sharecode getSharecode() {
		return sharecode;
	}

	public void setSharecode(Sharecode sharecode) {
		this.sharecode = sharecode;
	}

	public Keycode getKeycode() {
		return keycode;
	}

	public void setKeycode(Keycode keycode) {
		this.keycode = keycode;
	}

	public Regra getRegra() {
		return regra;
	}

	public void setRegra(Regra regra) {
		this.regra = regra;
	}

	public Mensagem getMensagem() {
		return mensagem;
	}

	public void setMensagem(Mensagem mensagem) {
		this.mensagem = mensagem;
	}

	public double getValorTarifacao() {
		return valorTarifacao;
	}

	public void setValorTarifacao(double valorTarifacao) {
		this.valorTarifacao = valorTarifacao;
	}
	
	public Date getDtTransacao() {
		return dtTransacao;
	}

	public String getDtTransacaoFormat() {
		return DataUtil.formatarDataTimestamp(dtTransacao);
	}
	
	public void setDtTransacao(Date dtTransacao) {
		this.dtTransacao = dtTransacao;
	}

	public Date getDtSchedule() {
		return dtSchedule;
	}

	public void setDtSchedule(Date dtSchedule) {
		this.dtSchedule = dtSchedule;
	}

	public Campanha getCampanha() {
		return campanha;
	}

	public void setCampanha(Campanha campanha) {
		this.campanha = campanha;
	}
	
	public Integer getDoubleOptionIn() {
		return doubleOptionIn;
	}

	public void setDoubleOptionIn(Integer doubleOptionIn) {
		this.doubleOptionIn = doubleOptionIn;
	}

	public TransactionStatus getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(TransactionStatus transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

}
