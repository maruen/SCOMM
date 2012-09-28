package br.com.supportcomm.virtualgoodscore.dao;

import java.util.List;

import br.com.supportcomm.virtualgoodscore.pojo.BillingRecordSuccess;

/**
 * 
 * @author maruen.mehana
 *
 */

public interface BillingRecordSuccessDAO {

	public BillingRecordSuccess findById(Long id);
	public List<BillingRecordSuccess> findAll();
	public List<BillingRecordSuccess> getRecordsToSendProtocol();
	public void save(BillingRecordSuccess entity);
	public void update(BillingRecordSuccess entity);
	public void delete(BillingRecordSuccess entity);
	public Double getBuyingSumByCurrentMonth(String msisdn);
	public Double getBuyingSumByDaysBeforeCurrent(String msisdn, Integer numberOfDays);
	public long getProtocolNumber();

}
