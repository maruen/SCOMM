package br.com.supportcomm.virtualgoodscore.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import br.com.supportcomm.virtualgoodscore.pojo.Mensagem;

public interface MensagemDAO {

	public static final String CAMPO_MSISDN 		= "msisdn";
	public static final String CAMPO_DATE_REQUEST 	= "request";
	
	public Mensagem findById(long id);
    public List<Mensagem> findAll();
    public void save(Mensagem entity);
    public void update(Mensagem entity);
    public void delete(Mensagem entity);
    public HashMap<String,Object> findByDateAndMsisdn(	Date 	dtInicial,
    													Date 	dtFinal,
    													String 	msisdn,
    													Integer perPage,
    													Integer pageNumber,
    													String 	sortColumn,
    													String 	sortDirection
    												  );
    
    
    public HashMap<String,Object> findByDateAndMsisdn(	Date 	dtInicial,
														Date 	dtFinal,
														String 	msisdn
    												  );
    
    public Mensagem findLastMessageByMsisdn(String msisdn);
    
  
}
