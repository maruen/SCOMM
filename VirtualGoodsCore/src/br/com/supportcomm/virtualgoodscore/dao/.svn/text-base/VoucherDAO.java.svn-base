package br.com.supportcomm.virtualgoodscore.dao;

import java.util.List;

import br.com.supportcomm.virtualgoodscore.pojo.Voucher;

/**
 * 
 * @author maruen.mehana
 *
 */

public interface VoucherDAO {

	public Voucher findById(Long id);
	public List<Voucher> findAll();
	public void save(Voucher entity);
	public void update(Voucher entity);
	public void delete(Voucher entity);
	public List<Voucher> getRecordsToSendVoucher();
	public Integer isConsumed(String voucherCode, String msisdn); 
	
}
