package br.com.supportcomm.virtualgoodscore.dao;

import java.util.List;

import br.com.supportcomm.virtualgoodscore.pojo.Usuario;

public interface UsuarioDAO {	
	
	public static final String CAMPO_LOGIN = "login";
	public static final String CAMPO_SENHA = "senha";
	
	/**
	 * Busca por ID
	 * 
	 * @param id
	 * @return
	 */
	public Usuario findById(long id);

    /**
     * Busca todos
     * 
     * @return
     */
    public List<Usuario> findAll();
    
    public void save(Usuario entity);

    public void update(Usuario entity);
    
    /**
     * Remove
     * 
     * @param entity
     */
    public void delete(Usuario entity);
    
    public Usuario findByLogin(String login);

    public Usuario findByLoginAndSenha(String login, String senha);
    
    public int count();
}
