package br.com.supportcomm.virtualgoodscore.dao;

import java.util.List;

import br.com.supportcomm.virtualgoodscore.pojo.Config;

public interface ConfigDAO {

	public Config findById(Long id);
	public String findByName(String name);
	public List<Config> findAll();
	public void save(Config entity);
	public void update(Config entity);
	public void delete(Config entity);

}
