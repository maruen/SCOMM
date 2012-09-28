package br.com.supportcomm.virtualgoodscore.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.supportcomm.virtualgoodscore.dao.KeycodeDAO;
import br.com.supportcomm.virtualgoodscore.pojo.Keycode;

public class KeycodeJPADAO implements KeycodeDAO {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	public KeycodeJPADAO() {
		super();
	}

	@Override
	public void delete(Keycode entity) {
		Object c = entityManager.merge(entity);
		entityManager.remove(c);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Keycode> findAll() {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(Keycode.class);
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return crit.list();
	}

	@Override
	public Keycode findById(long id) {
		return entityManager.find(Keycode.class, id);
	}

	@Override
	public void save(Keycode entity) {
		entityManager.persist(entity);
	}

	@Override
	public void update(Keycode entity) {
		entityManager.merge(entity);
	}

	@Override
	public Keycode findByNome(String nome) {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(Keycode.class);
		crit.add(Restrictions.ilike(CAMPO_NOME, nome, MatchMode.EXACT));
		Object obj = crit.uniqueResult();
		if(obj == null)
			return null;
		
		return (Keycode) obj;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Keycode> findByParceiro(long idParceiro, int ativo) {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(Keycode.class);
		crit.add(Restrictions.eq(CAMPO_ATIVO, ativo));
		crit.add(Restrictions.eq(CAMPO_PARCEIRO_ID, idParceiro));
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return crit.list();
	}
	
}

