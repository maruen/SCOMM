package br.com.supportcomm.virtualgoodscore.dao.jpa;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;

import br.com.supportcomm.virtualgoodscore.dao.BuyConfigDAO;
import br.com.supportcomm.virtualgoodscore.pojo.BuyConfig;

/**
 * 
 * @author maruen.mehana
 *
 */

public class BuyConfigJPADAO implements BuyConfigDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	public BuyConfigJPADAO() {
		super();
	}

	@Override
	public BuyConfig findConfigByOperadora(Integer codigoOperadora) {
		return entityManager.find(BuyConfig.class, codigoOperadora);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<BuyConfig> findAll() {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(BuyConfigDAO.class);
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return crit.list();
		
	}

	@Override
	public void saveOrUpdate(BuyConfig entity) {
		Integer codOperadora = (entity != null) ? entity.getCodigoOperadora():null;
		BuyConfig conf = findConfigByOperadora(codOperadora);
		if (conf == null) {
			entity.setDtCriacao(Calendar.getInstance().getTime());
			entity.setDtAlteracao(Calendar.getInstance().getTime());
			entityManager.persist(entity);
		} else {
			entity.setDtAlteracao(Calendar.getInstance().getTime());
			entity.setDtCriacao(conf.getDtCriacao());
			entityManager.merge(entity);
		}
	}

	@Override
	public void delete(BuyConfig entity) {
		Object obj = entityManager.merge(entity);
		entityManager.remove(obj);

	}

	

}
