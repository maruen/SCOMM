package br.com.supportcomm.virtualgoodscore.dao;

import java.util.List;

import br.com.supportcomm.virtualgoodscore.pojo.Campanha;

public interface CampanhaDAO {
	
	public static final String CAMPO_DESCRIPTION = "description";
	public static final String CAMPO_KEYWORD = "keyword";
	public static final String CAMPO_ID = "id";
	public static final String CAMPO_REGRA_LA_ID = "regra.la.id";
	public static final String CAMPO_REGRA_KEYCODE_ID = "regra.keycode.id";
	
	public Campanha findById(long id);
    public List<Campanha> findAll();
    public void save(Campanha entity);
    public void update(Campanha entity);
    public void delete(Campanha entity);
    public Campanha findByKeyword(String keyword);
	
}
