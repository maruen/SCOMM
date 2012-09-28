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

@Entity
@Table(name = "tipo_campanha")
public class TipoCampanha implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6941073578706637803L;
	
	/* codigos de habilitados e desabilitados */
	public static final int ENABLED = 1;
	public static final int DISABLED = 0;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "tipo_campanha")
	@SequenceGenerator(name = "tipo_campanha", sequenceName = "tipo_campanha_seq")
	@Column(name = "id_tipo_campanha")
	private long id;
	
	@Column(name = "nm_tipo_campanha", nullable = false, length = 50)
	private String nome;
	
	@Column(name = "sg_tipo_campanha", nullable = false, length = 50, unique = true)
	private String sigla;
	
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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
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
	
	/**
	 * Método usado somente pela JSTL, para exibir o status formatado
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
	 * Método usado somente pela JSTL, para retornar se está
	 * habilitado
	 * 
	 * @return
	 */
	public boolean isHabilitado() {
		return this.ativo == ENABLED;
	}
}
