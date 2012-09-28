package br.com.supportcomm.virtualgoodscore.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.supportcomm.virtualgoodscore.dao.VoucherDAO;
import br.com.supportcomm.virtualgoodscore.pojo.Voucher;

/**
 * 
 * @author maruen.mehana
 *
 */

public class VoucherJPADAO implements VoucherDAO {

	@PersistenceContext
	private EntityManager entityManager;

	
	public VoucherJPADAO(){
		super();
	}
	
	@Override
	public Voucher findById(Long id) {
		return entityManager.find(Voucher.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Voucher> findAll() {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(Voucher.class);
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return crit.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Voucher> getRecordsToSendVoucher() {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(Voucher.class);
		crit.add(Restrictions.eq("voucherMTSent", 0));
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return crit.list();
	}

	@Override
	public void save(Voucher entity) {
		entityManager.persist(entity);
	}

	@Override
	public void update(Voucher entity) {
		entityManager.merge(entity);
	}

	@Override
	public void delete(Voucher entity) {
		Object obj = entityManager.merge(entity);
		entityManager.remove(obj);
	}

	@Override
	public Integer isConsumed(String voucherCode, String msisdn) {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(Voucher.class);
		crit.add(Restrictions.eq("voucherMTSent", 0));
		Voucher voucher = (Voucher) crit.uniqueResult();
		
		if (voucher == null) {
			return 3;
		} else if (voucher.getIsConsumed() == 1) {
			return 1;
		} else {
			return 0;
		}
		
	}

	

}
