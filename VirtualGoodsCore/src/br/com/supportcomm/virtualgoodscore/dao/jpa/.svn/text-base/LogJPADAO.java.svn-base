package br.com.supportcomm.virtualgoodscore.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;

import br.com.supportcomm.virtualgoodscore.dao.LogDAO;
import br.com.supportcomm.virtualgoodscore.pojo.Log;

public class LogJPADAO implements LogDAO {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	public LogJPADAO() {
		super();
	}

	@Override
	public void delete(Log entity) {
		Object c = entityManager.merge(entity);
		entityManager.remove(c);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Log> findAll() {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(Log.class);
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return crit.list();
	}

	@Override
	public Log findById(long id) {
		return entityManager.find(Log.class, id);
	}

	@Override
	public void save(Log entity) {
		entityManager.persist(entity);
	}

	@Override
	public void update(Log entity) {
		entityManager.merge(entity);
	}
	
}