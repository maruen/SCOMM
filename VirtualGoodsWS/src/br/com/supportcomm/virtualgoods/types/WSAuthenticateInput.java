package br.com.supportcomm.virtualgoods.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class WSAuthenticateInput {

	@XmlElement(required = true ) 	private String voucherWSLogin;
	@XmlElement(required = true )	private String voucherWSPasswd;
	
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
