package br.com.supportcomm.virtualgoodscore.util.mercuri;

public class ConnectionFactoryImpl implements ConnectionFactory
{
    private String billingUrl;
    private int connectTimeout = 10000;
    private int readTimeout = 10000;
    
    public ConnectionFactoryImpl()
    {
    }
    
    @Override
    public Connection getConnection()
    {
        ConnectionImpl connection = new ConnectionImpl();
        connection.setBillingUrl(billingUrl);
        connection.setConnectTimeout(connectTimeout);
        connection.setReadTimeout(readTimeout);
        connection.setConnectionFactory(this);
        return connection;
    }
    
    public void setBaseUrl(String baseUrl)
    {
        String prefix = baseUrl;
        if (!prefix.endsWith("/"))
        {
            prefix += "/";
        }
        this.billingUrl = prefix + "bill/InterfaceBILL";
    }
    
    public void setBillingUrl(String billingUrl)
    {
        this.billingUrl = billingUrl;
    }

    public void setConnectTimeout(int connectTimeout)
    {
        this.connectTimeout = connectTimeout;
    }

    public void setReadTimeout(int readTimeout)
    {
        this.readTimeout = readTimeout;
    }

    protected void close(ConnectionImpl connection)
    {
    }
    
}
