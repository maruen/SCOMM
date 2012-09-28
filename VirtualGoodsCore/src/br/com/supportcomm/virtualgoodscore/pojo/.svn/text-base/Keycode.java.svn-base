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
public class Keycode implements Serializable {

	private static final long serialVersionUID = 4256765116945915978L;
	
	
	public static final int ENABLED = 1;
	public static final int DISABLED = 0;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "keycode")
	@SequenceGenerator(name = "keycode", sequenceName = "keycode_seq")
	@Column(name = "id_keycode")
	private long id;
	
	@Column(name = "nm_keycode", nullable = false, length = 50, unique = true)
	private String nome;
	
	@ManyToOne
	@JoinColumn(name="id_parceiro", nullable = false)
	private Parceiro parceiro;
	
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

	public Parceiro getParceiro() {
		return parceiro;
	}

	public void setParceiro(Parceiro parceiro) {
		this.parceiro = parceiro;
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
			return "NAO";
		return "";
	}
	
	
	public boolean isHabilitado() {
		return this.ativo == ENABLED;
	}
}
