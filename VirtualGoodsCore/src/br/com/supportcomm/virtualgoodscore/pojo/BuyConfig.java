package br.com.supportcomm.virtualgoodscore.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author maruen.mehana
 *
 */


@Entity
@Table(name = "buy_config")
public class BuyConfig implements Serializable {

	private static final long serialVersionUID = -6665057364246609949L;

	@Id
	@Column(name = "cd_operadora",nullable=false)			private Integer codigoOperadora;
	
	@Column(name = "vl_max", nullable=false) 				private Double vlMax;
	@Column(name = "nu_dias")								private Integer nuDias;
	@Column(name = "mes_corrente_ativo", nullable=false)	private Integer mesCorrenteAtivo;
	@Column(name = "cd_config_ativo")						private Integer codConfigAtivo;
	@Column(name = "msg_limite_excedido")					private String msgLimiteExcedido;
	@Column(name = "dt_alteracao", nullable=false)			private Date dtAlteracao;
	@Column(name = "dt_criacao", nullable=false)			private Date dtCriacao;
	
	
	public Integer getCodigoOperadora() {
		return this.codigoOperadora;
	}
	public void setCodigoOperadora(Integer codigoOperadora) {
		this.codigoOperadora = codigoOperadora;
	}
	public Double getVlMax() {
		return vlMax;
	}
	public void setVlMax(Double vlMax) {
		this.vlMax = vlMax;
	}
	public Integer getNuDias() {
		return nuDias;
	}
	public void setNuDias(Integer nuDias) {
		this.nuDias = nuDias;
	}
	public Integer getMesCorrenteAtivo() {
		return mesCorrenteAtivo;
	}
	public void setMesCorrenteAtivo(Integer mesCorrenteAtivo) {
		this.mesCorrenteAtivo = mesCorrenteAtivo;
	}
	public String getMsgLimiteExcedido() {
		return msgLimiteExcedido;
	}
	public void setMsgLimiteExcedido(String msgLimiteExcedido) {
		this.msgLimiteExcedido = msgLimiteExcedido;
	}
	public Date getDtAlteracao() {
		return dtAlteracao;
	}
	public void setDtAlteracao(Date dtAlteracao) {
		this.dtAlteracao = dtAlteracao;
	}
	public Date getDtCriacao() {
		return dtCriacao;
	}
	public void setDtCriacao(Date dtCriacao) {
		this.dtCriacao = dtCriacao;
	}
	
	public Integer getCodConfigAtivo() {
    	return codConfigAtivo;
    }
	public void setCodConfigAtivo(Integer codConfigAtivo) {
    	this.codConfigAtivo = codConfigAtivo;
    }
	
	@Override
    public String toString() {
	    return String.valueOf(this.codigoOperadora);
    }
	
	

}
