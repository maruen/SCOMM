package br.com.supportcomm.virtualgoodscore.dao;

import java.util.List;

import br.com.supportcomm.virtualgoodscore.pojo.Parceiro;

public interface ParceiroDAO {
	
	public final static String CAMPO_NOME = "nome";
	public final static String CAMPO_ATIVO = "ativo";
	
	/**
	 * Busca por ID
	 * 
	 * @param id
	 * @return
	 */
	public Parceiro findById(long id);

    /**
     * Busca todos
     * 
     * @return
     */
    public List<Parceiro> findAll();
    
    public List<Parceiro> findAll(int ativo);

    public void save(Parceiro entity);

    public void update(Parceiro entity);
    
    /**
     * Remove
     * 
     * @param entity
     */
    public void delete(Parceiro entity);
    
    /**
     * Busca Parceiro por nome
     * 
     * @param nome
     * @return
     */
    public Parceiro findByNome(String nome);

}
