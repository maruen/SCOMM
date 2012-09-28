package br.com.supportcomm.virtualgoodscore.dao.jpa;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.supportcomm.virtualgoodscore.constantes.MessageStatus;
import br.com.supportcomm.virtualgoodscore.constantes.StatusType;
import br.com.supportcomm.virtualgoodscore.dao.HistoricoDAO;
import br.com.supportcomm.virtualgoodscore.pojo.Historico;
import br.com.supportcomm.virtualgoodscore.pojo.Mensagem;

public class HistoricoJPADAO implements HistoricoDAO {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	public HistoricoJPADAO() {
		super();
	}

	@Override
	public void delete(Historico entity) {
		Object c = entityManager.merge(entity);
		entityManager.remove(c);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Historico> findAll() {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(Historico.class);
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return crit.list();
	}

	@Override
	public Historico findById(long id) {
		return entityManager.find(Historico.class, id);
	}

	@Override
	public void save(Historico entity) {
		entityManager.persist(entity);
	}

	@Override
	public void update(Historico entity) {
		entityManager.merge(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Historico> findByStatusTypeAndMessageStatus(Mensagem msg, StatusType statusType,  MessageStatus messageStatus) {

		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(Historico.class);
		crit.add(Restrictions.eq(CAMPO_MENSAGEM_ID, msg.getId()));
		crit.add(Restrictions.eq("messageStatus", messageStatus));
		crit.add(Restrictions.eq("statusType", statusType));
		return crit.list();
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Historico> findByStatusType(Mensagem msg, StatusType statusType) {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(Historico.class);
		crit.add(Restrictions.eq(CAMPO_MENSAGEM_ID, msg.getId()));
		crit.add(Restrictions.eq("statusType", statusType));
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return crit.list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Historico> findByMensagem(long idMensagem) {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(Historico.class);
		crit.add(Restrictions.eq(CAMPO_MENSAGEM_ID, idMensagem));
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		crit.addOrder(Order.asc(CAMPO_DATA_CRIACAO));
		return crit.list();
	}

	@Override
	public Long getFlowTotalTime(long idMensagem) {
		List<Historico> list = findByMensagem(idMensagem);
		Historico hist1 = (Historico) list.get(0);
		Historico hist2 = (Historico) list.get(list.size() -1);
		
		Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar1.setTime(hist1.getDtCriacao());
        calendar2.setTime(hist2.getDtCriacao());
        
        long milliseconds1 = calendar1.getTimeInMillis();
        long milliseconds2 = calendar2.getTimeInMillis();
        long diff = milliseconds2 - milliseconds1;
        long diffSeconds = diff / 1000;
        
		return diffSeconds;
	}
	
	
}
