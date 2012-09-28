package br.com.supportcomm.virtualgoods.mail;

/**
 * Classe de Autentica��o de Envio de E-Mails
 * 
 * @author James Rugno
 * 
 * @version 1.0
 */
import javax.mail.*;

public class Autenticar extends Authenticator {

	   /**
	    * Atributos
	    * 
	    */
		private String usuario;
		private String senha;
		
		/**
		 * Construtor 1
		 * 
		 */
		public Autenticar(){}
		
		/**
		 * Construtor 2
		 *
		 * 
		 * @param String usuario  - Recebe o usu�rio de smtp
		 * @param String senha    - Recebe a senha de smtp
		 */
		public Autenticar(String usuario, String senha){
			this.usuario = usuario;
			this.senha   = senha;
		}
		
		/**
		 * M�todo de Autentica��o
		 * @since 07/05/2008
		 * 
		 * @return PasswordAuthetication 
		 */
	 	public PasswordAuthentication getPasswordAuthentication() 
	 	{
	 		return new PasswordAuthentication(usuario, senha);
	 	}
	 	
}
