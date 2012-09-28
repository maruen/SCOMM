package br.com.supportcomm.virtualgoodscore.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;

import br.com.supportcomm.virtualgoodscore.dao.VGFlowDAO;
import br.com.supportcomm.virtualgoodscore.pojo.VGFlow;

/**
 * 
 * @author maruen.mehana
 *
 */

public class VGFlowJPADAO implements VGFlowDAO {

	@PersistenceContext
	private EntityManager entityManager;

	
	public VGFlowJPADAO(){
		super();
	}
	
	@Override
	public VGFlow findById(Long id) {
		return entityManager.find(VGFlow.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VGFlow> findAll() {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(VGFlow.class);
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return crit.list();
		
	}

	@Override
	public void save(VGFlow entity) {
		entityManager.persist(entity);
	}

	@Override
	public void update(VGFlow entity) {
		entityManager.merge(entity);
		
	}

	@Override
	public void delete(VGFlow entity) {
		Object obj = entityManager.merge(entity);
		entityManager.remove(obj);
		
	}

}
