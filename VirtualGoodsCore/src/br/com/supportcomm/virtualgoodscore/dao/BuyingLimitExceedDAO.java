package br.com.supportcomm.virtualgoodscore.dao;

import java.util.List;

import br.com.supportcomm.virtualgoodscore.pojo.BuyingLimitExceed;

/**
 * 
 * @author maruen.mehana
 *
 */

public interface BuyingLimitExceedDAO {

	public BuyingLimitExceed findById(Long id);
	public List<BuyingLimitExceed> findAll();
	public void save(BuyingLimitExceed entity);
	public void update(BuyingLimitExceed entity);
	public void delete(BuyingLimitExceed entity);
	public List<BuyingLimitExceed> getRocordsToSendMT();

}
