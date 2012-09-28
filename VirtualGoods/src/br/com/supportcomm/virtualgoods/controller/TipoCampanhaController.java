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
import br.com.supportcomm.virtualgoodscore.dao.TipoCampanhaDAO;
import br.com.supportcomm.virtualgoodscore.pojo.TipoCampanha;

@Resource
public class TipoCampanhaController {
	
	private final TipoCampanhaDAO dao;
	private final Validator validator;
	private final Result result;
	
	public TipoCampanhaController(TipoCampanhaDAO dao, Validator validator, Result result) {
		this.dao = dao;
		this.validator = validator;
		this.result = result;
	}
	
	@LoggedIn
	public List<TipoCampanha> list() {
		return dao.findAll();
	}
	
	@LoggedIn
	public void form() {}
	
	@LoggedIn
	@Path("/tipoCampanha/alterar/{id}")
	public TipoCampanha alterar(long id) {
		return dao.findById(id);
	}
	
	@LoggedIn
	@Path("/tipoCampanha/excluir/{tipoCampanha.id}")
	public void excluir(TipoCampanha tipoCampanha) {
		dao.delete(tipoCampanha);
		result.use(Results.logic()).redirectTo(TipoCampanhaController.class).list();		
	}
	
	@LoggedIn
	@Path("/tipoCampanha/confirmaExcluir/{tipoCampanha.id}")
	public TipoCampanha confirmaExcluir(TipoCampanha tipoCampanha) {
		return dao.findById(tipoCampanha.getId());
	}
	
	@LoggedIn
	@Post
	public void save(TipoCampanha tipoCampanha, boolean habilitado) {
		if(habilitado)
			tipoCampanha.setAtivo(TipoCampanha.ENABLED);
		else
			tipoCampanha.setAtivo(TipoCampanha.DISABLED);
		
		validaForm(tipoCampanha);
		tipoCampanha.setDtAlteracao(new Date());
		
		/* CADASTRA */
		if(tipoCampanha.getId() == 0) {
			tipoCampanha.setDtCriacao(new Date());
			dao.save(tipoCampanha);
		
		/* ATUALIZA */
		} else {
			tipoCampanha.setDtCriacao(dao.findById(tipoCampanha.getId()).getDtCriacao());
			dao.update(tipoCampanha);
		}
		
		result.use(Results.logic()).redirectTo(TipoCampanhaController.class).list();
	}
	
	private void validaForm(TipoCampanha tipoCampanha) {
		if (tipoCampanha.getNome().trim().isEmpty())
			validator.add(new ValidationMessage("O campo nome não pode ser vazio", "error"));
		if (tipoCampanha.getSigla().trim().isEmpty())
			validator.add(new ValidationMessage("O campo sigla não pode ser vazio", "error"));
		else {
			TipoCampanha tp = dao.findBySigla(tipoCampanha.getSigla());
			if(tp != null && tp.getId() != tipoCampanha.getId())
				validator.add(new ValidationMessage("Já existe um Tipo de Campanha com esta sigla", "error"));
		}
		
		
		validator.onErrorUse(Results.page()).of(TipoCampanhaController.class).form();
	}
}
