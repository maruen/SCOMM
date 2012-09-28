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
import br.com.supportcomm.virtualgoodscore.dao.LADAO;
import br.com.supportcomm.virtualgoodscore.pojo.LA;

@Resource
public class LaController {

	private final LADAO dao;
	private final Validator validator;
	private final Result result;

	public LaController(LADAO dao, Validator validator, Result result) {
		this.dao = dao;
		this.validator = validator;
		this.result = result;
	}

	@LoggedIn
	public List<LA> list() {
		return dao.findAll();
	}

	@LoggedIn
	public List<Operadora> form() {
		return getOperadoras(null);
	}

	@LoggedIn
	@Path("/la/alterar/{id}")
	public LA alterar(long id) {
		LA la = dao.findById(id);
		result.include("operadoraList", getOperadoras(la));
		return la;
	}

	@LoggedIn
	@Path("/la/excluir/{la.id}")
	public void excluir(LA la) {
		dao.delete(la);
		result.use(Results.logic()).redirectTo(LaController.class).list();
	}
	
	@LoggedIn
	@Path("/la/confirmaExcluir/{la.id}")
	public LA confirmaExcluir(LA la) {
		return dao.findById(la.getId());
	}

	@LoggedIn
	@Post
	public void save(LA la, boolean habilitado, Operadora[] operadoras) {
		if (habilitado)
			la.setAtivo(LA.ENABLED);
		else
			la.setAtivo(LA.DISABLED);

		habilitaOperadoras(la, operadoras);
		validaForm(la, operadoras);
		la.setDtAlteracao(new Date());

		/* CADASTRA */
		if (la.getId() == 0) {
			la.setDtCriacao(new Date());
			dao.save(la);

			/* ATUALIZA */
		} else {
			la.setDtCriacao(dao.findById(la.getId()).getDtCriacao());
			dao.update(la);
		}

		result.use(Results.logic()).redirectTo(LaController.class).list();
	}

	private void validaForm(LA la, Operadora[] multiSelect) {
		/* Nome */
		if (la.getNome().trim().isEmpty())
			validator.add(new ValidationMessage(
					"O campo LA não pode ser vazio", "error"));
		else {
			LA laOther = dao.findByNome(la.getNome());
			if (laOther != null && laOther.getId() != la.getId())
				validator.add(new ValidationMessage(
						"Já existe um LA com este shortnumber", "error"));
		}
		/* Descrição */
		if (la.getDescricao().trim().isEmpty())
			validator.add(new ValidationMessage(
					"O campo descrição não pode ser vazio", "error"));
		/* CarrierIdList */
		if (multiSelect == null || multiSelect.length < 1)
			validator.add(new ValidationMessage(
					"Selecione ao menos uma operadora", "error"));
		/* serviceid */
		if (la.getMercuriServiceId() == 0)
			validator.add(new ValidationMessage(
					"O campo serviceId não pode ser vazio", "error"));
		/* itemid */
		if (la.getMercuriItemId() == 0)
			validator.add(new ValidationMessage(
					"O campo itemId não pode ser vazio", "error"));
		/* password */
		if (la.getMercuriPassword().trim().isEmpty())
			validator.add(new ValidationMessage(
					"O campo password não pode ser vazio", "error"));
		/* username */
		if (la.getMercuriUsername().trim().isEmpty())
			validator.add(new ValidationMessage(
					"O campo username não pode ser vazio", "error"));
		/* url */
		if (la.getMercuriUrl().trim().isEmpty())
			validator.add(new ValidationMessage(
					"O campo Url Mercuri não pode ser vazio", "error"));

		/* mantem estado do formulario caso de erro */
		if (validator.hasErrors()) {
			result.include("operadoraList", getOperadoras(la));
		}

		validator.onErrorUse(Results.page()).of(LaController.class).form();
	}

	/**
	 * Método utilizado settar os valores default nas operadoras.
	 * 
	 * @param Passar
	 *            LA somente se necessário popular as Operadoras selecionadas
	 * @return
	 */
	private List<Operadora> getOperadoras(LA la) {
		List<Operadora> ops = Arrays.asList(Operadora.values());
		for (Operadora op : ops)
			op.setSelected(false);

		/* Monta a exibição das operadoras selecionadas */
		if (la != null) {
			if (la.getCodClaro() == LA.ENABLED)
				ops.get(ops.indexOf(Operadora.CLARO)).setSelected(true);
			if (la.getCodCtbc() == LA.ENABLED)
				ops.get(ops.indexOf(Operadora.CTBC)).setSelected(true);
			if (la.getCodNextel() == LA.ENABLED)
				ops.get(ops.indexOf(Operadora.NEXTEL)).setSelected(true);
			if (la.getCodOi() == LA.ENABLED)
				ops.get(ops.indexOf(Operadora.OI)).setSelected(true);
			if (la.getCodTim() == LA.ENABLED)
				ops.get(ops.indexOf(Operadora.TIM)).setSelected(true);
			if (la.getCodVivo() == LA.ENABLED)
				ops.get(ops.indexOf(Operadora.VIVO)).setSelected(true);
		}

		return ops;
	}

	/**
	 * Método utilizado para habilitar as operadoras selecionadas no formulário
	 * no Objeto LA
	 * 
	 * @param la
	 * @param operadoras
	 */
	private void habilitaOperadoras(LA la, Operadora[] operadoras) {
		if (operadoras != null)
			for (Operadora ops : operadoras) {
				switch (ops) {
				case CLARO:
					la.setCodClaro(LA.ENABLED);
					break;
				case CTBC:
					la.setCodCtbc(LA.ENABLED);
					break;
				case NEXTEL:
					la.setCodNextel(LA.ENABLED);
					break;
				case OI:
					la.setCodOi(LA.ENABLED);
					break;
				case TIM:
					la.setCodTim(LA.ENABLED);
					break;
				case VIVO:
					la.setCodVivo(LA.ENABLED);
					break;
				}
			}
	}
}
