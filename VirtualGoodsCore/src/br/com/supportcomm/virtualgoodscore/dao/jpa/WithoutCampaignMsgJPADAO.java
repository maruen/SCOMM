package br.com.supportcomm.virtualgoodscore.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.supportcomm.virtualgoodscore.dao.WithoutCampaignMsgDAO;
import br.com.supportcomm.virtualgoodscore.pojo.BuyingLimitExceed;
import br.com.supportcomm.virtualgoodscore.pojo.WithoutCampaignMsg;

/**
 * 
 * @author maruen.mehana
 *
 */

public class WithoutCampaignMsgJPADAO implements WithoutCampaignMsgDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	public WithoutCampaignMsgJPADAO(){
		super();
	}
	
	@Override
	public WithoutCampaignMsg findById(Long id) {
		return entityManager.find(WithoutCampaignMsg.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WithoutCampaignMsg> findAll() {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(BuyingLimitExceed.class);
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return crit.list();
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<WithoutCampaignMsg> getRocordsToSendMT() {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(WithoutCampaignMsg.class);
		crit.add(Restrictions.eq("smsMtSent", 0));
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return crit.list();
	}
	

	@Override
	public void save(WithoutCampaignMsg entity) {
		entityManager.persist(entity);
	}

	@Override
	public void update(WithoutCampaignMsg entity) {
		entityManager.merge(entity);
		
	}

	@Override
	public void delete(WithoutCampaignMsg entity) {
		Object obj = entityManager.merge(entity);
		entityManager.remove(obj);
		
	}

}
