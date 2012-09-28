package br.com.supportcomm.virtualgoodscore.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import br.com.supportcomm.virtualgoodscore.constantes.Operadora;

@Entity
public class LA implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2492355244196697003L;
	
	/* codigos de habilitados e desabilitados */
	public static final int ENABLED = 1;
	public static final int DISABLED = 0;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "la")
	@SequenceGenerator(name = "la", sequenceName = "la_seq")
	@Column(name = "id_la")
	private long id;
	
	@Column(name = "nm_la", nullable = false, length = 50, unique = true)
	private String nome;
	
	@Column(name = "ds_la", nullable = false, length = 50)
	private String descricao;
	
	@Column(name = "cd_vivo", nullable = false)
	private int codVivo;
	
	@Column(name = "cd_oi", nullable = false)
	private int codOi;
	
	@Column(name = "cd_claro", nullable = false)
	private int codClaro;
	
	@Column(name = "cd_tim", nullable = false)
	private int codTim;
	
	@Column(name = "cd_nextel", nullable = false)
	private int codNextel;
	
	@Column(name = "cd_ctbc", nullable = false)
	private int codCtbc;
	
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
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "parceiro_la",
		joinColumns=@JoinColumn(name = "id_la"),
		inverseJoinColumns=@JoinColumn(name = "id_parceiro"))
	private Set<Parceiro> parceiros;	
	
	/**
	 * propriedade utilizada para manter selecionada o LA na jsp
	 */
	@Transient
	private boolean selected = false;

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

	public int getCodVivo() {
		return codVivo;
	}

	public void setCodVivo(int codVivo) {
		this.codVivo = codVivo;
	}

	public int getCodOi() {
		return codOi;
	}

	public void setCodOi(int codOi) {
		this.codOi = codOi;
	}

	public int getCodClaro() {
		return codClaro;
	}

	public void setCodClaro(int codClaro) {
		this.codClaro = codClaro;
	}

	public int getCodTim() {
		return codTim;
	}

	public void setCodTim(int codTim) {
		this.codTim = codTim;
	}

	public int getCodNextel() {
		return codNextel;
	}

	public void setCodNextel(int codNextel) {
		this.codNextel = codNextel;
	}

	public int getCodCtbc() {
		return codCtbc;
	}

	public void setCodCtbc(int codCtbc) {
		this.codCtbc = codCtbc;
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

	public Set<Parceiro> getParceiros() {
		return parceiros;
	}

	public void setParceiros(Set<Parceiro> parceiros) {
		this.parceiros = parceiros;
	}
	
	public String getCarrierIdListFormat() {
		String s = new String();
		if(this.codClaro == ENABLED) {
			s += ";" + Operadora.CLARO.getDescricao();
		} 
		if(this.codCtbc == ENABLED) {
			s += ";" + Operadora.CTBC.getDescricao();
		}
		if(this.codNextel == ENABLED) {
			s += ";" + Operadora.NEXTEL.getDescricao();
		}
		if(this.codOi == ENABLED) {
			s += ";" + Operadora.OI.getDescricao();
		}
		if(this.codTim == ENABLED) {
			s += ";" + Operadora.TIM.getDescricao();
		}
		if(this.codVivo == ENABLED) {
			s += ";" + Operadora.VIVO.getDescricao();
		}
		return s.replaceFirst(";", "").replaceAll(";", ", ");
	}
	
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	/**
	 * Método usado somente pela JSTL, para exibir o status formatado da LA
	 * 
	 * @return
	 */
	public String getAtivoFormat() {
		if(this.ativo == ENABLED)
			return "SIM";
		if(this.ativo == DISABLED)
			return "NÃO";
		return "";
	}
	
	/**
	 * Método usado somente pela JSTL, para retornar se o LA está
	 * habilitado
	 * 
	 * @return
	 */
	public boolean isHabilitado() {
		return this.ativo == ENABLED;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LA other = (LA) obj;
		if(id == other.id)
			return true;
		if (ativo != other.ativo)
			return false;
		if (codClaro != other.codClaro)
			return false;
		if (codCtbc != other.codCtbc)
			return false;
		if (codNextel != other.codNextel)
			return false;
		if (codOi != other.codOi)
			return false;
		if (codTim != other.codTim)
			return false;
		if (codVivo != other.codVivo)
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (dtAlteracao == null) {
			if (other.dtAlteracao != null)
				return false;
		} else if (!dtAlteracao.equals(other.dtAlteracao))
			return false;
		if (dtCriacao == null) {
			if (other.dtCriacao != null)
				return false;
		} else if (!dtCriacao.equals(other.dtCriacao))
			return false;
		if (id != other.id)
			return false;
		if (mercuriItemId != other.mercuriItemId)
			return false;
		if (mercuriPassword == null) {
			if (other.mercuriPassword != null)
				return false;
		} else if (!mercuriPassword.equals(other.mercuriPassword))
			return false;
		if (mercuriServiceId != other.mercuriServiceId)
			return false;
		if (mercuriUrl == null) {
			if (other.mercuriUrl != null)
				return false;
		} else if (!mercuriUrl.equals(other.mercuriUrl))
			return false;
		if (mercuriUsername == null) {
			if (other.mercuriUsername != null)
				return false;
		} else if (!mercuriUsername.equals(other.mercuriUsername))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (parceiros == null) {
			if (other.parceiros != null)
				return false;
		} else if (!parceiros.equals(other.parceiros))
			return false;
		if (selected != other.selected)
			return false;
		return true;
	}
}
