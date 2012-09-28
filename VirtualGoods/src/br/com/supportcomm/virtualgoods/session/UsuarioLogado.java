package br.com.supportcomm.virtualgoods.session;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;
import br.com.supportcomm.virtualgoods.roles.Perfil;
import br.com.supportcomm.virtualgoodscore.pojo.Usuario;

@Component
@SessionScoped
public class UsuarioLogado implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	
	public UsuarioLogado() {
	}

	public void efetuaLogin(Usuario usuario) {
		this.usuario = usuario;
	}

	public void efetuaLogoff() {
		this.usuario = null;
	}

	public Usuario getUsuario() {
		return usuario;
	}	
	
	public Perfil getPerfil() {  
        Perfil perfil = new Perfil();  
        if (this.getUsuario() != null) {  
            perfil.setLoggedIn(true);//como o usuario corrente nao eh nulo, significa que ele esta logado  
            //o nivel de acesso vc obtem de onde quiser (banco de dados, arquivo properties etc)  
            //caso nao utilize niveis de acesso no seu controle de acessos, nao precisa informar o accessLevel  
            //perfil.setAccessLevel(0);  
            //Especificamente no seu caso, cada usuario possui apenas um role. Entao, faca simplesmente isso:  
            List<String> roles = new ArrayList<String>();  
            roles.add(this.getUsuario().getPerfil());  
            perfil.setRoles(roles);  
        }  
        return perfil;  
    }  
}
