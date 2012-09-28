package br.com.supportcomm.virtualgoods.controller;

import java.util.Date;
import java.util.List;

import org.apache.commons.mail.EmailException;

import br.com.bronx.vraptor.restrictrex.annotation.LoggedIn;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.caelum.vraptor.view.Results;
import br.com.supportcomm.virtualgoods.criptografia.Criptografia;
import br.com.supportcomm.virtualgoods.mail.Email;
import br.com.supportcomm.virtualgoods.mail.TemplateEmail;
import br.com.supportcomm.virtualgoods.session.UsuarioLogado;
import br.com.supportcomm.virtualgoods.validator.ValidatorUtil;
import br.com.supportcomm.virtualgoodscore.dao.UsuarioDAO;
import br.com.supportcomm.virtualgoodscore.pojo.Usuario;

@Resource
public class UsuarioController {

	private final Email	        email;
	private final TemplateEmail	templateEmail;
	private final Result	    result;
	private final UsuarioLogado	usuarioLogado;
	private final UsuarioDAO	dao;
	private final Validator	    validator;

	public UsuarioController(Validator validator, UsuarioDAO dao, UsuarioLogado usuarioLogado, Result result,
	        Email email, TemplateEmail templateEmail) {

		this.validator = validator;
		this.dao = dao;
		this.usuarioLogado = usuarioLogado;
		this.result = result;
		this.email = email;
		this.templateEmail = templateEmail;
	}

	@Post
	public void login(Usuario usuario) throws Exception {
		/* VALIDA LOGIN */
		if (usuario.getLogin().trim().isEmpty() || usuario.getSenha().trim().isEmpty())
			validator.add(new ValidationMessage("Os campos usuário e senha são obrigatórios!", "error"));
		validator.onErrorUse(Results.logic()).redirectTo(IndexController.class).index();

		/* procura usuario */
		usuario = dao.findByLoginAndSenha(usuario.getLogin(), Criptografia.crip(usuario.getSenha()));

		/* VALIDA CADASTRO DO USuaRIO */
		if (usuario == null)
			validator.add(new ValidationMessage("Usuário inválido", "error"));
		else if (usuario.getAtivo() == Usuario.CD_ATIVO_FALSE)
			validator.add(new ValidationMessage("Usuário desabilitado", "error"));
		validator.onErrorUse(Results.logic()).redirectTo(IndexController.class).index();

		this.usuarioLogado.efetuaLogin(usuario);
		result.use(Results.logic()).redirectTo(IndexController.class).index();
	}

	@LoggedIn
	public void logout() {
		usuarioLogado.efetuaLogoff();
		result.use(Results.logic()).redirectTo(IndexController.class).index();
	}

	@LoggedIn
	public void form() {
	}

	@LoggedIn
	public List<Usuario> list() {
		return dao.findAll();
	}

	@LoggedIn
	@Path("/usuario/excluir/{usuario.id}")
	public void excluir(Usuario usuario) {
		if (usuarioLogado.getUsuario().getId() == usuario.getId())
			usuarioLogado.efetuaLogoff();
		dao.delete(usuario);
		result.use(Results.logic()).redirectTo(UsuarioController.class).list();
	}

	@LoggedIn
	@Path("/usuario/confirmaExcluir/{usuario.id}")
	public Usuario confirmaExcluir(Usuario usuario) {
		return dao.findById(usuario.getId());
	}

	@LoggedIn
	@Path("/usuario/alterar/{id}")
	public Usuario alterar(long id) {
		return dao.findById(id);
	}

	@LoggedIn
	@Post
	public void update(Usuario usuario, boolean habilitado) {
		if (habilitado)
			usuario.setAtivo(Usuario.CD_ATIVO_TRUE);
		else
			usuario.setAtivo(Usuario.CD_ATIVO_FALSE);

		validaForm(usuario);

		Usuario user = dao.findById(usuario.getId());
		usuario.setSenha(user.getSenha());
		usuario.setDtCriacao(user.getDtCriacao());
		usuario.setDtAlteracao(new Date());

		dao.update(usuario);
		result.use(Results.logic()).redirectTo(UsuarioController.class).list();
	}

	@LoggedIn
	public void alterarSenha() {
	}

	@LoggedIn
	@Post
	public void updateSenha(String senhaAtual, String novaSenha, String confirmeNovaSenha) throws Exception {

		/* Valida Senha */
		if (!senhaAtual.equals(Criptografia.decrip(usuarioLogado.getUsuario().getSenha())))
			validator.add(new ValidationMessage("Senha atual incorreta", "error"));
		if (novaSenha.trim().length() < 6)
			validator.add(new ValidationMessage("Nova senha mínimo 6 caracteres", "error"));
		if (!novaSenha.equals(confirmeNovaSenha))
			validator.add(new ValidationMessage("A nova senha e sua confirmação não são iguais", "error"));
		validator.onErrorUse(Results.page()).of(UsuarioController.class).alterarSenha();

		usuarioLogado.getUsuario().setSenha(Criptografia.crip(novaSenha));
		usuarioLogado.getUsuario().setDtAlteracao(new Date());
		dao.update(usuarioLogado.getUsuario());
		result.use(Results.logic()).redirectTo(IndexController.class).index();
	}

	@Post
	public void save(Usuario usuario, boolean habilitado) throws Exception {
		if (habilitado)
			usuario.setAtivo(Usuario.CD_ATIVO_TRUE);
		else
			usuario.setAtivo(Usuario.CD_ATIVO_FALSE);

		validaForm(usuario);

		usuario.setDtCriacao(new Date());
		usuario.setDtAlteracao(new Date());
		usuario.setSenha(Criptografia.crip(gerarSenhaAleatoria()));

		// Envia email com nova Localizacao criada
		try {
			email.emailHtml(usuario.getEmail(), "[VirtualGoods] Confirmação de Cadastro de Usuário",
			        templateEmail.getEmailNewUserCabecalho(usuario));
			dao.save(usuario);
		} catch (EmailException e) {
		}

		result.use(Results.logic()).redirectTo(UsuarioController.class).list();
	}

	private String gerarSenhaAleatoria() {
		long rdn = (long) (Math.random() * 88888888);
		return new Long(rdn + 11111111).toString();
	}

	private void validaForm(Usuario usuario) {
		/* Nome */
		if (usuario.getNome().trim().isEmpty())
			validator.add(new ValidationMessage("O campo nome não pode ser vazio", "error"));

		/* Email */
		if (usuario.getEmail().trim().isEmpty())
			validator.add(new ValidationMessage("O campo e-mail não pode ser vazio", "error"));
		else if (!ValidatorUtil.validaEmail(usuario.getEmail()))
			validator.add(new ValidationMessage("E-mail inválido", "error"));

		/* Username */
		if (usuario.getLogin().trim().isEmpty())
			validator.add(new ValidationMessage("O campo login não pode ser vazio", "error"));
		else {
			Usuario user = dao.findByLogin(usuario.getLogin());
			if (user != null && user.getId() != usuario.getId())
				validator.add(new ValidationMessage("Já existe um Login com esta descrição", "error"));
		}

		validator.onErrorUse(Results.page()).of(UsuarioController.class).form();
	}
}