package br.com.supportcomm.virtualgoodscore.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.supportcomm.virtualgoodscore.dao.BillingRecordFailureDAO;
import br.com.supportcomm.virtualgoodscore.pojo.BillingRecordFailure;

/**
 * 
 * @author maruen.mehana
 *
 */

public class BillingRecordFailureJPADAO implements BillingRecordFailureDAO {

	@PersistenceContext
	private EntityManager entityManager;

	
	public BillingRecordFailureJPADAO(){
		super();
	}
	
	@Override
	public BillingRecordFailure findById(Long id) {
		return entityManager.find(BillingRecordFailure.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BillingRecordFailure> findAll() {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(BillingRecordFailure.class);
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return crit.list();
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<BillingRecordFailure> getRecordsToSendFailureMessage() {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(BillingRecordFailure.class);
		crit.add(Restrictions.eq("msgFailureSent", 0));
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return crit.list();
		
	}

	@Override
	public void save(BillingRecordFailure entity) {
		entityManager.persist(entity);
	}

	@Override
	public void update(BillingRecordFailure entity) {
		entityManager.merge(entity);
		
	}

	@Override
	public void delete(BillingRecordFailure entity) {
		Object obj = entityManager.merge(entity);
		entityManager.remove(obj);
		
	}

}
