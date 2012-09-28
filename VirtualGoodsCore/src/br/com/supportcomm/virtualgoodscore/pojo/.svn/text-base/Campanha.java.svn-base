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
public class Campanha implements Serializable {

	
	private static final long serialVersionUID = -7674088272411855998L;
	
	
	public static final int ENABLED 	= 1;
	public static final int DISABLED 	= 0;
	
	public static final int SIMPLIFIED_FLOW 				= 1;
	public static final int REQUIRES_AUTHORIZATION_FLOW 	= 2;
	public static final int VOUCHER_FLOW 					= 3;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "campanha")
	@SequenceGenerator(name = "campanha", sequenceName = "campanha_seq")
	@Column(name = "id_campanha")
	private long id;
	
	@Column(name = "keyword", nullable = false, length = 50, unique = true)
	private String keyword;
	
	@ManyToOne
	@JoinColumn(name="id_tipo_campanha", nullable = false)
	private TipoCampanha tipoCampanha;
	
	@ManyToOne
	@JoinColumn(name="id_regra", nullable = false)
	private Regra regra;
	
	@Column(name = "nm_portalvenda_performance", nullable = false, length = 50)
	private String nomePortalVendaPerformance;
	
	@Column(name = "url_pedido", nullable = false, length = 255)
	private String urlPedido;
	
	@Column(name = "url_confirmstatus", nullable = false, length = 255)
	private String urlConfirmStatus;
	
	@Column(name = "cd_ativo", nullable = false)
	private int ativo;
	
	@Column(name = "dt_criacao", nullable = false)
	private Date dtCriacao;
	
	@Column(name = "flow_type", nullable = false)
	private Integer flowType;
	
	@Column(name = "dt_alteracao", nullable = false)
	private Date dtAlteracao;
	
	@Column(name = "txt_mt_success", nullable = false)
	private String mtSuccess;
	
	@Column(name = "txt_mt_fail", nullable = false)
	private String mtFail;

	@Column(name = "txt_mt_option_in", nullable = true)
	private String mtOptionIn;
	
	@Column(name = "txt_mt_voucher", nullable = true)
	private String mtVoucher;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	public TipoCampanha getTipoCampanha() {
		return tipoCampanha;
	}

	public void setTipoCampanha(TipoCampanha tipoCampanha) {
		this.tipoCampanha = tipoCampanha;
	}

	public Regra getRegra() {
		return regra;
	}

	public void setRegra(Regra regra) {
		this.regra = regra;
	}

	public String getUrlPedido() {
		return urlPedido;
	}

	public void setUrlPedido(String urlPedido) {
		this.urlPedido = urlPedido;
	}

	public String getUrlConfirmStatus() {
		return urlConfirmStatus;
	}

	public void setUrlConfirmStatus(String urlConfirmStatus) {
		this.urlConfirmStatus = urlConfirmStatus;
	}

	public int getAtivo() {
		return ativo;
	}

	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}

	public Date getDtCriacao() {
		return dtCriacao;
	}

	public void setDtCriacao(Date dtCriacao) {
		this.dtCriacao = dtCriacao;
	}

	public Date getDtAlteracao() {
		return dtAlteracao;
	}

	public void setDtAlteracao(Date dtAlteracao) {
		this.dtAlteracao = dtAlteracao;
	}

	public String getNomePortalVendaPerformance() {
		return nomePortalVendaPerformance;
	}

	public void setNomePortalVendaPerformance(String nomePortalVendaPerformance) {
		this.nomePortalVendaPerformance = nomePortalVendaPerformance;
	}
	
	public String getAtivoFormat() {
		if(this.ativo == ENABLED)
			return "SIM";
		if(this.ativo == DISABLED)
			return "NAO";
		return "";
	}
	
	public boolean isHabilitado() {
		return this.ativo == ENABLED;
	}

	public String getMtSuccess() {
    	return mtSuccess;
    }

	public void setMtSuccess(String mtSuccess) {
    	this.mtSuccess = mtSuccess;
    }

	public String getMtFail() {
    	return mtFail;
    }

	public void setMtFail(String mtFail) {
    	this.mtFail = mtFail;
    }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getFlowType() {
		return flowType;
	}

	public void setFlowType(Integer flowType) {
		this.flowType = flowType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public String getMtOptionIn() {
		return mtOptionIn;
	}

	public void setMtOptionIn(String mtOptionIn) {
		this.mtOptionIn = mtOptionIn;
	}
	
	public String getMtVoucher() {
		return mtVoucher;
	}

	public void setMtVoucher(String mtVoucher) {
		this.mtVoucher = mtVoucher;
	}
		
}
