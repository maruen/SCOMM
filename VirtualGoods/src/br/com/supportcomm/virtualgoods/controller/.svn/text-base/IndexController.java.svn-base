package br.com.supportcomm.virtualgoods.controller;

import br.com.bronx.vraptor.restrictrex.annotation.AccessDeniedPage;
import br.com.bronx.vraptor.restrictrex.annotation.LoginPage;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.supportcomm.virtualgoodscore.dao.UsuarioDAO;

@Resource
public class IndexController {
	
	private final Result result;
	private final UsuarioDAO daoUsuario;
	
	public IndexController(Result result, UsuarioDAO daoUsuario) {
		this.result = result;
		this.daoUsuario = daoUsuario;
	}

	@Path("/")
	@LoginPage
	public void index() {
		
//		se nao possuir nenhum usuario cadastrado no sistema, exibe formulario de cadastro de usuario
		result.include("exibeFormUsuario", (daoUsuario.count() > 0 ? false : true));
//		result.include("exibeFormUsuario", false);
	}	
	
	@AccessDeniedPage
	public void acessoNegado() {}
}