package br.com.supportcomm.virtualgoodscore.dao.jpa;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.supportcomm.virtualgoodscore.constantes.TransactionStatus;
import br.com.supportcomm.virtualgoodscore.dao.TransacaoDAO;
import br.com.supportcomm.virtualgoodscore.pojo.Transacao;

public class TransacaoJPADAO implements TransacaoDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public TransacaoJPADAO() {
		super();
	}

	@Override
	public void delete(Transacao entity) {
		Object c = entityManager.merge(entity);
		entityManager.remove(c);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Transacao> findAll() {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(Transacao.class);
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return crit.list();
	}

	@Override
	public Transacao findById(long id) {
		return entityManager.find(Transacao.class, id);
	}

	@Override
	public void save(Transacao entity) {
		entityManager.persist(entity);
	}

	@Override
	public void update(Transacao entity) {
		entityManager.merge(entity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Transacao> findByStatus(TransactionStatus transactionStatus) {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(Transacao.class);
		crit.add(Restrictions.eq("transactionStatus", transactionStatus));
		return crit.list();
	}
	
	
	@Override
	public Transacao findLastByMsisdnAndStatus(String msisdn, TransactionStatus transactionStatus) {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(Transacao.class);
		crit.add(Restrictions.eq("transactionStatus", transactionStatus));
		crit.add(Restrictions.eq(CAMPO_MSISDN, msisdn));
		crit.addOrder(Order.desc(CAMPO_DATA_TRANSACAO));
		crit.setMaxResults(1);
		Object obj = crit.uniqueResult();
		if(obj != null) {
			return (Transacao) obj;
		}
		return null;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Transacao> findAllByMsisdnAndStatus(String msisdn, TransactionStatus transactionStatus) {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(Transacao.class);
		crit.add(Restrictions.eq("transactionStatus", transactionStatus));
		crit.add(Restrictions.eq(CAMPO_MSISDN, msisdn));
		crit.addOrder(Order.desc(CAMPO_DATA_TRANSACAO));
		return crit.list();
		
	}
	
	

	@Override
	@SuppressWarnings("unchecked")
	public List<Transacao> findByScheduleAndStatus(Date data,	TransactionStatus... listStatus) {

		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(Transacao.class);
		
		Disjunction ou = Restrictions.disjunction();
		for(TransactionStatus transactionStatus: listStatus) {
			ou.add(Restrictions.eq("transactionStatus", transactionStatus));
		}		
		crit.add(ou);
		
		crit.add(Restrictions.le(CAMPO_SCHEDULE, data)); 
		crit.addOrder(Order.asc(CAMPO_SCHEDULE));		
		return crit.list();
	}

	@Override
	public Transacao findByMensagem(long idMensagem) {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(Transacao.class);
		crit.add(Restrictions.eq(CAMPO_MENSAGEM_ID, idMensagem));
		Object obj = crit.uniqueResult();
		if(obj == null)
			return null;
		
		return (Transacao) obj;
	}

	@Override
	public HashMap<String,Object> findByDateAndMsisdn(Date dtInicial,
											   Date dtFinal,
											   String msisdn,
											   Integer perPage,
											   Integer displayStart) {
		
		HashMap<String,Object> hash = new HashMap<String,Object>();
		
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(Transacao.class);
		
		
		
		if(dtInicial != null && dtFinal != null) {
			
			Calendar cal = Calendar.getInstance();
			cal.setTime(dtFinal);
			cal.add(Calendar.DAY_OF_MONTH, 1);
			
			crit.add(Restrictions.between(CAMPO_DATA_TRANSACAO, dtInicial, cal.getTime()));
		}
		
		if(msisdn != null && !msisdn.isEmpty()) {
			crit.add(Restrictions.eq(CAMPO_MSISDN, msisdn));
		}
		
		hash.put("size",crit.list().size());
		
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		crit.addOrder(Order.desc(CAMPO_DATA_TRANSACAO));
		crit.setMaxResults(perPage);
		crit.setFirstResult(displayStart);
		
		hash.put("list", crit.list());
		
		return hash;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Transacao> getAllNotFinished() {
		
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(Transacao.class);
		crit.add(Restrictions.ne("transactionStatus", TransactionStatus.TRANSACTION_FINISHED));
		crit.addOrder(Order.desc(CAMPO_DATA_TRANSACAO));
		return crit.list();
	}

}
