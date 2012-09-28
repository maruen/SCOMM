package br.com.supportcomm.virtualgoodscore.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import br.com.supportcomm.virtualgoodscore.dao.UsuarioDAO;
import br.com.supportcomm.virtualgoodscore.pojo.Usuario;

public class UsuarioJPADAO implements
		UsuarioDAO {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	public UsuarioJPADAO() {
		super();
	}

	@Override
	public void delete(Usuario entity) {
		Object c = entityManager.merge(entity);
		entityManager.remove(c);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Usuario> findAll() {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(Usuario.class);
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return crit.list();
	}

	@Override
	public Usuario findById(long id) {
		return entityManager.find(Usuario.class, id);
	}

	@Override
	public void save(Usuario entity) {
		entityManager.persist(entity);
	}

	@Override
	public void update(Usuario entity) {
		entityManager.merge(entity);
	}

	@Override
	public Usuario findByLogin(String login) {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(Usuario.class);
		crit.add(Restrictions.eq(CAMPO_LOGIN, login));
		Object obj = crit.uniqueResult();
		if(obj == null)
			return null;
		
		return (Usuario) obj;
	}

	@Override
	public Usuario findByLoginAndSenha(String login, String senha) {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(Usuario.class);
		crit.add(Restrictions.eq(CAMPO_LOGIN, login));
		crit.add(Restrictions.eq(CAMPO_SENHA, senha));
		Object obj = crit.uniqueResult();
		if(obj == null)
			return null;
		
		return (Usuario) obj;
	}

	@Override
	public int count() {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(Usuario.class);
		crit.setProjection(Projections.rowCount());
		
		Object obj = crit.uniqueResult();
		if(obj == null)
			return 0;
		
		return (Integer) obj;
	}
}
