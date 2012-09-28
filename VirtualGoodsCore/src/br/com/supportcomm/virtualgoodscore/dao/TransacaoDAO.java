package br.com.supportcomm.virtualgoodscore.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import br.com.supportcomm.virtualgoodscore.constantes.TransactionStatus;
import br.com.supportcomm.virtualgoodscore.pojo.Transacao;

public interface TransacaoDAO {

	public static final String CAMPO_STATUS 			= "statusTransacao";
	public static final String CAMPO_SCHEDULE 		= "dtSchedule";
	public static final String CAMPO_DATA_TRANSACAO 	= "dtTransacao";
	public static final String CAMPO_MENSAGEM_ID 		= "mensagem.id";
	public static final String CAMPO_MSISDN 			= "msisdn";

	public Transacao findById(long id);
	public List<Transacao> findAll();
	public void save(Transacao entity);
	public void update(Transacao entity);
	public void delete(Transacao entity);
	public List<Transacao> findByScheduleAndStatus(Date data, TransactionStatus... listStatus);
	public List<Transacao> findByStatus(TransactionStatus status);
	public List<Transacao> getAllNotFinished();
	public Transacao findByMensagem(long idMensagem);
	public HashMap<String,Object> findByDateAndMsisdn(Date dtInicial, Date dtFinal, String msisdn, Integer perPage, Integer pageNumber);
	public Transacao findLastByMsisdnAndStatus(String msisdn, TransactionStatus status); 
	public List<Transacao> findAllByMsisdnAndStatus(String msisdn, TransactionStatus status);
}
