package br.com.supportcomm.virtualgoodscore.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.supportcomm.virtualgoodscore.dao.ParceiroDAO;
import br.com.supportcomm.virtualgoodscore.pojo.Parceiro;

public class ParceiroJPADAO implements ParceiroDAO {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	public ParceiroJPADAO() {
		super();
	}

	@Override
	public void delete(Parceiro entity) {
		Object c = entityManager.merge(entity);
		entityManager.remove(c);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Parceiro> findAll() {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(Parceiro.class);
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return crit.list();
	}

	@Override
	public Parceiro findById(long id) {
		return entityManager.find(Parceiro.class, id);
	}

	@Override
	public void save(Parceiro entity) {
		entityManager.persist(entity);
	}

	@Override
	public void update(Parceiro entity) {
		entityManager.merge(entity);
	}

	@Override
	public Parceiro findByNome(String nome) {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(Parceiro.class);
		crit.add(Restrictions.eq(CAMPO_NOME, nome));
		Object obj = crit.uniqueResult();
		if(obj == null)
			return null;
		
		return (Parceiro) obj;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Parceiro> findAll(int ativo) {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(Parceiro.class);
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		crit.add(Restrictions.eq(CAMPO_ATIVO, ativo));
		return crit.list();
	}
	
}
