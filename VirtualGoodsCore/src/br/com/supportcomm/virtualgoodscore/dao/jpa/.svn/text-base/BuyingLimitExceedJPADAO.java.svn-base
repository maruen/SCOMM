package br.com.supportcomm.virtualgoodscore.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.supportcomm.virtualgoodscore.dao.BuyingLimitExceedDAO;
import br.com.supportcomm.virtualgoodscore.pojo.BuyingLimitExceed;

/**
 * 
 * @author maruen.mehana
 *
 */

public class BuyingLimitExceedJPADAO implements BuyingLimitExceedDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	public BuyingLimitExceedJPADAO(){
		super();
	}
	
	@Override
	public BuyingLimitExceed findById(Long id) {
		return entityManager.find(BuyingLimitExceed.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BuyingLimitExceed> findAll() {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(BuyingLimitExceed.class);
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return crit.list();
		
	}

	@Override
	public void save(BuyingLimitExceed entity) {
		entityManager.persist(entity);
	}

	@Override
	public void update(BuyingLimitExceed entity) {
		entityManager.merge(entity);
		
	}

	@Override
	public void delete(BuyingLimitExceed entity) {
		Object obj = entityManager.merge(entity);
		entityManager.remove(obj);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<BuyingLimitExceed> getRocordsToSendMT() {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(BuyingLimitExceed.class);
		crit.add(Restrictions.eq("smsMtSent", 0));
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return crit.list();
	}

}
