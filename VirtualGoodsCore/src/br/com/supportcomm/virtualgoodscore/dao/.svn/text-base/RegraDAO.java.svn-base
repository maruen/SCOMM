package br.com.supportcomm.virtualgoodscore.dao;

import java.util.List;

import br.com.supportcomm.virtualgoodscore.pojo.Regra;

public interface RegraDAO {
	
	public static final String CAMPO_NOME = "nome";
	public final static String CAMPO_ATIVO = "ativo";
	public static final String CAMPO_PARCEIRO_ID = "parceiro.id";
	public static final String CAMPO_LA_ID = "la.id";
	public static final String CAMPO_KEYCODE_ID = "keycode.id";

	
	public Regra findById(long id);
    public List<Regra> findAll();
    public List<Regra> findAll(int ativo);
    public List<Regra> findByParceiroOrLAOrKeycode(long idParceiro, long idLa, long idKeycode);
    public Regra findByKeycode(long idKeycode);
    public void save(Regra entity);
    public void update(Regra entity);
    public void delete(Regra entity);
    public Regra findByNome(String nome);
	
}
