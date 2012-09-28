package br.com.supportcomm.virtualgoodscore.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.supportcomm.virtualgoodscore.dao.RegraDAO;
import br.com.supportcomm.virtualgoodscore.pojo.Regra;

public class RegraJPADAO implements RegraDAO {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	public RegraJPADAO() {
		super();
	}

	@Override
	public void delete(Regra entity) {
		Object c = entityManager.merge(entity);
		entityManager.remove(c);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Regra> findAll() {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(Regra.class);
		crit.addOrder(Order.asc(CAMPO_NOME));
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return crit.list();
	}

	@Override
	public Regra findById(long id) {
		return entityManager.find(Regra.class, id);
	}

	@Override
	public void save(Regra entity) {
		entityManager.persist(entity);
	}

	@Override
	public void update(Regra entity) {
		entityManager.merge(entity);
	}

	@Override
	public Regra findByNome(String nome) {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(Regra.class);
		crit.add(Restrictions.ilike(CAMPO_NOME, nome, MatchMode.EXACT));
		Object obj = crit.uniqueResult();
		if(obj == null)
			return null;
		
		return (Regra) obj;
	}
	
	@Override
	public Regra findByKeycode(long idKeycode) {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(Regra.class);
		crit.add(Restrictions.eq(CAMPO_KEYCODE_ID, idKeycode));
		Object obj = crit.uniqueResult();
		if(obj == null)
			return null;
		
		return (Regra) obj;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Regra> findAll(int ativo) {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(Regra.class);
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		crit.add(Restrictions.eq(CAMPO_ATIVO, ativo));
		return crit.list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Regra> findByParceiroOrLAOrKeycode(long idParceiro, long idLa, long idKeycode) {
		
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(Regra.class);
		
		if(idParceiro != 0)
			crit.add(Restrictions.eq(CAMPO_PARCEIRO_ID, idParceiro));
		if(idLa != 0)
			crit.add(Restrictions.eq(CAMPO_LA_ID, idLa));
		if(idKeycode != 0)
			crit.add(Restrictions.eq(CAMPO_KEYCODE_ID, idKeycode));		
		
		
		crit.addOrder(Order.asc(CAMPO_NOME));
		
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return crit.list();
	}
	
}