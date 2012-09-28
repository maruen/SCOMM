package br.com.supportcomm.virtualgoods.controller;

import java.util.ArrayList;
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
import br.com.supportcomm.virtualgoodscore.constantes.Operadora;
import br.com.supportcomm.virtualgoodscore.dao.KeycodeDAO;
import br.com.supportcomm.virtualgoodscore.dao.ParceiroDAO;
import br.com.supportcomm.virtualgoodscore.dao.RegraDAO;
import br.com.supportcomm.virtualgoodscore.dao.SharecodeDAO;
import br.com.supportcomm.virtualgoodscore.pojo.Keycode;
import br.com.supportcomm.virtualgoodscore.pojo.LA;
import br.com.supportcomm.virtualgoodscore.pojo.Parceiro;
import br.com.supportcomm.virtualgoodscore.pojo.Regra;
import br.com.supportcomm.virtualgoodscore.pojo.Sharecode;

@Resource
public class RegraController {
	
	private final ParceiroDAO daoParceiro;
	private final RegraDAO dao;
	private final SharecodeDAO daoSharecode;
	private final KeycodeDAO daoKeycode;
	private final Validator validator;
	private final Result result;
	
	public RegraController(ParceiroDAO daoParceiro, SharecodeDAO daoSharecode,
			RegraDAO dao, KeycodeDAO daoKeycode, Validator validator,
			Result result) {
		this.dao = dao;
		this.validator = validator;
		this.result = result;
		this.daoParceiro = daoParceiro;
		this.daoSharecode = daoSharecode;
		this.daoKeycode = daoKeycode;
	}
	
	@LoggedIn
	public List<Regra> list() {
		return dao.findAll();
	}
	
	@LoggedIn
	public void form() {
		mantemEstadoFormulario(null);
	}
	
	@LoggedIn
	@Path("/regra/alterar/{id}")
	public Regra alterar(long id) {
		Regra regra = dao.findById(id);
		mantemEstadoFormulario(regra);
		return regra;
	}
	
	@LoggedIn
	@Path("/regra/la/{parceiro.id}")
	public Set<LA> la(Parceiro parceiro) {
		return daoParceiro.findById(parceiro.getId()).getLas();
	}
	
	@LoggedIn
	@Path("/regra/keycode/{parceiro.id}")
	public List<Keycode> keycode(Parceiro parceiro) {
		return daoKeycode.findByParceiro(parceiro.getId(), Keycode.ENABLED);
	}
	
	@LoggedIn
	@Path("/regra/sharecode/{tarifacao}/{id}/{operadora}")
	public List<Sharecode> sharecode(String tarifacao, String operadora, long id) {
		int operator = 0;
		if(operadora.equalsIgnoreCase(Operadora.CLARO.getDescricao()))
			operator = Operadora.CLARO.getCarrier();
		if(operadora.equalsIgnoreCase(Operadora.CTBC.getDescricao()))
			operator = Operadora.CTBC.getCarrier();
		if(operadora.equalsIgnoreCase(Operadora.NEXTEL.getDescricao()))
			operator = Operadora.NEXTEL.getCarrier();
		if(operadora.equalsIgnoreCase(Operadora.OI.getDescricao()))
			operator = Operadora.OI.getCarrier();
		if(operadora.equalsIgnoreCase(Operadora.TIM.getDescricao()))
			operator = Operadora.TIM.getCarrier();
		if(operadora.equalsIgnoreCase(Operadora.VIVO.getDescricao()))
			operator = Operadora.VIVO.getCarrier();
		
		List<Sharecode> lista = new ArrayList<Sharecode>();
		if(tarifacao != null && !tarifacao.trim().isEmpty()) 
			lista = daoSharecode.findByTarifacaoAndOperadora(new Double(tarifacao), operator, Sharecode.ENABLED); 
		
		result.include("shareSelected", id);
		result.include("qtd", lista.size());
		return lista;
	}
	
	@LoggedIn
	@Path("/regra/excluir/{regra.id}")
	public void excluir(Regra regra) {
		dao.delete(regra);
		result.use(Results.logic()).redirectTo(RegraController.class).list();		
	}
	
	@LoggedIn
	@Path("/regra/confirmaExcluir/{regra.id}")
	public Regra confirmaExcluir(Regra regra) {
		return dao.findById(regra.getId());
	}
	
	@LoggedIn
	@Post
	public void save(Regra regra, boolean habilitado, String[] sharecode, boolean autorizaParceiro) {
		
		atribuiSharecode(regra, sharecode);
		validaForm(regra);
		regra.setDtAlteracao(new Date());
		
		
		if(regra.getId() == 0) {
			regra.setDtCriacao(new Date());
			dao.save(regra);
		
		
		} else {
			regra.setDtCriacao(dao.findById(regra.getId()).getDtCriacao());
			dao.update(regra);
		}
		
		result.use(Results.logic()).redirectTo(RegraController.class).list();
	}
	
	private void validaForm(Regra regra) {
		if (regra.getNome().trim().isEmpty())
			validator.add(new ValidationMessage("O campo nome não pode ser vazio", "error"));
		if(regra.getParceiro() == null || regra.getParceiro().getId() == 0)
			validator.add(new ValidationMessage("Selecione um parceiro", "error"));
		if(regra.getLa() == null || regra.getLa().getId() == 0)
			validator.add(new ValidationMessage("Selecione um la", "error"));
		if(regra.getKeycode() == null || regra.getKeycode().getId() == 0)
			validator.add(new ValidationMessage("Selecione um keycode", "error"));
		
		if ((regra.getSharecodeClaro() == null || regra.getSharecodeClaro().getId() == 0)
				&& (regra.getSharecodeCtbc() == null || regra.getSharecodeCtbc().getId() == 0)
				&& (regra.getSharecodeNextel() == null || regra.getSharecodeNextel().getId() == 0)
				&& (regra.getSharecodeOi() == null || regra.getSharecodeOi().getId() == 0)
				&& (regra.getSharecodeTim() == null || regra.getSharecodeTim().getId() == 0)
				&& (regra.getSharecodeVivo() == null || regra.getSharecodeVivo().getId() == 0))
			validator.add(new ValidationMessage("Selecione um sharecode", "error"));
		
		if(validator.hasErrors()) {
			mantemEstadoFormulario(regra);
		}
		
		validator.onErrorUse(Results.page()).of(RegraController.class).form();
	}
	
	private void mantemEstadoFormulario(Regra regra) {
		result.include("parceiroList", daoParceiro.findAll(Parceiro.ENABLED));
		result.include("sharecodeListClaro", daoSharecode.findByOperadora(Operadora.CLARO.getCarrier(), Sharecode.ENABLED));
		result.include("sharecodeListVivo", daoSharecode.findByOperadora(Operadora.VIVO.getCarrier(), Sharecode.ENABLED));
		result.include("sharecodeListOi", daoSharecode.findByOperadora(Operadora.OI.getCarrier(), Sharecode.ENABLED));
		result.include("sharecodeListTim", daoSharecode.findByOperadora(Operadora.TIM.getCarrier(), Sharecode.ENABLED));
		result.include("sharecodeListNextel", daoSharecode.findByOperadora(Operadora.NEXTEL.getCarrier(), Sharecode.ENABLED));
		result.include("sharecodeListCtbc", daoSharecode.findByOperadora(Operadora.CTBC.getCarrier(), Sharecode.ENABLED));
		
		if (regra != null && regra.getParceiro() != null
				&& regra.getParceiro().getId() != 0) {
			result.include("laList", daoParceiro.findById(regra.getParceiro().getId()).getLas());
			result.include("keycodeList", daoKeycode.findByParceiro(regra.getParceiro().getId(), Keycode.ENABLED));
		}
	}	
	
	private void atribuiSharecode(Regra regra, String[] sharecodes) {
		if(sharecodes != null) {
			regra.setSharecodeClaro(null);
			regra.setSharecodeCtbc(null);
			regra.setSharecodeNextel(null);
			regra.setSharecodeOi(null);
			regra.setSharecodeTim(null);
			regra.setSharecodeVivo(null);
			for(String s: sharecodes) 
				if(s != null && !s.trim().isEmpty()) 
					regra.setSharecode(daoSharecode.findById(new Long(s)));
		}			
	}
}
