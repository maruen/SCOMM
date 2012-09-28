package br.com.supportcomm.virtualgoodscore.dao.jpa;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.supportcomm.virtualgoodscore.dao.BillingRecordSuccessDAO;
import br.com.supportcomm.virtualgoodscore.pojo.BillingRecordSuccess;

/**
 * 
 * @author maruen.mehana
 *
 */

public class BillingRecordSuccessJPADAO implements BillingRecordSuccessDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	private Log logger = LogFactory.getLog(this.getClass());
	
	public BillingRecordSuccessJPADAO(){
		super();
	}
	
	@Override
	public BillingRecordSuccess findById(Long id) {
		return entityManager.find(BillingRecordSuccess.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BillingRecordSuccess> findAll() {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(BillingRecordSuccess.class);
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return crit.list();
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<BillingRecordSuccess> getRecordsToSendProtocol() {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(BillingRecordSuccess.class);
		crit.add(Restrictions.eq("sentProtocol", 0));
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return crit.list();
	}

	@Override
	public void save(BillingRecordSuccess entity) {
		entityManager.persist(entity);
	}

	@Override
	public void update(BillingRecordSuccess entity) {
		entityManager.merge(entity);
		
	}

	@Override
	public void delete(BillingRecordSuccess entity) {
		Object obj = entityManager.merge(entity);
		entityManager.remove(obj);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public Double getBuyingSumByCurrentMonth(String msisdn) {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(BillingRecordSuccess.class);
		crit.add(Restrictions.eq("msisdn", msisdn));
		
		
		Calendar dtBeginCal =  Calendar.getInstance();
		dtBeginCal.add(Calendar.DATE, - Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + 1);
		
		int hour 	= dtBeginCal.getActualMinimum(Calendar.HOUR);
		int minute 	= dtBeginCal.getActualMinimum(Calendar.MINUTE);
		int seconds = dtBeginCal.getActualMinimum(Calendar.SECOND);
		
		dtBeginCal.set(Calendar.HOUR_OF_DAY,hour);
		dtBeginCal.set(Calendar.MINUTE,minute);
		dtBeginCal.set(Calendar.SECOND,seconds);
		
		Date dtBegin = dtBeginCal.getTime();
		Date dtEnd 	 = Calendar.getInstance().getTime();
		
		crit.add(Restrictions.between("dtCompra", dtBegin, dtEnd));
		List<BillingRecordSuccess> list =  crit.list();

		Double sum = 0.0;
		for (BillingRecordSuccess item: list) {
			sum = sum + item.getValorCompra();
		}
		
		logger.info("getBuyingSumByCurrentMonth: Msisdn: " + msisdn + ", DtBegin: " + dtBegin + " dtEnd: " + dtEnd + " , " + "sum: " + sum );
		
		return sum;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Double getBuyingSumByDaysBeforeCurrent(String msisdn, Integer numberOfDays) {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(BillingRecordSuccess.class);
		crit.add(Restrictions.eq("msisdn", msisdn));
		
		Calendar dtStartCal =  Calendar.getInstance();
		dtStartCal.add(Calendar.DATE, - numberOfDays);
		
		int hour 	= dtStartCal.getActualMinimum(Calendar.HOUR);
		int minute 	= dtStartCal.getActualMinimum(Calendar.MINUTE);
		int seconds = dtStartCal.getActualMinimum(Calendar.SECOND);
		
		dtStartCal.set(Calendar.HOUR_OF_DAY,hour);
		dtStartCal.set(Calendar.MINUTE,minute);
		dtStartCal.set(Calendar.SECOND,seconds);
		
		Date dtBegin = dtStartCal.getTime();
		Date dtEnd 	 = Calendar.getInstance().getTime();
		
		crit.add(Restrictions.between("dtCompra", dtBegin, dtEnd));
		List<BillingRecordSuccess> list =  crit.list();
		
		Double sum = 0.0;
		for (BillingRecordSuccess item: list) {
			sum = sum + item.getValorCompra();
		}
		
		logger.info("getBuyingSumByDaysBeforeCurrent: Msisdn: " + msisdn + ", DtBegin: " + dtBegin + " dtEnd: " + dtEnd + " , " + "sum: " + sum );
		
		return sum;
	
	}

	@Override
    public long getProtocolNumber() {
		String query = "SELECT nextval('protocol_seq')";
		BigInteger protocol  =  (BigInteger) entityManager.createNativeQuery(query).getSingleResult();
		Long protocolAsLong = protocol.longValue();
		return protocolAsLong;
    }
	
	
	

}
