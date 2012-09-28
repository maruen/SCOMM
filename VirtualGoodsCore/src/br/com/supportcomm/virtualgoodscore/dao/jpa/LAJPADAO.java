package br.com.supportcomm.virtualgoodscore.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.supportcomm.virtualgoodscore.dao.LADAO;
import br.com.supportcomm.virtualgoodscore.pojo.LA;

public class LAJPADAO implements LADAO {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	public LAJPADAO() {
		super();
	}

	@Override
	public void delete(LA entity) {
		Object c = entityManager.merge(entity);
		entityManager.remove(c);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<LA> findAll() {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(LA.class);
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return crit.list();
	}

	@Override
	public LA findById(long id) {
		return entityManager.find(LA.class, id);
	}

	@Override
	public void save(LA entity) {
		entityManager.persist(entity);
	}

	@Override
	public void update(LA entity) {
		entityManager.merge(entity);
	}

	@Override
	public LA findByNome(String nome) {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(LA.class);
		crit.add(Restrictions.eq(CAMPO_NOME, nome));
		Object obj = crit.uniqueResult();
		if(obj == null)
			return null;
		
		return (LA) obj;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<LA> findAll(int ativo) {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(LA.class);
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		crit.add(Restrictions.eq(CAMPO_ATIVO, ativo));
		return crit.list();
	}
	
}

