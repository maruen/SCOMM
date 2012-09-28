package br.com.supportcomm.virtualgoodscore.pojo;

import java.io.Serializable;

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
@Table(name = "operadora")
public class Operadora implements Serializable{

	private static final long serialVersionUID = 5335099388977508517L;
	
	@Id
	@Column(name = "cd_operadora")	private Integer codigoOperadora;
	@Column(name = "nm_operadora")	private String 	nomeOperadora;
	
	public Operadora(Integer codigoOperadora, String nomeOperadora) {
		super();
		this.codigoOperadora = codigoOperadora;
		this.nomeOperadora = nomeOperadora;
	}
	
	public Integer getCodigoOperadora() {
		return codigoOperadora;
	}
	public void setCodigoOperadora(Integer codigoOperadora) {
		this.codigoOperadora = codigoOperadora;
	}
	public String getNomeOperadora() {
		return nomeOperadora;
	}
	public void setNomeOperadora(String nomeOperadora) {
		this.nomeOperadora = nomeOperadora;
	}
	
	
	
}
