package br.com.supportcomm.virtualgoodscore.dao;

import java.util.List;

import br.com.supportcomm.virtualgoodscore.pojo.Sharecode;

public interface SharecodeDAO {
	
	public static final String CAMPO_NOME = "nome";
	public static final String CAMPO_OPERADORA = "operadora";
	public static final String CAMPO_ATIVO = "ativo";
	public static final String CAMPO_TARIFACAO = "tarifacao";
	
	/**
	 * Busca por ID
	 * 
	 * @param id
	 * @return
	 */
	public Sharecode findById(long id);

    /**
     * Busca todos
     * 
     * @return
     */
    public List<Sharecode> findAll();

   
    public void save(Sharecode entity);

    public void update(Sharecode entity);
    
    /**
     * Remove
     * 
     * @param entity
     */
    public void delete(Sharecode entity);
    
    public Sharecode findByNomeAndOperadora(String nome, int operadora);
    
    public List<Sharecode> findByOperadora(int operadora, int ativo);
    
    public List<Sharecode> findByTarifacaoAndOperadora(double tarifacao, int operadora, int ativo);
}
