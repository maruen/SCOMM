package br.com.supportcomm.virtualgoodscore.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.supportcomm.virtualgoodscore.dao.TipoCampanhaDAO;
import br.com.supportcomm.virtualgoodscore.pojo.TipoCampanha;

public class TipoCampanhaJPADAO implements TipoCampanhaDAO {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	public TipoCampanhaJPADAO() {
		super();
	}

	@Override
	public void delete(TipoCampanha entity) {
		Object c = entityManager.merge(entity);
		entityManager.remove(c);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<TipoCampanha> findAll() {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(TipoCampanha.class);
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return crit.list();
	}

	@Override
	public TipoCampanha findById(long id) {
		return entityManager.find(TipoCampanha.class, id);
	}

	@Override
	public void save(TipoCampanha entity) {
		entityManager.persist(entity);
	}

	@Override
	public void update(TipoCampanha entity) {
		entityManager.merge(entity);
	}

	@Override
	public TipoCampanha findBySigla(String sigla) {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(TipoCampanha.class);
		crit.add(Restrictions.ilike(CAMPO_SIGLA, sigla, MatchMode.EXACT));
		Object obj = crit.uniqueResult();
		if(obj == null)
			return null;
		
		return (TipoCampanha) obj;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<TipoCampanha> findAll(int ativo) {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(TipoCampanha.class);
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		crit.add(Restrictions.eq(CAMPO_ATIVO, ativo));
		return crit.list();
	}
	
}

