package br.com.supportcomm.virtualgoods.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import br.com.bronx.vraptor.restrictrex.annotation.LoggedIn;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.caelum.vraptor.view.Results;
import br.com.supportcomm.virtualgoodscore.constantes.Operadora;
import br.com.supportcomm.virtualgoodscore.dao.SharecodeDAO;
import br.com.supportcomm.virtualgoodscore.pojo.Sharecode;

@Resource
public class SharecodeController {
	
	private final SharecodeDAO dao;
	private final Validator validator;
	private final Result result;
	
	public SharecodeController(SharecodeDAO dao, Validator validator, Result result) {
		this.dao = dao;
		this.validator = validator;
		this.result = result;
	}
	
	@LoggedIn
	public List<Sharecode> list() {
		return dao.findAll();
	}
	
	@LoggedIn
	public List<Operadora> form() {
		return Arrays.asList(Operadora.values());
	}
	
	@LoggedIn
	@Path("/sharecode/alterar/{id}")
	public Sharecode alterar(long id) {
		Sharecode sharecode = dao.findById(id);
		result.include("operadoraList", Arrays.asList(Operadora.values()));
		return sharecode;
	}
	
	@LoggedIn
	@Path("/sharecode/excluir/{sharecode.id}")
	public void excluir(Sharecode sharecode) {
		dao.delete(sharecode);
		result.use(Results.logic()).redirectTo(SharecodeController.class).list();		
	}
	
	@LoggedIn
	@Path("/sharecode/confirmaExcluir/{sharecode.id}")
	public Sharecode confirmaExcluir(Sharecode sharecode) {
		return dao.findById(sharecode.getId());
	}
	
	@LoggedIn
	@Post
	public void save(Sharecode sharecode, boolean habilitado) {
		if(habilitado)
			sharecode.setAtivo(Sharecode.ENABLED);
		else
			sharecode.setAtivo(Sharecode.DISABLED);
		
		validaForm(sharecode);
		sharecode.setDtAlteracao(new Date());
		
		/* CADASTRA */
		if(sharecode.getId() == 0) {
			sharecode.setDtCriacao(new Date());
			dao.save(sharecode);
		
		/* ATUALIZA */
		} else {
			sharecode.setDtCriacao(dao.findById(sharecode.getId()).getDtCriacao());
			dao.update(sharecode);
		}
		
		result.use(Results.logic()).redirectTo(SharecodeController.class).list();
	}
	
	private void validaForm(Sharecode sharecode) {
		/* Nome */
		if (sharecode.getNome().trim().isEmpty())
			validator.add(new ValidationMessage("O campo sharecode não pode ser vazio", "error"));
		/* Descrição */
		if (sharecode.getDescricao().trim().isEmpty())
			validator.add(new ValidationMessage("O campo descrição não pode ser vazio", "error"));
		/* Tarifação */
		if (sharecode.getTarifacao() == 0)
			validator.add(new ValidationMessage("O campo tarifação não pode ser vazio", "error"));
		/* serviceid */
		if (sharecode.getMercuriServiceId() == 0)
			validator.add(new ValidationMessage("O campo serviceId não pode ser vazio", "error"));
		/* itemid */
		if (sharecode.getMercuriItemId() == 0)
			validator.add(new ValidationMessage("O campo itemId não pode ser vazio", "error"));
		/* password */
		if (sharecode.getMercuriPassword().trim().isEmpty())
			validator.add(new ValidationMessage("O campo password não pode ser vazio", "error"));
		/* username */
		if (sharecode.getMercuriUsername().trim().isEmpty())
			validator.add(new ValidationMessage("O campo username não pode ser vazio", "error"));
		/* url */
		if (sharecode.getMercuriUrl().trim().isEmpty())
			validator.add(new ValidationMessage("O campo Url Mercuri não pode ser vazio", "error"));
		
		/* valida duplicado */
		Sharecode share = dao.findByNomeAndOperadora(sharecode.getNome(), sharecode.getOperadora());
		if(share != null && share.getId() != sharecode.getId())
			validator.add(new ValidationMessage("Já existe este Sharecode com esta operadora", "error"));
		
		/* mantem estado do formulario caso de erro */
		if(validator.hasErrors()) {
			result.include("operadoraList", Arrays.asList(Operadora.values()));
		}
		
		validator.onErrorUse(Results.page()).of(SharecodeController.class).form();
	}
}
