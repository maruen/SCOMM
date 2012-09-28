package br.com.supportcomm.virtualgoodscore.dao;

import java.util.List;

import br.com.supportcomm.virtualgoodscore.pojo.Keycode;

public interface KeycodeDAO {
	
	public static final String CAMPO_NOME = "nome";
	public static final String CAMPO_PARCEIRO_ID = "parceiro.id";
	public static final String CAMPO_ATIVO = "ativo";

	/**
	 * Busca por ID
	 * 
	 * @param id
	 * @return
	 */
	public Keycode findById(long id);

    /**
     * Busca todos
     * 
     * @return
     */
    public List<Keycode> findAll();

    
    public void save(Keycode entity);

    public void update(Keycode entity);
    
    /**
     * Remove
     * 
     * @param entity
     */
    public void delete(Keycode entity);
	
    public Keycode findByNome(String nome);
    
    public List<Keycode> findByParceiro(long idParceiro, int ativo);
}
