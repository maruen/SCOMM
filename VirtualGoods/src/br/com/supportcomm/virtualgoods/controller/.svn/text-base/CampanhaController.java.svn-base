package br.com.supportcomm.virtualgoods.controller;

import java.util.Date;
import java.util.List;
import java.util.Set;

import br.com.bronx.vraptor.restrictrex.annotation.LoggedIn;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.caelum.vraptor.view.Results;
import br.com.supportcomm.virtualgoodscore.dao.CampanhaDAO;
import br.com.supportcomm.virtualgoodscore.dao.ConfigDAO;
import br.com.supportcomm.virtualgoodscore.dao.KeycodeDAO;
import br.com.supportcomm.virtualgoodscore.dao.LoggerMessageDAO;
import br.com.supportcomm.virtualgoodscore.dao.ParceiroDAO;
import br.com.supportcomm.virtualgoodscore.dao.RegraDAO;
import br.com.supportcomm.virtualgoodscore.dao.TipoCampanhaDAO;
import br.com.supportcomm.virtualgoodscore.dao.VGFlowDAO;
import br.com.supportcomm.virtualgoodscore.pojo.Campanha;
import br.com.supportcomm.virtualgoodscore.pojo.Keycode;
import br.com.supportcomm.virtualgoodscore.pojo.LA;
import br.com.supportcomm.virtualgoodscore.pojo.Parceiro;
import br.com.supportcomm.virtualgoodscore.pojo.Regra;
import br.com.supportcomm.virtualgoodscore.pojo.TipoCampanha;

@Resource
public class CampanhaController {
	
	private final TipoCampanhaDAO 		tipoCampanhaDAO;
	private final RegraDAO 			regraDAO;
	private final KeycodeDAO 			keycodeDAO;
	private final ParceiroDAO 			parceiroDAO;
	private final CampanhaDAO 			campanhaDAO;
	private final ConfigDAO 			configDAO;
	private final VGFlowDAO 			vgFlowDAO;
	private final LoggerMessageDAO		loggerMessageDAO;
	private final Validator 			validator;
	private final Result 				result;
	
	private static final String ERROR 			= "error";
	private static final String EMPTY_FIELD 		= "empty_field";
	private static final String SELECT_FIELD 		= "select_field";
	private static final String NOTICE 			= "notice";
	
	private static final String CAMPAIGN 			= "campanha";
	
	public CampanhaController(
			CampanhaDAO campanhaDAO,
			ParceiroDAO parceiroDAO,
			KeycodeDAO keycodeDAO,
			RegraDAO regraDAO,
			TipoCampanhaDAO tipoCampanhaDAO,
			ConfigDAO configDAO,
			VGFlowDAO vgFlowDAO,
			LoggerMessageDAO loggerMessageDAO,
			Validator validator,
			Result result
	) {
		
		this.campanhaDAO 	   	=  	campanhaDAO;
		this.parceiroDAO 	   	=  	parceiroDAO;
		this.keycodeDAO 	   	=  	keycodeDAO;
		this.regraDAO 		   	=  	regraDAO;
		this.tipoCampanhaDAO  	=  	tipoCampanhaDAO;
		this.configDAO 		   	=  	configDAO;
		this.vgFlowDAO		   	=  	vgFlowDAO;
		this.loggerMessageDAO	= 	loggerMessageDAO;
		this.validator 		   	=	validator;
		this.result 		   	= 	result;
	}
	
	@LoggedIn
	public List<Campanha> list() {
		result.include("vgFlowList",	   vgFlowDAO.findAll());
		return campanhaDAO.findAll();
	}	
	
	@LoggedIn
	public void form() {
		includeReferenceData();
	}

	private void includeReferenceData() {
		result.include("parceiroList", 	   	parceiroDAO.findAll(Parceiro.ENABLED));
		result.include("vgFlowList",	   	vgFlowDAO.findAll());
		result.include("tipoCampanhaList", 	tipoCampanhaDAO.findAll(TipoCampanha.ENABLED));
		result.include("mtSuccessMessage", 	configDAO.findByName("sms.success.default"));
		result.include("mtFailMessage", 	configDAO.findByName("sms.fail.default"));
		result.include("smsOptionIn",   	configDAO.findByName("sms.optionIn"));
		result.include("smsVoucher",    	configDAO.findByName("sms.voucher"));
	}
	
	@LoggedIn
	@Path("/campanha/alterar/{id}")
	public void alterar(long id) {
		includeReferenceData();
		includeCampaignData(campanhaDAO.findById(id));
	}

	private void includeCampaignData(Campanha campanha) {
		
		Regra 	 regra		= regraDAO.findById(campanha.getRegra().getId());
		
		LA    	 la	    	= regra.getLa();
		Parceiro parceiro 	= regra.getParceiro();
		Keycode  keycode 	= regra.getKeycode();
		
		result.include("laList", 		parceiroDAO.findById(parceiro.getId()).getLas());
		result.include("keycodeList",	keycodeDAO.findByParceiro(parceiro.getId(), Keycode.ENABLED));
		result.include("regraList",		regraDAO.findByParceiroOrLAOrKeycode(parceiro.getId(), la.getId(), keycode.getId()));

		result.include("la_selected", 		la);
		result.include("parceiro_selected", parceiro);
		result.include("keycode_selected", 	keycode);
		
		result.include(CAMPAIGN,campanha);
		
	}
	
	@LoggedIn
	@Path("/campanha/la/{parceiro.id}")
	public Set<LA> la(Parceiro parceiro) {
		return parceiroDAO.findById(parceiro.getId()).getLas();
	}
	
	@LoggedIn
	@Path("/campanha/keycode/{parceiro.id}")
	public List<Keycode> keycode(Parceiro parceiro) {
		return keycodeDAO.findByParceiro(parceiro.getId(), Keycode.ENABLED);
	}
	
	@LoggedIn
	@Path("/campanha/regra/{parceiro.id}/{la.id}/{keycode.id}")
	public List<Regra> regra(Parceiro parceiro, LA la, Keycode keycode) {
		return regraDAO.findByParceiroOrLAOrKeycode(parceiro.getId(), la.getId(), keycode.getId());
	}
	
	@LoggedIn
	@Path("/campanha/excluir/{campanha.id}")
	public void excluir(Campanha campanha) {
		campanhaDAO.delete(campanha);
		result.use(Results.logic()).redirectTo(CampanhaController.class).list();		
	}
	
	@LoggedIn
	@Path("/campanha/confirmaExcluir/{campanha.id}")
	public Campanha confirmaExcluir(Campanha campanha) {
		return campanhaDAO.findById(campanha.getId());
	}
	
	@LoggedIn
	@Post
	public void save(Campanha campanha, boolean habilitado) {

		if(habilitado) {
			campanha.setAtivo(Campanha.ENABLED);
		} else {
			campanha.setAtivo(Campanha.DISABLED);
		}
		
		verifyInputs(campanha);
		
		campanha.setDtAlteracao(new Date());
		
		if(campanha.getId() == 0) {
			campanha.setDtCriacao(new Date());
			campanhaDAO.save(campanha);
		} else {
			campanha.setDtCriacao(campanhaDAO.findById(campanha.getId()).getDtCriacao());
			campanhaDAO.update(campanha);
		}

		includeCampaignData(campanha);
		result.include(NOTICE, loggerMessageDAO.getMessageById(13));
		result.redirectTo(CampanhaController.class).form();
	}
	
	private void verifyInputs(Campanha campaign) {
		
		if(campaign.getRegra() == null || campaign.getRegra().getId() == 0) {
			addErrorByShortcode(SELECT_FIELD, "a regra");
		}
		includeReferenceData();
		validator.onErrorUse(Results.page()).of(CampanhaController.class).form();
		
		if (campaign.getFlowType() == 3) {
			Regra regra = regraDAO.findById(campaign.getRegra().getId());
			campaign.setKeyword(regra.getKeycode().getNome());
		}
		
		if ( 	campaign.getFlowType() == Campanha.SIMPLIFIED_FLOW 				||
				campaign.getFlowType() == Campanha.REQUIRES_AUTHORIZATION_FLOW		) { 
			
			if (campaign.getDescription() == null || campaign.getDescription().trim().isEmpty()) {
				addErrorByShortcode(EMPTY_FIELD, "descrição");
			}
			
			if (campaign.getKeyword() == null || campaign.getKeyword().trim().isEmpty()) {
				addErrorByShortcode(EMPTY_FIELD, "keyword");
			
			} else {
				
				Campanha aCampaign = campanhaDAO.findByKeyword(campaign.getKeyword().trim());
				if(aCampaign != null && aCampaign.getId() != campaign.getId()) {
					validator.add(new ValidationMessage(loggerMessageDAO.getMessageById(20), ERROR));
					addErrorById(20);
				}
			}
			
			if (campaign.getNomePortalVendaPerformance() == null || campaign.getNomePortalVendaPerformance().trim().isEmpty()) {
				addErrorByShortcode(EMPTY_FIELD, "nome performance");
			}
			
			if (campaign.getUrlConfirmStatus() == null || campaign.getUrlConfirmStatus().trim().isEmpty()) {
				addErrorByShortcode(EMPTY_FIELD, "URL confirma Status");
			}
			
			if(campaign.getTipoCampanha() == null || campaign.getTipoCampanha().getId() == 0) {
				addErrorByShortcode(SELECT_FIELD, "Tipo Campanha");
			}
		
			if (campaign.getFlowType() == Campanha.REQUIRES_AUTHORIZATION_FLOW) {
				if (campaign.getUrlPedido() == null || campaign.getUrlPedido().trim().isEmpty()) {
					addErrorByShortcode(EMPTY_FIELD, "URL pedido");
				}
			}
		
		} else if (campaign.getFlowType() == Campanha.VOUCHER_FLOW) {
			
			if (campaign.getDescription() == null || campaign.getDescription().trim().isEmpty()) {
				addErrorByShortcode(EMPTY_FIELD, "descrição");
			}
			
			if (campaign.getNomePortalVendaPerformance() == null || campaign.getNomePortalVendaPerformance().trim().isEmpty()) {
				addErrorByShortcode(EMPTY_FIELD, "nome performance");
			}
			
			if(campaign.getTipoCampanha() == null || campaign.getTipoCampanha().getId() == 0) {
				addErrorByShortcode(SELECT_FIELD, " Tipo Campanha");
			}
			
			Campanha otherCampaign = campanhaDAO.findByKeyword(campaign.getKeyword());
			
			if (otherCampaign != null && otherCampaign.getId() != campaign.getId() ) {
				validator.add(new ValidationMessage(loggerMessageDAO.getMessageById(21,campaign.getKeyword()), ERROR));
			}
			
		}
		
		includeReferenceData();
		includeCampaignData(campaign);
		validator.onErrorUse(Results.page()).of(CampanhaController.class).form();
		
	}

	private void addErrorByShortcode(String shortcode,Object... args) {
		String message = loggerMessageDAO.getMessageByShortcode(shortcode,args);
		validator.add(new ValidationMessage(message, ERROR));
	}
	
	private void addErrorById(Integer id,Object... args) {
		validator.add(new ValidationMessage(loggerMessageDAO.getMessageById(id,args), ERROR));
	}
		
}
