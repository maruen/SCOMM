package br.com.supportcomm.virtualgoods.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import br.com.bronx.vraptor.restrictrex.annotation.LoggedIn;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.supportcomm.virtualgoods.utilities.DataTableModel;
import br.com.supportcomm.virtualgoodscore.constantes.MessageStatus;
import br.com.supportcomm.virtualgoodscore.constantes.Operadora;
import br.com.supportcomm.virtualgoodscore.constantes.StatusType;
import br.com.supportcomm.virtualgoodscore.dao.BuyingLimitExceedDAO;
import br.com.supportcomm.virtualgoodscore.dao.CampanhaDAO;
import br.com.supportcomm.virtualgoodscore.dao.HistoricoDAO;
import br.com.supportcomm.virtualgoodscore.dao.KeycodeDAO;
import br.com.supportcomm.virtualgoodscore.dao.MensagemDAO;
import br.com.supportcomm.virtualgoodscore.dao.TransacaoDAO;
import br.com.supportcomm.virtualgoodscore.dao.WithoutCampaignMsgDAO;
import br.com.supportcomm.virtualgoodscore.pojo.Campanha;
import br.com.supportcomm.virtualgoodscore.pojo.Historico;
import br.com.supportcomm.virtualgoodscore.pojo.Keycode;
import br.com.supportcomm.virtualgoodscore.pojo.Mensagem;
import br.com.supportcomm.virtualgoodscore.pojo.Regra;
import br.com.supportcomm.virtualgoodscore.pojo.Sharecode;
import br.com.supportcomm.virtualgoodscore.pojo.Transacao;
import br.com.supportcomm.virtualgoodscore.util.DataUtil;

@Resource

public class CallCenterController {

	
	private final Result 					result;
	private final TransacaoDAO 			transacaoDAO;
	private final MensagemDAO 				mensagemDAO;
	private final HistoricoDAO 			historicoDAO;
	private final KeycodeDAO 				keycodeDAO;
	private final CampanhaDAO 				campanhaDAO;
	
	
	private static final String INITIAL_DATE 			= 	"initialDate";
	private static final String FINAL_DATE 			= 	"finalDate";
	private static final String MSISDN 				= 	"msisdn";
	private static final String DDI_CODE				= 	"55"; 
	private static final String CARRIER_LIST 			= 	"carrierList";
	
	private static final String PER_PAGE				=	"iDisplayLength";
	private static final String PAGE_NUMBER			=	"iDisplayStart";
	private static final String S_ECHO				=	"sEcho";
	private static final String SORT_COLUMN			=	"iSortColumn";
	private static final String SORT_DIR_DATE			=	"sSortDir_0";
	private static final String SORT_DIR_MSISDN		=	"sSortDir_1";
	
	
	private static final String ERROR					=	"ERROR";
	private static final String FLOW_END				=	"FLOW_END";
	private static final String PROCESSING			=	"PROCESSING";
	
//	private static final String WHITHOUT_RULE			=	"WHITHOUT_RULE";
//	private static final String BUYING_LIMIT_EXCEED	=	"BUYING_LIMIT_EXCEED";

	private static final String NOT_AVAILABLE			=	"N/A";
	
	
	private SimpleDateFormat sdf1 						=  new SimpleDateFormat("dd/MM/yy");
	
    private HttpServletRequest request;

	public CallCenterController( TransacaoDAO transacaoDAO,
								 HistoricoDAO historicoDAO,
								 BuyingLimitExceedDAO buyingLimitExceedDAO,
								 WithoutCampaignMsgDAO withoutRuleMsgDAO,
								 MensagemDAO mensagemDAO,
								 KeycodeDAO keycodeDAO,
								 CampanhaDAO campanhaDAO,
								 Result result,
								 HttpServletRequest request) {
		
		this.transacaoDAO 			= 	transacaoDAO;
		this.historicoDAO 			= 	historicoDAO;
		this.mensagemDAO			=	mensagemDAO;
		this.keycodeDAO				= 	keycodeDAO;
		this.campanhaDAO			=	campanhaDAO;
		this.result 				= 	result;
		this.request				= 	request;
		
	}

	@LoggedIn
	public void form() {}

	@LoggedIn
	@Path("/callCenter/detalhe/{idMensagem}")
	public void detalhe(long idMensagem) {

		List<Object[]> listToJSP = new ArrayList<Object[]>();

		List<Historico> histList = historicoDAO.findByMensagem(idMensagem);
		for (Historico hist: histList) {
			
			String data 		= hist.getDtCriacaoFormat();
			String msisdn 		= hist.getMsisdn();
			String statusType 	= hist.getStatusTypeLabel();
			String status		= hist.getStatusLabel();
		
			String [] row = { data,msisdn,statusType,status };
			listToJSP.add(row);
		}
		
		result.use(Results.json()).withoutRoot().from(listToJSP).serialize();
	}

	@SuppressWarnings("unchecked")
    @LoggedIn
	@Path("/callCenter/dataTable/")
	public void dataTable() {
		
		
		
		String 	initialDate 	= 	request.getParameter(INITIAL_DATE);
		String 	finalDate  		= 	request.getParameter(FINAL_DATE);
		String 	msisdn 	   		= 	request.getParameter(MSISDN);
		Integer perPage    		= 	request.getParameter(PER_PAGE)		  != null ?  Integer.valueOf(request.getParameter(PER_PAGE))	: 10;
		Integer displayStart 	= 	request.getParameter(PAGE_NUMBER)  	  != null ?  Integer.valueOf(request.getParameter(PAGE_NUMBER))	: 1; 
		Integer sortColumn		= 	request.getParameter(SORT_COLUMN)  	  != null ?  Integer.valueOf(request.getParameter(SORT_COLUMN))	: 1;
		
		String sortDirection    = 	"DESC";
		sortDirection			= 	request.getParameter(SORT_DIR_DATE)   != null ?  request.getParameter(SORT_DIR_DATE)    : sortDirection;
		sortDirection			= 	request.getParameter(SORT_DIR_MSISDN) != null ?  request.getParameter(SORT_DIR_MSISDN)  : sortDirection;
		
		String 	sEcho 	   		= 	request.getParameter(S_ECHO);
		
		if (msisdn != null && !msisdn.isEmpty() && msisdn.length() == 10) {
			msisdn = DDI_CODE.concat(msisdn);
		}
		
		HashMap<String,Object> hash = getMessages(initialDate,finalDate,msisdn,perPage,displayStart,sortColumn,sortDirection); 
		
		Integer totals 				=  (Integer) hash.get("size");
		ArrayList<Object[]> list 	=  (ArrayList<Object[]>) hash.get("list");
		
		result.include(CARRIER_LIST, Arrays.asList(Operadora.values()));
		result.include(INITIAL_DATE, initialDate);
		result.include(FINAL_DATE, 	 finalDate);
		result.include(MSISDN, 		 msisdn);
		result.include(PER_PAGE, 	 perPage);
		result.include(PAGE_NUMBER,  displayStart);
		
		 DataTableModel dtModel = new DataTableModel();  
		 dtModel.setiTotalDisplayRecords(totals);  
		 dtModel.setAaData(list.toArray());
		 dtModel.setiTotalRecords(totals);
		 dtModel.setsEcho(sEcho);
		
		
		 result.use(Results.json()).withoutRoot().from(dtModel).include("aaData").serialize(); 
		
	}
    
    private HashMap<String,Object> getMessages(	String 	initialDate,
    											String 	finalDate,
    											String 	msisdn,
    											Integer perPage,
    											Integer displayStart,
    											Integer sortColumn,
    											String 	sortDirection
    		) {
		
		String sortColumnAsString;
    	switch (sortColumn) {
    		case 1:
    			sortColumnAsString  = "DT_REQUEST";
    			break;
    		case 2:
    			sortColumnAsString  = "CD_MSISDN";
    			break;
    		default: 
    			sortColumnAsString =  "DT_REQUEST";
    	}
    	
    	if (initialDate != null && !initialDate.trim().equals("")) {
    		initialDate = initialDate.concat(" 00:00:00");
    	} 
    	
    	if (finalDate != null && !finalDate.trim().equals("")) {
    		finalDate  = finalDate.concat(" 23:59:59");
    	} 
    	
    	HashMap<String,Object> hash = mensagemDAO.findByDateAndMsisdn(	
				DataUtil.obterDataTimestamp(initialDate),
				DataUtil.obterDataTimestamp(finalDate),
				msisdn,
				perPage,
				displayStart,
				sortColumnAsString,
				sortDirection);

        @SuppressWarnings("unchecked")
        List<Mensagem> msgList = (List<Mensagem>) hash.get("list");
		
		List<Object[]> list = new ArrayList<Object[]>();
		for (Mensagem msg : msgList) {
			
			String status;
			List<Historico> listError,listSuccess;
			listError 	= historicoDAO.findByStatusTypeAndMessageStatus(msg, StatusType.FLOW_END, MessageStatus.ERROR);
			listSuccess = historicoDAO.findByStatusTypeAndMessageStatus(msg, StatusType.FLOW_END, MessageStatus.FLOW_END);
			
			if ( listError != null && listError.size() > 0 ) {
	            status = ERROR;
	        
			} else if (  listSuccess != null && listSuccess.size() > 0) {
	        	status = FLOW_END;
	        
			} else {
	        	status = PROCESSING; 
	        }
		
			Transacao tr = transacaoDAO.findByMensagem(msg.getId());
			
			if (tr != null ) {

				String [] row = { 
									status,
									sdf1.format(tr.getDtTransacao()),
									tr.getMsisdn().toString(),
									tr.getParceiro().getNome().toString(),
									tr.getLa().getNome().toString(),
									tr.getKeycode().getNome(),
									Operadora.getDescriptionByCode(String.valueOf(tr.getOperadora())).toString(),
									String.valueOf(tr.getValorTarifacao()),
									tr.getSharecode().getNome().toString(),
									tr.getCampanha().getDescription(),
									String.valueOf(tr.getMensagem().getId()),
			    				};
				list.add(row);
				
			} else {
				
				String textMessage 		 = msg.getMensagem();
				String tokens[] 		 = textMessage.split(" ");
				String partner 			 = NOT_AVAILABLE;
				String la 				 = (msg.getLa() != null)? msg.getLa().getNome(): NOT_AVAILABLE;
				String keycodeAsString   = NOT_AVAILABLE;
				String campaignAsString  = NOT_AVAILABLE;
				String operadora		 = Operadora.getDescriptionByCode(String.valueOf(msg.getOperadora()));
				String valueAsString	 = NOT_AVAILABLE;
				String sharecodeAsString = NOT_AVAILABLE;;
				
				if ( tokens.length >= 2) {
					
					Keycode keycode    = keycodeDAO.findByNome(tokens[0]);
					Campanha campaign  = campanhaDAO.findByKeyword(tokens[1]);

					if (campaign != null) {
						campaignAsString = campaign.getDescription();
						Regra rule = campaign.getRegra();
						
						if ( rule != null) {
							partner = rule.getParceiro().getNome();
							Sharecode sharecode = rule.getSharecode(msg.getOperadora());
							if (sharecode != null) {
								valueAsString = sharecode.getTarifacaoFormat();
								sharecodeAsString = sharecode.getNome();
							}
						}
					}
					
					if (keycode != null) {
						keycodeAsString = keycode.getNome();
					}
				}
				
				String [] row = { 
									status,
									sdf1.format(msg.getRequest()),
									msg.getMsisdn().toString(),
									partner,
									la,
									keycodeAsString,
									operadora,
									valueAsString,
									sharecodeAsString,
									campaignAsString,
									String.valueOf(msg.getId()),
								};
				
				list.add(row);
			}
		}
		
		HashMap<String,Object> hashToJSP = new HashMap<String,Object>();
		hashToJSP.put("list", list);
		hashToJSP.put("size", hash.get("size"));;
		
		return hashToJSP;
	}
	
	
}
