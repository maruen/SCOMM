package br.com.supportcomm.virtualgoodscore.dao;

import java.util.List;

import br.com.supportcomm.virtualgoodscore.pojo.BuyConfig;

/**
 * 
 * @author maruen.mehana
 *
 */

public interface BuyConfigDAO {

	public BuyConfig findConfigByOperadora(Integer id);
	public List<BuyConfig> findAll();
	public void saveOrUpdate(BuyConfig entity);
	public void delete(BuyConfig entity);

}
