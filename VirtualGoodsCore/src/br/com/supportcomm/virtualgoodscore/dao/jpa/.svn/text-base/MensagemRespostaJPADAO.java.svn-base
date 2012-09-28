package br.com.supportcomm.virtualgoodscore.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.supportcomm.virtualgoodscore.dao.MensagemRespostaDAO;
import br.com.supportcomm.virtualgoodscore.pojo.MensagemResposta;

public class MensagemRespostaJPADAO implements MensagemRespostaDAO {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	public MensagemRespostaJPADAO() {
		super();
	}

	@Override
	public void delete(MensagemResposta entity) {
		Object c = entityManager.merge(entity);
		entityManager.remove(c);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<MensagemResposta> findAll() {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(MensagemResposta.class);
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return crit.list();
	}

	@Override
	public MensagemResposta findById(long id) {
		return entityManager.find(MensagemResposta.class, id);
	}

	@Override
	public void save(MensagemResposta entity) {
		entityManager.persist(entity);
	}

	@Override
	public void update(MensagemResposta entity) {
		entityManager.merge(entity);
	}
	
	@Override
	public MensagemResposta findByMensagem(long idMensagem) {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(MensagemResposta.class);
		crit.add(Restrictions.eq(CAMPO_MENSAGEM_ID, idMensagem));
		Object obj = crit.uniqueResult();
		if(obj == null)
			return null;
		
		return (MensagemResposta) obj;
	}
	
}