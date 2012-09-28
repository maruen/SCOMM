package br.com.supportcomm.virtualgoodscore.dao;

import java.util.List;

import br.com.supportcomm.virtualgoodscore.pojo.LoggerMessage;

/**
 * 
 * @author maruen.mehana
 *
 */


public interface LoggerMessageDAO {

	public LoggerMessage findById(Integer id);
	public LoggerMessage findByShortcode(String shortcode);
	public String getMessageByShortcode(String shortcode, Object... args);
	public String getMessageById(Integer id, Object... args);
	public List<LoggerMessage> findAll();
	public void save(LoggerMessage entity);
	public void update(LoggerMessage entity);
	public void delete(LoggerMessage entity);
	
}
