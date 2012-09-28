package br.com.supportcomm.virtualgoodscore.dao;

import java.util.List;

import br.com.supportcomm.virtualgoodscore.pojo.MensagemResposta;

public interface MensagemRespostaDAO {
	
	public static final String CAMPO_MENSAGEM_ID = "msg.id";
	public MensagemResposta findById(long id);
    public List<MensagemResposta> findAll();
    public void save(MensagemResposta entity);
    public void update(MensagemResposta entity);
    public void delete(MensagemResposta entity);
    public MensagemResposta findByMensagem(long idMensagem);
}
