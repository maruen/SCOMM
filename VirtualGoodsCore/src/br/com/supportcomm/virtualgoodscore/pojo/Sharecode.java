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
import javax.persistence.UniqueConstraint;

import br.com.supportcomm.virtualgoodscore.constantes.Operadora;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "nm_sharecode","cd_operadora" }))
public class Sharecode implements Serializable {

	
	private static final long serialVersionUID = 8100691780986827698L;
	
	/* codigos de habilitados e desabilitados */
	public static final int ENABLED = 1;
	public static final int DISABLED = 0;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sharecode")
	@SequenceGenerator(name = "sharecode", sequenceName = "sharecode_seq")
	@Column(name = "id_sharecode")
	private long id;
	
	@Column(name = "nm_sharecode", nullable = false, length = 50)
	private String nome;
	
	@Column(name = "ds_sharecode", nullable = false, length = 128)
	private String descricao;
	
	@Column(name = "vl_tarifacao", nullable = false)
	private double tarifacao;
	
	@Column(name = "cd_operadora", nullable = false)
	private int operadora;
	
	@Column(name = "tx_mercuri_url", nullable = false, length = 128)
	private String mercuriUrl;
	
	@Column(name = "tx_mercuri_serviceid", nullable = false)
	private int mercuriServiceId;
	
	@Column(name = "tx_mercuri_itemid", nullable = false)
	private int mercuriItemId;
	
	@Column(name = "tx_mercuri_username", nullable = false, length = 50)
	private String mercuriUsername;
	
	@Column(name = "tx_mercuri_password", nullable = false, length = 50)
	private String mercuriPassword;
	
	@Column(name = "cd_ativo", nullable = false)
	private int ativo;
	
	@Column(name = "dt_criacao", nullable = false)
	private Date dtCriacao;
	
	@Column(name = "dt_alteracao", nullable = false)
	private Date dtAlteracao;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getTarifacao() {
		return tarifacao;
	}
	
	public String getTarifacaoFormat() {
		return new Double(tarifacao).toString();
	}

	public void setTarifacao(double tarifacao) {
		this.tarifacao = tarifacao;
	}

	public int getOperadora() {
		return operadora;
	}
	
	public String getOperadoraFormat() {
		if(operadora == Operadora.CLARO.getCarrier())
			return Operadora.CLARO.getDescricao();
		if(operadora == Operadora.VIVO.getCarrier())
			return Operadora.VIVO.getDescricao();
		if(operadora == Operadora.CTBC.getCarrier())
			return Operadora.CTBC.getDescricao();
		if(operadora == Operadora.NEXTEL.getCarrier())
			return Operadora.NEXTEL.getDescricao();
		if(operadora == Operadora.OI.getCarrier())
			return Operadora.OI.getDescricao();
		if(operadora == Operadora.TIM.getCarrier())
			return Operadora.TIM.getDescricao();
		return "";
	}

	public void setOperadora(int operadora) {
		this.operadora = operadora;
	}

	public String getMercuriUrl() {
		return mercuriUrl;
	}

	public void setMercuriUrl(String mercuriUrl) {
		this.mercuriUrl = mercuriUrl;
	}

	public int getMercuriServiceId() {
		return mercuriServiceId;
	}

	public void setMercuriServiceId(int mercuriServiceId) {
		this.mercuriServiceId = mercuriServiceId;
	}

	public int getMercuriItemId() {
		return mercuriItemId;
	}

	public void setMercuriItemId(int mercuriItemId) {
		this.mercuriItemId = mercuriItemId;
	}

	public String getMercuriUsername() {
		return mercuriUsername;
	}

	public void setMercuriUsername(String mercuriUsername) {
		this.mercuriUsername = mercuriUsername;
	}

	public String getMercuriPassword() {
		return mercuriPassword;
	}

	public void setMercuriPassword(String mercuriPassword) {
		this.mercuriPassword = mercuriPassword;
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
	
	public String getAtivoFormat() {
		if(this.ativo == ENABLED)
			return "SIM";
		if(this.ativo == DISABLED)
			return "NÃO";
		return "";
	}
	
	public boolean isHabilitado() {
		return this.ativo == ENABLED;
	}
}
