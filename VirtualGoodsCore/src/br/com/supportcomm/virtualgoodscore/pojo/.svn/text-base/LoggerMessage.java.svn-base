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
@Table ( name = "logger_message")
public class LoggerMessage implements Serializable {

	
	private static final long serialVersionUID = 2182320046483012041L;
	
	@Id
	@Column( name = "id_message")		private Long 	idMessage;
	@Column( name = "string_message")	private String message;
	@Column( name = "shortcode")		private String shortcode;

	public Long getIdMessage() {
		return idMessage;
	}
	public void setIdMessage(Long idMessage) {
		this.idMessage = idMessage;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getShortcode() {
		return shortcode;
	}
	public void setShortcode(String shortcode) {
		this.shortcode = shortcode;
	}

}
