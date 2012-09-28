package br.com.supportcomm.virtualgoodscore.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.supportcomm.virtualgoodscore.dao.OperadoraDAO;
import br.com.supportcomm.virtualgoodscore.pojo.Operadora;

/**
 * 
 * @author maruen.mehana
 *
 */

public class OperadoraJPADAO implements OperadoraDAO {

	@PersistenceContext  private EntityManager entityManager;
	
	public OperadoraJPADAO() {
		super();
	}
	
	@Override
	public Operadora findById(Long id) {
		return entityManager.find(Operadora.class, id);
	}
	
	@Override
	public String getCarrierById(String id) {
		Operadora oper = entityManager.find(Operadora.class, id);
		return (oper!=null)?oper.getNomeOperadora():null;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Operadora> findAll() {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(Operadora.class);
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return crit.list();
	}

	@Override
	public void save(Operadora entity) {
		entityManager.persist(entity);
	}

	@Override
	public void update(Operadora entity) {
		entityManager.merge(entity);
	}

	@Override
	public void delete(Operadora entity) {
		Object obj = entityManager.merge(entity);
		entityManager.remove(obj);
	}
	
	public Operadora findByName(String name) {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(Operadora.class);
		crit.add(Restrictions.ilike("codigoOperadora", name, MatchMode.EXACT));
		Object obj = crit.uniqueResult();
		if ( obj != null) {
			return (Operadora) obj;
		}
		return null;
	}
	

}
