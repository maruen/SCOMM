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

@Entity
public class Parceiro implements Serializable {

	
	private static final long serialVersionUID = 2455166146414894872L;
	
	public static final int ENABLED = 1;
	public static final int DISABLED = 0;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "parceiro")
	@SequenceGenerator(name = "parceiro", sequenceName = "parceiro_seq")
	@Column(name = "id_parceiro")
	private long id;
	
	@Column(name = "nm_parceiro", nullable = false, length = 50, unique = true)
	private String nome;
	
	@Column(name = "nm_parceiro_performance", nullable = false, length = 50)
	private String nomePerformance;
	
	@Column(name = "nu_retentativa", nullable = false)
	private int retentativa;
	
	@Column(name = "nu_timeschedule", nullable = false)
	private int timeSchedule;
	
	@Column(name = "voucher_size", nullable = false)
	private int voucherSize;
	
	@Column(name = "cd_ativo", nullable = false)
	private int ativo;
	
	@Column(name = "dt_criacao", nullable = false)
	private Date dtCriacao;
	
	@Column(name = "dt_alteracao", nullable = false)
	private Date dtAlteracao;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "parceiro_la",joinColumns=@JoinColumn(name = "id_parceiro"),inverseJoinColumns=@JoinColumn(name = "id_la"))
	private Set<LA> las;
	
	@Column(name = "voucher_ws_login", nullable = false, length = 12, unique = true)
	private String voucherWSLogin;
	
	@Column(name = "voucher_ws_passwd", nullable = false, length = 12, unique = true)
	private String voucherWSPasswd;
	

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

	public Set<LA> getLas() {
		return las;
	}
	
	public String getLasFormat() {
		String s = new String();
		for(LA la: las)
			s += ";" + la.getNome();
		
		return s.replaceFirst(";", "").replaceAll(";", ", ");
	}

	public void setLas(Set<LA> las) {
		this.las = las;
	}

	public int getRetentativa() {
		return retentativa;
	}

	public void setRetentativa(int retentativa) {
		this.retentativa = retentativa;
	}

	public int getTimeSchedule() {
		return timeSchedule;
	}

	public void setTimeSchedule(int timeSchedule) {
		this.timeSchedule = timeSchedule;
	}

	public String getNomePerformance() {
		return nomePerformance;
	}

	public void setNomePerformance(String nomePerformance) {
		this.nomePerformance = nomePerformance;
	}	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parceiro other = (Parceiro) obj;
		if(id == other.id)
			return true;
		if (ativo != other.ativo)
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
		if (las == null) {
			if (other.las != null)
				return false;
		} else if (!las.equals(other.las))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (nomePerformance == null) {
			if (other.nomePerformance != null)
				return false;
		} else if (!nomePerformance.equals(other.nomePerformance))
			return false;
		if (retentativa != other.retentativa)
			return false;
		if (timeSchedule != other.timeSchedule)
			return false;
		return true;
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

	public int getVoucherSize() {
		return voucherSize;
	}

	public void setVoucherSize(int voucherSize) {
		this.voucherSize = voucherSize;
	}

	public String getVoucherWSLogin() {
		return voucherWSLogin;
	}

	public void setVoucherWSLogin(String voucherWSLogin) {
		this.voucherWSLogin = voucherWSLogin;
	}

	public String getVoucherWSPasswd() {
		return voucherWSPasswd;
	}

	public void setVoucherWSPasswd(String voucherWSPasswd) {
		this.voucherWSPasswd = voucherWSPasswd;
	}
}