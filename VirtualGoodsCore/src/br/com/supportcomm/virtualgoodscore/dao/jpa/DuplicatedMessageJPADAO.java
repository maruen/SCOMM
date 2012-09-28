package br.com.supportcomm.virtualgoodscore.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.supportcomm.virtualgoodscore.dao.DuplicatedMessageDAO;
import br.com.supportcomm.virtualgoodscore.pojo.DuplicatedMessage;

public class DuplicatedMessageJPADAO implements DuplicatedMessageDAO {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	public DuplicatedMessageJPADAO() {
		super();
	}

	@Override
	public void delete(DuplicatedMessage entity) {
		Object c = entityManager.merge(entity);
		entityManager.remove(c);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<DuplicatedMessage> findAll() {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(DuplicatedMessage.class);
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return crit.list();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DuplicatedMessage> getRecordsToSendMT() {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(DuplicatedMessage.class);
		crit.add(Restrictions.eq("smsMtSent", 0));
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return crit.list();
	}
	

	@Override
	public DuplicatedMessage findById(long id) {
		return entityManager.find(DuplicatedMessage.class, id);
	}

	@Override
	public void save(DuplicatedMessage entity) {
		entityManager.persist(entity);
	}

	@Override
	public void update(DuplicatedMessage entity) {
		entityManager.merge(entity);
	}
	
	
}