package br.com.supportcomm.virtualgoods.controller;

import java.util.Arrays;

import br.com.bronx.vraptor.restrictrex.annotation.LoggedIn;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.caelum.vraptor.view.Results;
import br.com.supportcomm.virtualgoodscore.constantes.Operadora;
import br.com.supportcomm.virtualgoodscore.dao.BuyConfigDAO;
import br.com.supportcomm.virtualgoodscore.dao.LoggerMessageDAO;
import br.com.supportcomm.virtualgoodscore.pojo.BuyConfig;

@Resource
public class BuyConfigController {

	private final BuyConfigDAO		 buyConfigDAO;
	private final LoggerMessageDAO loggerMessageDAO;
	
	private final Validator validator;
	private final Result 	  result;
	
	private static final String CARRIER_LIST 		= "carrierList";
	private static final String NOTICE 			= "notice";
	private static final String BUY_CONFIG 		= "buyConfig";
	private static final String ERROR 			= "error";
	

	public BuyConfigController(BuyConfigDAO buyConfigDAO, LoggerMessageDAO loggerMessageDAO, Validator validator, Result result) {
		this.buyConfigDAO 		= 	buyConfigDAO;
		this.loggerMessageDAO	=	loggerMessageDAO;
		this.validator 			= 	validator;
		this.result 			= 	result;
	}

	@LoggedIn
	public void form() {
		result.include(CARRIER_LIST, Arrays.asList(Operadora.values()));
	}
	
	
	@LoggedIn
	@Path("/buyConfig/getConfigByOperator/{id}")
	public BuyConfig getConfigByOperator(Integer id) {
		BuyConfig config = buyConfigDAO.findConfigByOperadora(id);
		result.include(BUY_CONFIG, config);
		return config; 
	}

	@LoggedIn
	@Post
	public void save(BuyConfig buyConfig) {
		verifyInputs(buyConfig);
		buyConfigDAO.saveOrUpdate(buyConfig);
		result.include(NOTICE, loggerMessageDAO.getMessageById(13));
		result.include(BUY_CONFIG, buyConfig);
		result.redirectTo(BuyConfigController.class).form();
	}
	
	private void verifyInputs(BuyConfig buyConfig) {
		
		if (buyConfig.getCodigoOperadora() == 0){
			validator.add(new ValidationMessage(loggerMessageDAO.getMessageById(14), ERROR));
		}
		
		if (buyConfig.getVlMax() == null){
			validator.add(new ValidationMessage(loggerMessageDAO.getMessageById(11), ERROR));
		}
		
		if (buyConfig.getMesCorrenteAtivo() != 1 && buyConfig.getNuDias() == null) {
			validator.add(new ValidationMessage(loggerMessageDAO.getMessageById(12), ERROR));
		}
		
		if (buyConfig.getMsgLimiteExcedido() != null && buyConfig.getMsgLimiteExcedido().trim().length() > 138) {
			validator.add(new ValidationMessage(loggerMessageDAO.getMessageById(15), ERROR));
		}
		
		
		result.include(BUY_CONFIG, buyConfig);
		result.include(CARRIER_LIST, Arrays.asList(Operadora.values()));
		validator.onErrorUse(Results.page()).of(BuyConfigController.class).form();
		
	}

}
