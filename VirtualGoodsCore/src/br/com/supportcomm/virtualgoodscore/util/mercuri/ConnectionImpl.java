package br.com.supportcomm.virtualgoodscore.util.mercuri;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ConnectionImpl implements Connection
{
    private String billingUrl;
    private int connectTimeout = 10000;
    private int readTimeout = 10000;
    private ConnectionFactoryImpl connectionFactory;
    private final static Log logger = LogFactory.getLog(ConnectionImpl.class);

    public ConnectionImpl()
    {
    }

    @Override
    public void close()
    {
        connectionFactory.close(this);
    }

    @Override
    public BillingQuery createBillingQuery()
    {
        BillingQuery query = new BillingQuery();
        query.setActionUrl(billingUrl);
        query.setConnection(this);
        return query;
    }

    public void send(MercuriQuery query)
    {
        PrintWriter os = null;
        InputStream is = null;
        HttpURLConnection conn = null;

        try
        {
            long initialTime = System.nanoTime();

            // Recupera URL de conexão ao Mercuri.
            URL actionUrl = new URL(query.getActionUrl());
            logger.info("Mercuri URL:" + query.getActionUrl());

            // Conecta com o Mercuri.
            conn = (HttpURLConnection) actionUrl.openConnection();
            conn.setRequestMethod("POST");
            conn.setUseCaches(false);
            conn.setDoOutput(true);
            conn.setConnectTimeout(connectTimeout);
            conn.setReadTimeout(readTimeout);
            conn.connect();
            long connectTime = System.nanoTime();

            // Envia a requisição.
            os = new PrintWriter(conn.getOutputStream());
            query.writeRequest(os);
            os.flush();
            os.close();
            os = null;
            long sendTime = System.nanoTime();

//            Recupera a resposta através do código de resposta do HTTP.
//            int responseCode = conn.getResponseCode();
//            if (logger.isInfoEnabled()) {
//            	logger.info("Resposta Mercuri: " + responseCode);
//            }
//            if (responseCode != HttpURLConnection.HTTP_OK) {
//            	throw new IOException("httpRespCode = " + responseCode);
//            }
            
            String response = convertStreamToString(conn.getInputStream());
            logger.info("Mercuri Response -> " + response);
            query.processResponse(response);

            long responseTime = System.nanoTime();

            if (logger.isInfoEnabled())
            {
                logger.info("Requisição Mercuri:" + " Conexão = "
                            + ((connectTime - initialTime) / 1e+6)
                            + " ms, Envio = "
                            + ((sendTime - connectTime) / 1e+6)
                            + " ms, Resposta = "
                            + ((responseTime - sendTime) / 1e+6)
                            + " ms");
            }
        }
        // Erro de I/O, devemos ler o error stream e liberar a conexão
        catch (IOException e)
        {
            InputStream es = null;
            try
            {
                StringBuilder message = new StringBuilder();
                message.append("Mercuri I/O: " + e.getMessage());
                es = ((HttpURLConnection) conn).getErrorStream();
                if (es != null)
                {
                    BufferedReader in = new BufferedReader(new InputStreamReader(es));
                    message.append(", message = ");
                    String inputLine;
                    while ((inputLine = in.readLine()) != null)
                    {
                        message.append(inputLine);
                    }
                }
                MercuriException me = new MercuriException(message.toString(), e);
                throw me;
            }
            catch (IOException ex)
            {
                logger.warn("Falha na leitura da mensagem de erro de comunicação com Mercuri: " + ex.getMessage());
                MercuriException me = new MercuriException("Mercuri I/O: " + e.getMessage(),
                                                           e);
                throw me;
            }
            finally
            {
                if (es != null)
                {
                    try
                    {
                        es.close();
                    }
                    catch (IOException e1)
                    {
                        logger.warn("Falha no fechamento do input stream de erro: " + e1.getMessage());
                    }
                }
            }
        }
        catch (Exception e)
        {
            MercuriException me = new MercuriException("Mercuri I/O: " + e.getMessage(),
                                                       e);
            throw me;
        }
        finally
        {
            if (os != null)
            {
                try
                {
                    os.close();
                }
                catch (Exception e)
                {
                    logger.warn("Falha no fechamento do output stream: " + e.getMessage());
                }
            }
            if (is != null)
            {
                try
                {
                    is.close();
                }
                catch (Exception e)
                {
                    logger.warn("Falha no fechamento do input stream: " + e.getMessage());
                }
            }
        }
    }
    
    public void setBillingUrl(String billingUrl)
    {
        this.billingUrl = billingUrl;
    }

    public void setConnectionFactory(ConnectionFactoryImpl connectionFactory)
    {
        this.connectionFactory = connectionFactory;
    }

    public void setConnectTimeout(int connectTimeout)
    {
        this.connectTimeout = connectTimeout;
    }
    
    public void setReadTimeout(int readTimeout)
    {
        this.readTimeout = readTimeout;
    }
    


    public String convertStreamToString(InputStream is) throws IOException {
        /*
         * To convert the InputStream to String we use the
         * Reader.read(char[] buffer) method. We iterate until the
         * Reader return -1 which means there's no more data to
         * read. We use the StringWriter class to produce the string.
         */
    	
        if (is != null) {
            Writer writer = new StringWriter();

            char[] buffer = new char[1024];
            try {
                Reader reader = new BufferedReader(
                        new InputStreamReader(is, "UTF-8"));
                int n;
                while ((n = reader.read(buffer)) != -1) {
                    writer.write(buffer, 0, n);
                }
            } finally {
                is.close();
            }
            return writer.toString();
        } else {        
            return "";
        }
    }
    

}
