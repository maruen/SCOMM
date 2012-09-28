package br.com.supportcomm.virtualgoods.mail;

/**
 * Classe de Envio de E-Mails Simples, HTML e Anexo
 * 
 * @author James Rugno
 * 
 * @version 1.0
 * 
 */
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

public class Email {

	/**
	 * Atributos da Classe
	 */
	private String destinatario;
	private String assunto;
	private String mensagem;
	private String arquivo;

	/**
	 * Detalhes de Configura��o
	 */
	private String smtp;
	private String user;
	private String passwd;
	private String remetente;
	private String desRemetente;
	private Log logger = LogFactory.getLog(Email.class);


	/**
	 * M�todo de Envio de E-Mail Simples - emailSimples
	 * 
	 * 
	 * @param String
	 *            destinatario - Destinatario do E-Mail
	 * @param String
	 *            assunto - Assunto do E-Mail
	 * @param String
	 *            mensagem - Mensagem do E-Mail
	 * @return boolean
	 * @throws EmailException
	 * @throws FactoryException
	 * 
	 */
	public boolean emailSimples(String destinatario, String assunto,
			String mensagem) throws EmailException {
		
		try {
			this.destinatario = destinatario;
			this.assunto = assunto;
			this.mensagem = mensagem;

			// Valida o envio de E-Mails
			if (!this.validarEmail()) {
				throw new EmailException(
						"Email - Parametros do E-Mail inv�lidos");
			} else {
				SimpleEmail email = new SimpleEmail();

				// SMTP
				email.setHostName(smtp);

				// Autentica��o
				email.setAuthenticator(new Autenticar(user, passwd));

				// Destinatario
				email.addTo(this.destinatario, this.destinatario);

				// Remetente
				email.setFrom(remetente, desRemetente);

				// Assunto
				email.setSubject(this.assunto);

				// Mensagem
				email.setMsg(this.mensagem);

				// Envia o E-mail
				email.send();

				return true;
			}

		} catch (EmailException e) {
			logger.debug("Email - Parametros do E-Mail invalidos - Email.emailSimples - Data: " + new Date(), e);
		}
		
		return false;
	}

	/**
	 * M�todo de Envio de E-Mails em formato HTML - emailHtml
	 * 
	 * 
	 * @param String
	 *            destinatario - Destinatario do E-Mail
	 * @param String
	 *            assunto - Assunto do E-Mail
	 * @param String
	 *            mensagem - Mensagem do E-Mail
	 * @return boolean
	 * @throws EmailException
	 * @throws FactoryException
	 */
	public boolean emailHtml(String destinatario, String assunto,
			String mensagem) throws EmailException {
		
		try {
			
			this.destinatario = destinatario;
			this.assunto = assunto;
			this.mensagem = mensagem;

			// Valida o envio de E-Mails
			if (!this.validarEmail()) {
				throw new EmailException(
						"Email - Parametros do E-Mail inv�lidos");
			} else {
				HtmlEmail email = new HtmlEmail();

				// SMTP
				email.setHostName(smtp);

				// Seta o tipo do texto
				email.setContent(this.mensagem, "text/html");

				// Autentica��o
				email.setAuthenticator(new Autenticar(user, passwd));

				// Destinatario
				email.addTo(this.destinatario, this.destinatario);

				// Remetente
				email.setFrom(remetente, desRemetente);

				// Assunto
				email.setSubject(this.assunto);

				// Mensagem em HTML
				email.setHtmlMsg(this.mensagem);

				// Envia o E-Mail
				email.send();

				return true;
			}

		} catch (EmailException e) {
			logger.debug("Email - Parametros do E-Mail invalidos - Email.emailHtml - Data: " + new Date(), e);
		}
		return false;
	}

	/**
	 * M�todo de Envio de E-Mails com Anexo - emailAnexo
	 * 
	 * 
	 * @param String
	 *            destinatario - Destinatario do E-Mail
	 * @param String
	 *            assunto - Assunto do E-Mail
	 * @param String
	 *            mensagem - Mensagem do E-Mail
	 * @param String
	 *            arquivo - Arquivo que ir� ser anexado no e-mail
	 * @return boolean
	 * @throws EmailException
	 * @throws FactoryException
	 */
	public boolean emailAnexo(String destinatario, String assunto,
			String mensagem, String arquivo) throws EmailException {
		
		try {

			this.destinatario = destinatario;
			this.assunto = assunto;
			this.mensagem = mensagem;
			this.arquivo = arquivo;

			// Valida o envio de E-Mails
			if (!this.validarEmail()) {
				throw new EmailException(
						"Email - Parametros do E-Mail inv�lidos");
			} else {
				EmailAttachment attachment = new EmailAttachment();

				// Caminho para o arquivo ser anexado
				attachment.setPath(this.arquivo);

				// Anexa o arquivo
				attachment.setDisposition(EmailAttachment.ATTACHMENT);

				MultiPartEmail email = new MultiPartEmail();

				// SMTP
				email.setHostName(smtp);

				// Autentica��o
				email.setAuthenticator(new Autenticar(user, passwd));

				// Destinatario
				email.addTo(this.destinatario, this.destinatario);

				// Remetente
				email.setFrom(remetente, desRemetente);

				// Assunto
				email.setSubject(this.assunto);

				// Mensagem no corpo do E-Mail
				email.setMsg(this.mensagem);

				// Anexa o arquivo no e-mail
				email.attach(attachment);

				// Envia o E-Mail
				email.send();

				return true;
			}

		} catch (EmailException e) {
			e.printStackTrace();
			logger.debug("Email - Parametros do E-Mail invalidos - Email.emailHtml - Data: " + new Date(), e);
			throw new EmailException("Email - Parametros do E-Mail invalidos");	
		}
	}

	/**
	 * M�todo de Valida��o do Envio de E-Mails - validarEmail
	 * 
	 * 
	 * @return boolean
	 */
	private boolean validarEmail() {
		// Valida��o do campos do E-Mail
		if ((this.destinatario == null) || (this.assunto == null)
				|| (this.mensagem == null)) {
			return false;
		} else if ((this.destinatario.indexOf("@") == -1)
				|| (this.destinatario.indexOf(".") == -1)) {
			return false;
		} else {
			return true;
		}
	}

	public void setSmtp(String smtp) {
		this.smtp = smtp;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public void setRemetente(String remetente) {
		this.remetente = remetente;
	}

	public void setDesRemetente(String desRemetente) {
		this.desRemetente = desRemetente;
	}
}