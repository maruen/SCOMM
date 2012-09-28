package br.com.supportcomm.virtualgoods.mail;

import br.com.supportcomm.virtualgoods.criptografia.Criptografia;
import br.com.supportcomm.virtualgoodscore.pojo.Usuario;

public class TemplateEmail {
	
	private String url;
	
	// Novo Usuario
	private final String emailNewUserCabecalho = "<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN'" +
			" 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'><html xmlns='http://www.w3.org/1999/xhtml'>" +
			"<head><meta http-equiv='Content-Type' content='text/html; charset=iso-8859-1' />" +
			"<title>VirtualGoods Admin</title></head>" +
			"<body>Foi criado um usuário com perfil de :perfil para :nome, para acessar o Sistema de Administração da plataforma VirtualGoods." +
			"<br /><br />Para acessar o sistema, acesse o caminho <a href=':url'>:url</a> utilizando os dados abaixo:<br /><br />Login : :login" +
			"<br />Senha : :senha<br /><br />Ao fazer o primeiro acesso, queira por gentileza mudar sua senha." +
			"<br /><br />NÃO RESPONDA A ESTA MENSAGEM</body></html>";

	public String getEmailNewUserCabecalho(Usuario usuario) throws Exception {
		return emailNewUserCabecalho.replaceAll(":perfil", usuario.getPerfil())
		.replaceAll(":nome", usuario.getNome())
		.replaceAll(":url", url)
		.replaceAll(":login", usuario.getLogin())
		.replaceAll(":senha", Criptografia.decrip(usuario.getSenha()));
	}

	public void setUrl(String url) {
		this.url = url;
	}	
}	