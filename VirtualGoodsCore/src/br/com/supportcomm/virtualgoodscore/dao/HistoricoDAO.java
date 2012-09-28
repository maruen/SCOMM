package br.com.supportcomm.virtualgoodscore.dao;

import java.util.List;

import br.com.supportcomm.virtualgoodscore.constantes.MessageStatus;
import br.com.supportcomm.virtualgoodscore.constantes.StatusType;
import br.com.supportcomm.virtualgoodscore.pojo.Historico;
import br.com.supportcomm.virtualgoodscore.pojo.Mensagem;

public interface HistoricoDAO {
	
	public static final String CAMPO_MENSAGEM_ID 		= 	"mensagem.id";
	public static final String CAMPO_DATA_CRIACAO 	= 	"dtCriacao";

	
	public Historico findById(long id);
	public List<Historico> findAll();
	public void save(Historico entity);
	public void update(Historico entity);
	public void delete(Historico entity);
	public List<Historico> findByStatusTypeAndMessageStatus(Mensagem msg, StatusType statusType,  MessageStatus messageStatus);
	public List<Historico> findByStatusType(Mensagem msg, StatusType statusType);
	public List<Historico> findByMensagem(long idMensagem);
	public Long getFlowTotalTime(long idMensagem);
}
