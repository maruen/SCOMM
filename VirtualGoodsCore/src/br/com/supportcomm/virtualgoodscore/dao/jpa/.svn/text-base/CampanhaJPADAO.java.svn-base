package br.com.supportcomm.virtualgoodscore.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.supportcomm.virtualgoodscore.dao.CampanhaDAO;
import br.com.supportcomm.virtualgoodscore.pojo.Campanha;

public class CampanhaJPADAO implements CampanhaDAO {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	public CampanhaJPADAO() {
		super();
	}
	
	@Override
	public Campanha findById(long id) {
		return entityManager.find(Campanha.class, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Campanha> findAll() {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(Campanha.class);
		crit.addOrder(Order.asc(CAMPO_DESCRIPTION));
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return crit.list();
	}
	
	@Override
	public void delete(Campanha entity) {
		Object c = entityManager.merge(entity);
		entityManager.remove(c);
	}
	
	@Override
	public void save(Campanha entity) {
		entityManager.persist(entity);
	}

	@Override
	public void update(Campanha entity) {
		entityManager.merge(entity);
	}

	@Override
	public Campanha findByKeyword(String nome) {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(Campanha.class);
		crit.add(Restrictions.ilike(CAMPO_KEYWORD, nome, MatchMode.EXACT));
		Object obj = crit.uniqueResult();
		if(obj == null) {
			return null;
		}
		
		return (Campanha) obj;
	}	
}
