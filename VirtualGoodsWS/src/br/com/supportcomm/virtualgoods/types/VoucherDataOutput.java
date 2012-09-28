package br.com.supportcomm.virtualgoods.types;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import br.com.supportcomm.virtualgoods.enums.VoucherStatus;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class VoucherDataOutput {
	
	private Date 			ConsumptionDate;
	private VoucherStatus 	voucherStatus;
	private Date 			purchaseDate;
	
	public Date getConsumptionDate() {
		return ConsumptionDate;
	}
	public void setConsumptionDate(Date consumptionDate) {
		ConsumptionDate = consumptionDate;
	}
	public VoucherStatus getVoucherStatus() {
		return voucherStatus;
	}
	public void setVoucherStatus(VoucherStatus voucherStatus) {
		this.voucherStatus = voucherStatus;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	

}
