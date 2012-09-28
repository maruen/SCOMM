package br.com.supportcomm.virtualgoodscore.dao.jpa;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;

import br.com.supportcomm.virtualgoodscore.dao.MensagemDAO;
import br.com.supportcomm.virtualgoodscore.pojo.Mensagem;

public class MensagemJPADAO implements MensagemDAO {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyHHmmss");
	
	public MensagemJPADAO() {
		super();
	}

	@Override
	public void delete(Mensagem entity) {
		Object c = entityManager.merge(entity);
		entityManager.remove(c);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Mensagem> findAll() {
		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(Mensagem.class);
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return crit.list();
	}

	@Override
	public Mensagem findById(long id) {
		return entityManager.find(Mensagem.class, id);
	}

	@Override
	public void save(Mensagem entity)  {
		entityManager.persist(entity);
	}

	@Override
	public void update(Mensagem entity) {
		entityManager.merge(entity);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Mensagem findLastMessageByMsisdn(String msisdn) {
		StringBuffer sbf = new StringBuffer();
		sbf.append("SELECT * FROM MENSAGEM WHERE CD_MSISDN = '").append(msisdn).append("' ORDER BY DT_REQUEST DESC LIMIT 1");
		Query query =  entityManager.createNativeQuery(sbf.toString(), Mensagem.class);
        
        List<Mensagem> list = query.getResultList();
        if (list != null && list.size() > 0) {
        	return list.get(0);
        }
        return null;
	}
	

    @Override
	public HashMap<String,Object> findByDateAndMsisdn( Date 	initialDate,
											   		   Date 	finalDate,
											   		   String 	msisdn
													) {
		return findByDateAndMsisdn( initialDate,
								    finalDate,
								    msisdn,
								    null,
								    null,
								    null,
								    null);	
	}
	
	
	
	@SuppressWarnings("unchecked")
    @Override
	public HashMap<String,Object> findByDateAndMsisdn( Date 	initialDate,
											   		   Date 	finalDate,
											   		   String 	msisdn,
											   		   Integer 	perPage,
											   		   Integer 	start,
											   		   String 	sortColumn,
											   		   String 	sortDirection
													) {
		

		HashMap<String,Object> hash = new HashMap<String,Object>();
		
		StringBuffer sql1 = new StringBuffer();
		sql1.append("SELECT * FROM MENSAGEM WHERE 1=1 ");
		
		StringBuffer sql2 = new StringBuffer();
		sql2.append("SELECT COUNT(*) FROM MENSAGEM WHERE 1=1 ");
		
		StringBuffer filter = new StringBuffer();
		if (initialDate != null && finalDate != null) {
			filter.append(" AND DT_REQUEST BETWEEN TO_TIMESTAMP('").append(sdf.format(initialDate)).append("','DDMMYYYYHH24MISS')");
			filter.append(" AND TO_TIMESTAMP('").append(sdf.format(finalDate)).append("','DDMMYYYYHH24MISS')");
		}
		
		if (msisdn != null && !msisdn.isEmpty()) {
			filter.append(" AND CD_MSISDN = '").append(msisdn).append("'");
		}
		
		sql1.append(filter);
		sql2.append(filter);
		
		if (sortColumn != null && sortDirection != null ) {
			sql1.append(" ORDER BY ").append(sortColumn).append(" ").append(sortDirection); 
		}
		
		if ( start != null && perPage != null ) {
			sql1.append(" LIMIT ").append(perPage).append(" OFFSET ").append(start);
		}
		
		Query query1 =  entityManager.createNativeQuery(sql1.toString(), Mensagem.class);
		List<Mensagem> list1 =  query1.getResultList();
		hash.put("list", list1);
		
		Query query2 =  entityManager.createNativeQuery(sql2.toString());
		BigInteger  size =  (BigInteger) query2.getSingleResult();

		hash.put("size", Integer.valueOf(size.toString()));
		
		return hash;
	}
	
}