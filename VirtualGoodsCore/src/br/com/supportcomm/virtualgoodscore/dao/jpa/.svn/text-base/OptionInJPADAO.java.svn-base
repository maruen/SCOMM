package br.com.supportcomm.virtualgoodscore.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.supportcomm.virtualgoodscore.dao.OptionInDAO;
import br.com.supportcomm.virtualgoodscore.pojo.OptionIn;

/**
 * 
 * @author maruen.mehana
 *
 */

public class OptionInJPADAO implements OptionInDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	public OptionInJPADAO(){
		super();
	}


	@Override
	public OptionIn findById(Long id) {
		return entityManager.find(OptionIn.class, id);
	}
	
	@Override
	public OptionIn findByTransactionId(Long id) {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(OptionIn.class);
		crit.add(Restrictions.eq("idTransacao", id));
		Object obj = crit.uniqueResult();
		if(obj != null) {
			return (OptionIn) obj;
		}
		
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OptionIn> findAll() {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(OptionIn.class);
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return crit.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OptionIn> getRecordsToSendOptionIn() {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(OptionIn.class);
		crit.add(Restrictions.eq("msgOptionInSent", 0));
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return crit.list();
	}

	@Override
	public void save(OptionIn entity) {
		entityManager.persist(entity);
	}


	@Override
	public void update(OptionIn entity) {
		entityManager.merge(entity);
	}


	@Override
	public void delete(OptionIn entity) {
		Object obj = entityManager.merge(entity);
		entityManager.remove(obj);
	}
	
	
	

}
