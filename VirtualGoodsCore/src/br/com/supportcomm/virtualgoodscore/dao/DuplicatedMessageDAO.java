package br.com.supportcomm.virtualgoodscore.dao;

import java.util.List;

import br.com.supportcomm.virtualgoodscore.pojo.DuplicatedMessage;


/**
 * 
 * @author maruen.mehana
 *
 */


public interface DuplicatedMessageDAO {
	
	public DuplicatedMessage findById(long id);
    public List<DuplicatedMessage> findAll();
    public void save(DuplicatedMessage entity);
    public void update(DuplicatedMessage entity);
    public void delete(DuplicatedMessage entity);
    public List<DuplicatedMessage> getRecordsToSendMT(); 
	
}
