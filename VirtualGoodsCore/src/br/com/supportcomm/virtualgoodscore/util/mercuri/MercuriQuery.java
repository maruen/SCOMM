package br.com.supportcomm.virtualgoodscore.util.mercuri;

import java.io.PrintWriter;
import java.util.Properties;

/**
 * Classe base para requisições para o Mercuri.
 */
public abstract class MercuriQuery
{
    private String serviceId;
    private String itemId;
    private String username;
    private String password;
    private String actionUrl;
    private ConnectionImpl connection;
    private Properties result;
    
    public final Properties execute()
    {
        result = new Properties();
        connection.send(this);
        return result;
    }
    
    public String getItemId()
    {
        return itemId;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public String getServiceId()
    {
        return serviceId;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public void setItemId(String itemId)
    {
        this.itemId = itemId;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setServiceId(String serviceId)
    {
        this.serviceId = serviceId;
    }

    public void setUsername(String user)
    {
        this.username = user;
    }

    protected final String getActionUrl()
    {
        return actionUrl;
    }

    /**
     * Processa a resposta da requisição.
     * 
     * @param is InputStream com a resposta da requisição.
     * 
     * @throws Exception
     */
    protected abstract void processResponse(String response) throws Exception;

    protected final void setActionUrl(String functionName)
    {
        this.actionUrl = functionName;
    }

    protected final void setConnection(ConnectionImpl connection)
    {
        this.connection = connection;
    }

    protected final void setResult(String name, String value)
    {
        result.setProperty(name, value);
    }

    /**
     * Escreve a requisição.
     * 
     * @param out PrintWriter.
     */
    protected abstract void writeRequest(PrintWriter out);
    
}
