package br.com.supportcomm.virtualgoodscore.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.supportcomm.virtualgoodscore.dao.LoggerMessageDAO;
import br.com.supportcomm.virtualgoodscore.pojo.LoggerMessage;

/**
 * 
 * @author maruen.mehana
 *
 */


public class LoggerMessageJPADAO implements LoggerMessageDAO {

	@PersistenceContext
	EntityManager entityManager;
	
	public LoggerMessageJPADAO() {
		super();
	}
	
	@Override
	public LoggerMessage findById(Integer id) {
		return entityManager.find(LoggerMessage.class, new Long(id));
		
	}
	
	@Override
	public String getMessageById(Integer id, Object... args) {
		LoggerMessage loggerMessage = findById(id);
		String msg = (loggerMessage!=null)?loggerMessage.getMessage():"";
		return replaceArguments(msg, args); 
	}
	
	@Override
	public String getMessageByShortcode(String shortcode, Object... args) {
		LoggerMessage loggerMessage = findByShortcode(shortcode);
		String msg = (loggerMessage!=null)?loggerMessage.getMessage():"";
		return replaceArguments(msg, args); 
	}
	

	private String replaceArguments(String msg, Object... args) {
		for (Object obj : args) {
			if ( obj instanceof String) { 
				msg = msg.replaceFirst("%s", (String)obj);
			} else if ( obj instanceof Float ) {
				Float value = (Float) obj;
				msg = msg.replaceFirst("%f", value.toString());
			} else if ( obj instanceof Double ) {
				Double value = (Double) obj;
				msg = msg.replaceFirst("%d", value.toString());
			} else if ( obj instanceof Integer ) {
				Integer value = (Integer) obj;
				msg = msg.replaceFirst("%i", value.toString());
			} else if ( obj != null ){
				msg = msg.replaceFirst("%s", obj.toString());
			}
		}
		return msg;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<LoggerMessage> findAll() {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(LoggerMessage.class);
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return crit.list();
	}

	@Override
	public LoggerMessage findByShortcode(String shortcode) {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(LoggerMessage.class);
		crit.add(Restrictions.eq("shortcode", shortcode));
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return (LoggerMessage) crit.uniqueResult();
	}
	
	
	@Override
	public void save(LoggerMessage entity) {
		entityManager.persist(entity);

	}

	@Override
	public void update(LoggerMessage entity) {
		entityManager.merge(entity);
	}

	@Override
	public void delete(LoggerMessage entity) {
		Object obj = entityManager.merge(entity);
		entityManager.remove(obj);
	}

}
