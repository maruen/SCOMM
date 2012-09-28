package br.com.supportcomm.virtualgoods.controller;

import java.util.Date;
import java.util.HashSet;
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
import br.com.supportcomm.virtualgoodscore.dao.LADAO;
import br.com.supportcomm.virtualgoodscore.dao.ParceiroDAO;
import br.com.supportcomm.virtualgoodscore.pojo.LA;
import br.com.supportcomm.virtualgoodscore.pojo.Parceiro;

@Resource
public class ParceiroController {
	
	private final ParceiroDAO dao;
	private final LADAO daoLa;
	private final Validator validator;
	private final Result result;
	
	public ParceiroController(ParceiroDAO dao, Validator validator, Result result, LADAO daoLa) {
		this.dao = dao;
		this.validator = validator;
		this.result = result;
		this.daoLa = daoLa;
	}
	
	@LoggedIn
	public List<Parceiro> list() {
		return dao.findAll();
	}
	
	@LoggedIn
	public List<LA> form() {
		return daoLa.findAll(LA.ENABLED);
	}
	
	@LoggedIn
	@Path("/parceiro/alterar/{id}")
	public Parceiro alterar(long id) {
		Parceiro parceiro = dao.findById(id);
		result.include("laList", habilitaLA(daoLa.findAll(LA.ENABLED), parceiro));
		return parceiro;
	}
	
	@LoggedIn
	@Path("/parceiro/excluir/{parceiro.id}")
	public void excluir(Parceiro parceiro) {
		dao.delete(parceiro);
		result.use(Results.logic()).redirectTo(ParceiroController.class).list();		
	}
	
	@LoggedIn
	@Path("/parceiro/confirmaExcluir/{parceiro.id}")
	public Parceiro confirmaExcluir(Parceiro parceiro) {
		return dao.findById(parceiro.getId());
	}
	
	@LoggedIn
	@Post
	public void save(Parceiro parceiro, boolean habilitado, long[] las) {
		if(habilitado)
			parceiro.setAtivo(Parceiro.ENABLED);
		else
			parceiro.setAtivo(Parceiro.DISABLED);
		
		Set<LA> list = new HashSet<LA>();
		if(las != null)
			for(long idLa: las) 
				list.add(daoLa.findById(idLa));
				
		parceiro.setLas(list);
		validaForm(parceiro, las);
		parceiro.setDtAlteracao(new Date());
		
		/* CADASTRA */
		if(parceiro.getId() == 0) {
			parceiro.setDtCriacao(new Date());
			dao.save(parceiro);
		
		/* ATUALIZA */
		} else {
			parceiro.setDtCriacao(dao.findById(parceiro.getId()).getDtCriacao());
			dao.update(parceiro);
		}
		
		result.use(Results.logic()).redirectTo(ParceiroController.class).list();
	}
	
	private void validaForm(Parceiro parceiro, long[] las) {
		
		
		if (parceiro.getNome().trim().isEmpty()) {
			validator.add(new ValidationMessage("O campo nome não pode ser vazio", "error"));
		}
		else {
			Parceiro p = dao.findByNome(parceiro.getNome());
			if(p != null && p.getId() != parceiro.getId())
				validator.add(new ValidationMessage("Já existe um Parceiro com este nome", "error"));
		}
		
		if (parceiro.getNomePerformance().trim().isEmpty()) {
			validator.add(new ValidationMessage("O campo nome performance não pode ser vazio", "error"));
		}
		
		if (parceiro.getRetentativa() == 0) {
			validator.add(new ValidationMessage("O campo qtd retentativa não pode ser vazio", "error"));
		}
			
		if (parceiro.getTimeSchedule() == 0) {
			validator.add(new ValidationMessage("O campo schedule não pode ser vazio", "error"));
		}
		
		if (parceiro.getVoucherSize() < 6) {
			validator.add(new ValidationMessage("O tamanho mínimo do voucher é de 6 caracteres", "error"));
		}
		
		if (parceiro.getVoucherWSLogin().trim().isEmpty()) {
			validator.add(new ValidationMessage("O campo Login WebService não pode ser vazio", "error"));
		}
		
		if (parceiro.getVoucherWSLogin().length() < 6) {
			validator.add(new ValidationMessage("O tamanho mínimo do campo Login WebService é de 6 caracteres", "error"));
		}
		
		if (parceiro.getVoucherWSPasswd().trim().isEmpty()) {
			validator.add(new ValidationMessage("O campo Senha WebService não pode ser vazio", "error"));
		}
		
		if (parceiro.getVoucherWSPasswd().length() < 6) {
			validator.add(new ValidationMessage("O tamanho mínimo do campo Senha WebService é de 6 caracteres", "error"));
		}
		
		if (las == null || las.length < 1) {
			validator.add(new ValidationMessage("Selecione ao menos um LA", "error"));
		}
		
		
		if(validator.hasErrors()) {
			result.include("laList", habilitaLA(daoLa.findAll(LA.ENABLED), parceiro));
		}
		
		validator.onErrorUse(Results.page()).of(ParceiroController.class).form();
	}
	
	/**
	 * Método utilizado para habilitar as LAs selecionadas pelo parceiro na JSP
	 * 
	 * @param las
	 * @param p
	 * @return
	 */
	private List<LA> habilitaLA(List<LA> las, Parceiro p) {
		for (LA la: p.getLas()) 
			if(las.indexOf(la) != -1) 
				las.get(las.indexOf(la)).setSelected(true);
		
		return las;
	}
}
