package br.com.supportcomm.virtualgoodscore.dao;

import java.util.List;

import br.com.supportcomm.virtualgoodscore.pojo.LA;

public interface LADAO {
	
	public final static String CAMPO_NOME = "nome";
	public final static String CAMPO_ATIVO = "ativo";
	
	/**
	 * Busca por ID
	 * 
	 * @param id
	 * @return
	 */
	public LA findById(long id);

    /**
     * Busca todos
     * 
     * @return
     */
    public List<LA> findAll();
    
	/**
	 * Busca todos, com o status ativo passado no parametro
	 * 
	 * @return
	 */
	public List<LA> findAll(int ativo);

    
    public void save(LA entity);

    public void update(LA entity);
    
    /**
     * Remove
     * 
     * @param entity
     */
    public void delete(LA entity);
    
    /**
     * Busca LA por nome
     * 
     * @param nome
     * @return
     */
    public LA findByNome(String nome);

}
