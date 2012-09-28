package br.com.supportcomm.virtualgoodscore.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import br.com.supportcomm.virtualgoodscore.constantes.MessageStatus;
import br.com.supportcomm.virtualgoodscore.constantes.StatusType;
import br.com.supportcomm.virtualgoodscore.util.DataUtil;

@Entity
public class Historico implements Serializable {

	private static final long serialVersionUID = 594928500631971007L;
	
	private transient String oliveColor = "<font color=\"#808000\">";
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "historico")
	@SequenceGenerator(name = "historico", sequenceName = "historico_seq")
	@Column(name = "id_historico")
	private long id;

	@ManyToOne
	@JoinColumn(name = "id_mensagem", nullable = false)
	private Mensagem mensagem;

	@ManyToOne
	@JoinColumn(name = "id_la", nullable = false)
	private LA la;

	@Column(name = "cd_operadora", nullable = false)
	private int operadora;

	@Column(name = "cd_msisdn", nullable = false, length = 50)
	private String msisdn;

	@Column(name = "tx_mensagem", nullable = true, length = 255)
	private String txMensagem;

	@Enumerated(EnumType.STRING)
	private StatusType statusType;
	
	@Enumerated(EnumType.STRING)
	private MessageStatus messageStatus;

	@ManyToOne
	@JoinColumn(name = "id_parceiro", nullable = true)
	private Parceiro parceiro;

	@Column(name = "vl_tarifacao", nullable = true)
	private double valorTarifacao;

	@Column(name = "nu_retentativa", nullable = true)
	private int retentativa;

	@Column(name = "dt_criacao", nullable = false)
	private Date dtCriacao;
	
	@Column(name = "url", nullable = true, length = 255)
	private String url;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Mensagem getMensagem() {
		return mensagem;
	}

	public void setMensagem(Mensagem mensagem) {
		this.mensagem = mensagem;
	}

	public LA getLa() {
		return la;
	}

	public void setLa(LA la) {
		this.la = la;
	}

	public int getOperadora() {
		return operadora;
	}

	public void setOperadora(int operadora) {
		this.operadora = operadora;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getTxMensagem() {
		return txMensagem;
	}

	public void setTxMensagem(String txMensagem) {
		this.txMensagem = txMensagem;
	}
	
	
	public String getStatusTypeLabel() {
		
		StringBuffer sbf = new StringBuffer();
		switch (this.getStatusType()) {
		
			case FLOW_START:
				sbf.append("Início de fluxo");
				break;
			
			case ASK_OPTION_IN:
				sbf.append("Envio de option in");
				break;
			
			case PROCESS_TRANSACTION:
				sbf.append("Processando transação");
				break;		
				
			case ASK_PARTNER_AUTHORIZATION:
				sbf.append("Solicitando autorização");
				break;
			
			case WAIT_PARTNER_AUTHORIZATION:
				sbf.append("Aguardando autorização");
				break;
				
			case WAIT_OPTION_IN_ANSWER:
				sbf.append("Aguardando option in");
				break;
			
			case PROCESS_BILLING:
				sbf.append("Processando billing");
				break;
			
			case PROCESS_TRANSACTION_RESPONSE:
				sbf.append("Processando envio de status");
				break;
			
			case GENERATE_VOUCHER:
				sbf.append("Gerando voucher");
				break;
			
			case SEND_OPTION_IN:
				sbf.append("Envio de Option In");
				break;
			
			case SEND_MT_MESSAGE:
				sbf.append("Envio de MT");
				break;
				
			case SEND_VOUCHER:
				sbf.append("Enviando Voucher");
				break;
				
			case FLOW_END:
				sbf.append("Fim de fluxo");
				break;
				
			default:
				sbf.append(this.getStatusType());
				break;
		}

	
		return sbf.toString();
	}
	
	
	public String getStatusLabel() {
		
		StringBuffer sbf = new StringBuffer();
		switch (this.getMessageStatus()) {
		
			case FLOW_START:
				sbf.append("Mensagem Recebida: ").append(oliveColor).append(this.getTxMensagem()).append("</font>");
				break;
		
			case BUY_LIMIT_REACHED:
				sbf.append("Limite de compras atingido: ").append(oliveColor).append(this.getTxMensagem()).append("</font>");
				break;
		
			case CAMPAIGN_NOT_FOUND:
				sbf.append("Campanha não encontrada: ").append(oliveColor).append(this.getTxMensagem()).append("</font>");
				break;
				
			case DUPLICATE:
				sbf.append("Mensagem duplicada: " ).append(oliveColor).append(this.getTxMensagem()).append("</font>");
				break;

			case ERROR:
				sbf.append("Erro: ").append(oliveColor).append(this.getTxMensagem()).append("</font>");
				break;
			
			case BILLING_SUCCESS:
				sbf.append("Billing realizado com sucesso");
				break;
				
			case VOUCHER_GENERATED:
				sbf.append("Voucher ").append(oliveColor).append(this.getTxMensagem()).append("</font>").append(" gerado com sucesso!");
				break;
				
			case VOUCHER_NOT_GENERATED:
				sbf.append("Voucher não gerado");
				break;
		
			case BIllING_FAILED:
				sbf.append("Falha no Billing: ").append(oliveColor).append(this.getTxMensagem()).append("</font>");
				break;
				
			case WAITING_OPTION_IN_ANSWER:
				sbf.append("Aguardando envio de option in");
				break;
			
			
			
			case OPTION_IN_SENT:
				sbf.append("Option in enviado: ").append(oliveColor).append(this.getTxMensagem()).append("</font>");
				break;
				
			case OPTION_IN_NOT_SENT:
				sbf.append("Falha no envio do option in");
				break;
							
			case MT_SENT:
				sbf.append("MT enviado: ").append(oliveColor).append(this.getTxMensagem()).append("</font>");
				break;
			
			case MT_NOT_SENT:
				sbf.append("Falha ao enviar MT: ").append(oliveColor).append(this.getTxMensagem()).append("</font>");
				break;
			
			case VOUCHER_SENT:
				sbf.append("Voucher enviado: ").append(oliveColor).append(this.getTxMensagem()).append("</font>");
				break;
				
			case VOUCHER_NOT_SENT:
				sbf.append("Falha no envio do voucher");
				break;
			
			
			
			case TRANSACTION_AUTHORIZED:
				sbf.append("Transação autorizada: ").append(oliveColor).append(this.getTxMensagem()).append("</font>");
				break;
		
			case TRANSACTION_FINISHED:
				sbf.append("Transação finalizada");
				break;
				
			case TRANSACTION_CANCELED:
				sbf.append("Transação cancelada.");
				break;
			
			
				
			
			case PROCESS_TRANSACTION:
				sbf.append("Transação iniciada");
				break;
				
			
				
			case WAITING_PARTNER_AUTHORIZATION:
				sbf.append("Aguardando autorização");
				break;
				
			case PROCESS_BILLING:
				sbf.append("Executando billing através do Mercuri");
				break;
				
			case TRANSACTION_RESPONSE_NOT_SENT:
				sbf.append("Falha no envio de status: ").append(oliveColor).append(this.getTxMensagem()).append("</font>");;
				break;

			case TRANSACTION_RESPONSE_SENT:
				sbf.append("Envio de status com sucesso, HttpStatus: ").append(oliveColor).append(this.getTxMensagem()).append("</font>");;
				break;
			
				
			case ASK_PARTNER_AUTHORIZATION_NOT_SENT:
				sbf.append("Falha na solicitação de autorização ao parceiro: ").append(oliveColor).append(this.getTxMensagem()).append("</font>");;
				break;
				
			case ASK_PARTNER_AUTHORIZATION_SENT:
				sbf.append("Solicitação de autorização ao parceiro com sucesso: ").append(oliveColor).append(this.getTxMensagem()).append("</font>");
				break;
			
				
			case PROCESS_TRANSACTION_RESPONSE:
				sbf.append("Realizando Post na URL: ").append(oliveColor).append("[").append(this.getTxMensagem()).append("]</font>");
				break;
			
			
			case FLOW_END:
				Integer seconds;
				try {
					seconds = Integer.parseInt(this.getTxMensagem());
				} catch (Exception exp) {
					seconds =0;
				}
				
				sbf.append(oliveColor).append(formatFlowTime(seconds)).append("</font>");
				break;
				
			default:
				sbf.append(this.getMessageStatus());
				break;
				
		}
		
		return sbf.toString();
	
	}
	
	private String formatFlowTime(Integer seconds) {
		
		Integer minutes = seconds/60;
		Integer hours	= minutes/60;
		
		StringBuffer sbf = new StringBuffer();
	        
	        if ( seconds < 60) {
	        	sbf.append("Tempo total foi de  ").append(seconds).append(" segundos");
	        } else if ( minutes < 60 ){
	        	sbf.append("Tempo total foi de ").append(minutes).append(" minutos").append(" e ").append(seconds - minutes*60 ).append(" segundos");
	        } else if ( hours < 24 ){
	        	sbf.append("Tempo total foi de ").append(hours).append(" horas ").append(" e ").append(minutes - hours*60).append(" minutos");
	        	sbf.append(" e ").append(seconds - hours*60*60).append(" segundos");
	        }
	
	        return sbf.toString();
	}

	
	public Parceiro getParceiro() {
		return parceiro;
	}

	public void setParceiro(Parceiro parceiro) {
		this.parceiro = parceiro;
	}

	public double getValorTarifacao() {
		return valorTarifacao;
	}

	public void setValorTarifacao(double valorTarifacao) {
		this.valorTarifacao = valorTarifacao;
	}

	public Date getDtCriacao() {
		return dtCriacao;
	}

	public String getDtCriacaoFormat() {
		return DataUtil.formatarDataTimestampSegundos(dtCriacao);
	}

	public void setDtCriacao(Date dtCriacao) {
		this.dtCriacao = dtCriacao;
	}

	public int getRetentativa() {
		return retentativa;
	}

	public void setRetentativa(int retentativa) {
		this.retentativa = retentativa;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public StatusType getStatusType() {
		return statusType;
	}

	public void setStatusType(StatusType statusType) {
		this.statusType = statusType;
	}

	public MessageStatus getMessageStatus() {
		return messageStatus;
	}

	public void setMessageStatus(MessageStatus messageStatus) {
		this.messageStatus = messageStatus;
	}
}
