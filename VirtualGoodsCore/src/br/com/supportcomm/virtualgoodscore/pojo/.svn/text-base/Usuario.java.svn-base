package br.com.supportcomm.virtualgoodscore.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -95293952806569292L;
	
	/* codigos do campo ativo da tabela usuário */
	public static final int CD_ATIVO_TRUE = 1;
	public static final int CD_ATIVO_FALSE = 0;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "usuario")
	@SequenceGenerator(name = "usuario", sequenceName = "usuario_seq")
	@Column(name = "id_usuario")
	private long id;
	
	@Column(name = "nm_usuario", nullable = false, length = 50)
	private String nome;
	
	@Column(name = "cd_login", nullable = false, length = 50, unique = true)
	private String login;
	
	@Column(name = "tx_senha", nullable = false, length = 50)
	private String senha;

	@Column(name = "tx_email", nullable = false, length = 128)
	private String email;
	
	@Column(name = "cd_perfil", nullable = false, length = 50)
	private String perfil;
	
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
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
	 * Método usado somente pela JSTL, para exibir o status formatado do usuário
	 * 
	 * @return
	 */
	public String getAtivoFormat() {
		if(this.ativo == CD_ATIVO_TRUE)
			return "SIM";
		if(this.ativo == CD_ATIVO_FALSE)
			return "NÃO";
		return "";
	}
	
	/**
	 * Método usado somente pela JSTL, para retornar se o usuário está
	 * habilitado
	 * 
	 * @return
	 */
	public boolean isHabilitado() {
		return this.ativo == CD_ATIVO_TRUE;
	}
}
