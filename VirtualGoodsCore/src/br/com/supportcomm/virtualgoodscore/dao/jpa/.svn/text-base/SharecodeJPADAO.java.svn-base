package br.com.supportcomm.virtualgoodscore.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

import br.com.supportcomm.virtualgoodscore.dao.SharecodeDAO;
import br.com.supportcomm.virtualgoodscore.pojo.Sharecode;

public class SharecodeJPADAO implements SharecodeDAO {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	public SharecodeJPADAO() {
		super();
	}

	@Override
	public void delete(Sharecode entity) {
		Object c = entityManager.merge(entity);
		entityManager.remove(c);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Sharecode> findAll() {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(Sharecode.class);
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return crit.list();
	}

	@Override
	public Sharecode findById(long id) {
		return entityManager.find(Sharecode.class, id);
	}

	@Override
	public void save(Sharecode entity) {
		entityManager.persist(entity);
	}

	@Override
	public void update(Sharecode entity) {
		entityManager.merge(entity);
	}

	@Override
	public Sharecode findByNomeAndOperadora(String nome, int operadora) {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(Sharecode.class);
		crit.add(Restrictions.eq(CAMPO_NOME, nome));
		crit.add(Restrictions.eq(CAMPO_OPERADORA, operadora));
		Object obj = crit.uniqueResult();
		if(obj == null)
			return null;
		
		return (Sharecode) obj;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Sharecode> findByOperadora(int operadora, int ativo) {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(Sharecode.class);
		crit.setProjection(Projections.alias(Projections.distinct(Projections.property(CAMPO_TARIFACAO)), CAMPO_TARIFACAO));
		crit.add(Restrictions.eq(CAMPO_OPERADORA, operadora));
		crit.add(Restrictions.eq(CAMPO_ATIVO, ativo));
		crit.setResultTransformer(Transformers.aliasToBean(Sharecode.class));
		return crit.list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Sharecode> findByTarifacaoAndOperadora(double tarifacao, int operadora, int ativo) {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(Sharecode.class);
		crit.add(Restrictions.eq(CAMPO_TARIFACAO, tarifacao));
		crit.add(Restrictions.eq(CAMPO_OPERADORA, operadora));
		crit.add(Restrictions.eq(CAMPO_ATIVO, ativo));
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return crit.list();
	}
	
}
