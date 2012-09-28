package br.com.supportcomm.virtualgoodscore.dao;

import java.util.List;

import br.com.supportcomm.virtualgoodscore.pojo.TipoCampanha;

public interface TipoCampanhaDAO {
	
	public static final String CAMPO_SIGLA = "sigla";
	public static final String CAMPO_ATIVO = "ativo";
	
	/**
	 * Busca por ID
	 * 
	 * @param id
	 * @return
	 */
	public TipoCampanha findById(long id);

    /**
     * Busca todos
     * 
     * @return
     */
    public List<TipoCampanha> findAll();
    
    public List<TipoCampanha> findAll(int ativo);

    public void save(TipoCampanha entity);

    public void update(TipoCampanha entity);
    
    /**
     * Remove
     * 
     * @param entity
     */
    public void delete(TipoCampanha entity);
    
    public TipoCampanha findBySigla(String sigla);

}
