package br.com.supportcomm.virtualgoodscore.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "vg_config")
public class Config implements Serializable{

	private static final long serialVersionUID = -2824653127641629836L;
	
	@Id
	@Column(name = "id")			private Long id;
	
	@Column(name = "name")			private String name;
	@Column(name = "value")			private String value;
	@Column(name = "description")	private String description;
	@Column(name = "label")			private String label;
	
	public Long getId() {
    	return id;
    }
	public void setId(Long id) {
    	this.id = id;
    }
	public String getName() {
    	return name;
    }
	public void setName(String name) {
    	this.name = name;
    }
	public String getValue() {
    	return value;
    }
	public void setValue(String value) {
    	this.value = value;
    }
	public String getDescription() {
    	return description;
    }
	public void setDescription(String description) {
    	this.description = description;
    }
	public String getLabel() {
    	return label;
    }
	public void setLabel(String label) {
    	this.label = label;
    }
	
	
}
