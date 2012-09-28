package br.com.supportcomm.virtualgoods.controller;

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
import br.com.supportcomm.virtualgoodscore.dao.KeycodeDAO;
import br.com.supportcomm.virtualgoodscore.dao.ParceiroDAO;
import br.com.supportcomm.virtualgoodscore.pojo.Keycode;
import br.com.supportcomm.virtualgoodscore.pojo.Parceiro;

@Resource
public class KeycodeController {
	
	private final ParceiroDAO daoParceiro;
	private final KeycodeDAO dao;
	private final Validator validator;
	private final Result result;
	
	public KeycodeController(ParceiroDAO daoParceiro, KeycodeDAO dao, Validator validator, Result result) {
		this.dao = dao;
		this.validator = validator;
		this.result = result;
		this.daoParceiro = daoParceiro;
	}
	
	@LoggedIn
	public List<Keycode> list() {
		return dao.findAll();
	}
	
	@LoggedIn
	public List<Parceiro> form() {
		return daoParceiro.findAll(Parceiro.ENABLED);
	}
	
	@LoggedIn
	@Path("/keycode/alterar/{id}")
	public Keycode alterar(long id) {
		Keycode keycode = dao.findById(id);
		result.include("parceiroList", daoParceiro.findAll(Parceiro.ENABLED));
		return keycode;
	}
	
	@LoggedIn
	@Path("/keycode/excluir/{keycode.id}")
	public void excluir(Keycode keycode) {
		dao.delete(keycode);
		result.use(Results.logic()).redirectTo(KeycodeController.class).list();		
	}
	
	@LoggedIn
	@Path("/keycode/confirmaExcluir/{keycode.id}")
	public Keycode confirmaExcluir(Keycode keycode) {
		return dao.findById(keycode.getId());
	}
	
	@LoggedIn
	@Post
	public void save(Keycode keycode, boolean habilitado) {
		if(habilitado)
			keycode.setAtivo(Keycode.ENABLED);
		else
			keycode.setAtivo(Keycode.DISABLED);
		
		validaForm(keycode);
		keycode.setDtAlteracao(new Date());
		
		/* CADASTRA */
		if(keycode.getId() == 0) {
			keycode.setDtCriacao(new Date());
			dao.save(keycode);
		
		/* ATUALIZA */
		} else {
			keycode.setDtCriacao(dao.findById(keycode.getId()).getDtCriacao());
			dao.update(keycode);
		}
		
		result.use(Results.logic()).redirectTo(KeycodeController.class).list();
	}
	
	private void validaForm(Keycode keycode) {
		if (keycode.getNome().trim().isEmpty())
			validator.add(new ValidationMessage("O campo nome não pode ser vazio", "error"));
		else {
			Keycode key = dao.findByNome(keycode.getNome());
			if(key != null && key.getId() != keycode.getId())
				validator.add(new ValidationMessage("Já existe um Keycode com este nome", "error"));
		}
		
		if(keycode.getParceiro() == null || keycode.getParceiro().getId() == 0)
			validator.add(new ValidationMessage("Selecione um parceiro", "error"));
		
		/* mantem estado do formulario caso de erro */
		if(validator.hasErrors()) {
			result.include("parceiroList", daoParceiro.findAll(Parceiro.ENABLED));
		}
		
		validator.onErrorUse(Results.page()).of(KeycodeController.class).form();
	}
}
