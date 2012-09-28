package br.com.supportcomm.virtualgoods.controller;

import java.util.List;

import br.com.bronx.vraptor.restrictrex.annotation.LoggedIn;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.caelum.vraptor.view.Results;
import br.com.supportcomm.virtualgoodscore.dao.ConfigDAO;
import br.com.supportcomm.virtualgoodscore.dao.LoggerMessageDAO;
import br.com.supportcomm.virtualgoodscore.pojo.Config;

@Resource
public class GeneralConfigController {
	
	
	private final ConfigDAO    		configDAO;
	private final LoggerMessageDAO 	loggerMessageDAO;
	private final Validator	   		validator;
	private final Result	   		result;
	
	private static final String NOTICE 	= "notice";
	private static final String ERROR 	= "error";
	

	public GeneralConfigController( ConfigDAO configDAO,
									LoggerMessageDAO loggerMessageDAO,
									Validator validator,
									Result result) {
		
		this.configDAO  		= configDAO;
		this.loggerMessageDAO 	= loggerMessageDAO;
		this.validator			= 	validator;
		this.result				= 	result;
	}

	@LoggedIn
	public void form() {
		result.include("configList", configDAO.findAll());
		
	}
	
	@LoggedIn
	@Post
	public void save(List<Config> configList) {
		verifyInputs(configList);

		for (Config config : configList) {
			configDAO.update(config);
		}
		result.include(NOTICE, loggerMessageDAO.getMessageById(13));
		result.redirectTo(GeneralConfigController.class).form();
	}
	
	private void verifyInputs(List<Config> configList) {
		
		for (Config config: configList) {
		
			if (config.getValue().trim().isEmpty()) {
				validator.add(new ValidationMessage(loggerMessageDAO.getMessageById(18,config.getLabel()), ERROR));
			}
			
			if (config.getName().equals("sms.success.default") || 
				config.getName().equals("sms.fail.default")    ||
				config.getName().equals("invalid.command")     ||
				config.getName().equals("duplicated.check.message") ) {
			
				if (config.getValue() != null && config.getValue().trim().length() > 138) {
					validator.add(new ValidationMessage(loggerMessageDAO.getMessageById(16,config.getLabel()), ERROR));
				}
			}
			
			if (config.getName().equals("duplicated.check.interval")) {
				try {
					Integer.parseInt(config.getValue());
				} catch (NumberFormatException exp) {
					validator.add(new ValidationMessage(loggerMessageDAO.getMessageById(17,config.getLabel()), ERROR));
				}
			}
		}
		
		validator.onErrorUse(Results.page()).of(GeneralConfigController.class).form();
	}

}
