package br.com.supportcomm.virtualgoodscore.util.mercuri.mt;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Classe de conexão ao Mercuri.
 * 
 * @author felipe.curilla
 */
public class MercuriConnectionImpl implements MercuriConnection {
	private String	url;
	private int	   timeout	= 10000;	

	private Log	   logger	= LogFactory.getLog(this.getClass());

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void doRequest(MercuriQueryBuilder query) {
		// Recupera a requisição ao Mercuri.
		String requestBody = query.getRequestBody();

		OutputStream os = null;
		InputStream is = null;
		HttpURLConnection conn = null;

		try {
			long initialTime = System.nanoTime();

			// Recupera URL de conexão ao Mercuri.
			URL functionUrl = new URL(url + "/" + query.getFunctionName());
			if (logger.isInfoEnabled()) {
				logger.info("Requisicao Mercuri: " + requestBody.replaceAll("[\\n]+", ""));
			}

			// Conecta com o Mercuri.
			conn = (HttpURLConnection) functionUrl.openConnection();
			conn.setRequestMethod("POST");
			conn.setUseCaches(false);
			conn.setDoOutput(true);
			conn.setConnectTimeout(timeout);
			conn.setReadTimeout(timeout);
			conn.connect();
			long connectTime = System.nanoTime();

			// Envia a requisição.
			os = conn.getOutputStream();
			os.write(requestBody.getBytes());
			os.flush();
			os.close();
			os = null;
			long sendTime = System.nanoTime();

			// Recupera a resposta através do código de resposta do HTTP.
			int responseCode = conn.getResponseCode();
			if (logger.isInfoEnabled()) {
				HttpStatus.getStatusText(responseCode);
				logger.info("Resposta Mercuri: " + HttpStatus.getStatusText(responseCode) + " (" + responseCode + ")");
			}
			if (responseCode != HttpStatus.SC_OK) {
				throw new IOException(HttpStatus.getStatusText(responseCode) + " (" + responseCode + ")");
			}

			// Lendo a resposta
			is = conn.getInputStream();
			query.process(is);
			is.close();
			is = null;

			long responseTime = System.nanoTime();

			if (logger.isInfoEnabled()) {
				logger.info("Requisicao Mercuri:" + " Conexao = " + ((connectTime - initialTime) / 1e+6)
				        + " ms, Envio = " + ((sendTime - connectTime) / 1e+6) + " ms, Resposta = "
				        + ((responseTime - sendTime) / 1e+6) + " ms");
			}
		}
		// Erro de I/O, devemos ler o error stream e liberar a conexão
		catch (IOException e) {
			InputStream es = null;
			try {
				StringBuilder message = new StringBuilder();
				message.append("Falha na comunicacao com Mercuri: " + e.getMessage());
				int respCode = ((HttpURLConnection) conn).getResponseCode();
				logger.info("Response Code = " + respCode);
				message.append(", respCode = " + respCode);
				es = ((HttpURLConnection) conn).getErrorStream();
				if (es != null) {
					BufferedReader in = new BufferedReader(new InputStreamReader(es));
					message.append(", message = ");
					String inputLine;
					while ((inputLine = in.readLine()) != null) {
						message.append(inputLine);
					}
				}
				MercuriException me = new MercuriException(message.toString(), e);
				throw me;
			} catch (IOException ex) {
				logger.warn("Falha na leitura da mensagem de erro de comunicação com Mercuri: " + ex.getMessage());
				MercuriException me = new MercuriException("Falha na comunicação com Mercuri: " + e.getMessage(), e);
				throw me;
			} finally {
				if (es != null) {
					try {
						es.close();
					} catch (IOException e1) {
						logger.warn("Falha no fechamento do input stream de erro: " + e1.getMessage());
					}
				}
			}
		} catch (Exception e) {
			MercuriException me = new MercuriException("Erro na conexão com Mercuri: " + e.getMessage(), e);
			throw me;
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (Exception e) {
					logger.warn("Falha no fechamento do output stream: " + e.getMessage());
				}
			}
			if (is != null) {
				try {
					is.close();
				} catch (Exception e) {
					logger.warn("Falha no fechamento do input stream: " + e.getMessage());
				}
			}
		}
	}
}