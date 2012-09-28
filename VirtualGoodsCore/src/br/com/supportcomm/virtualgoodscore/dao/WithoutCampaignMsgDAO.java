package br.com.supportcomm.virtualgoodscore.dao;

import java.util.List;

import br.com.supportcomm.virtualgoodscore.pojo.WithoutCampaignMsg;

/**
 * 
 * @author maruen.mehana
 *
 */

public interface WithoutCampaignMsgDAO {

	public WithoutCampaignMsg findById(Long id);
	public List<WithoutCampaignMsg> findAll();
	public void save(WithoutCampaignMsg entity);
	public void update(WithoutCampaignMsg entity);
	public void delete(WithoutCampaignMsg entity);
	public List<WithoutCampaignMsg> getRocordsToSendMT(); 

}
