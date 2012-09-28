package br.com.supportcomm.virtualgoodscore.dao;

import java.util.List;

import br.com.supportcomm.virtualgoodscore.pojo.Operadora;

/**
 * 
 * @author maruen.mehana
 *
 */

public interface OperadoraDAO {
	
	public Operadora findById(Long id);
	public String getCarrierById(String id);
	public List<Operadora> findAll();
	public void save(Operadora entity);
	public void update(Operadora entity);
	public void delete(Operadora entity);

}
