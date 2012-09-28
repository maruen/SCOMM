package br.com.supportcomm.virtualgoodscore.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.supportcomm.virtualgoodscore.dao.ConfigDAO;
import br.com.supportcomm.virtualgoodscore.pojo.Config;

/**
 * 
 * @author maruen.mehana
 *
 */

public class ConfigJPADAO implements ConfigDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	public ConfigJPADAO(){
		super();
	}
	
	@Override
	public Config findById(Long id) {
		return entityManager.find(Config.class, id);
	}
	
	@Override
	public String findByName(String name) {
		Session session =(Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(Config.class);
		crit.add(Restrictions.eq("name", name));
		Config config = (Config) crit.uniqueResult();
		if (config != null && config.getValue() != null) {
			return config.getValue();
		}
		
		return "";
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Config> findAll() {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(Config.class);
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		crit.addOrder(Order.asc("id"));
		return crit.list();
		
	}

	@Override
	public void save(Config entity) {
		entityManager.persist(entity);
	}

	@Override
	public void update(Config entity) {
		entityManager.merge(entity);
		
	}

	@Override
	public void delete(Config entity) {
		Object obj = entityManager.merge(entity);
		entityManager.remove(obj);
		
	}

	
}
