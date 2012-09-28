package br.com.supportcomm.virtualgoodscore.util.mercuri.mt;

import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Requisicao generica de envio SMS ao Mercuri.<br>
 * Pode ser usada para envio de SMS normal, WAP Push (definindo o campo UDH) ou SMS Link.<br>
 * Para SMS Link pode-se tambem usar a classe especifica {@link MercuriSmsLinkQuery}.<br>
 */
public class MercuriMTQuery implements MercuriQueryBuilder
{
    // Header e footer do MT.
    private static final String HEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><Operation>";
    private static final String FOOTER = "</Operation>\n";
    
    private static final String REQUEST_METHOD = "POST";

    private MercuriConnection connection; // objeto de conex�o ao Mercuri

    // Par�metros do servi�o
    private String serviceId;
    private String itemId;
    private String user;
    private String password;
    private String originator;

    // Par�metros definidos a cada requisi��o
    public static final String DESTINATION = "destination";
    public static final String MERCURI_CARRIER_ID = "mercuriCarrierId";
    public static final String TEXT = "text";
    public static final String SESSION_DATA = "sessionData";
    public static final String UDH = "udh";
    public static final String INFO = "info";
    
    private Properties params = new Properties();       // Guarda os par�metros da query
    private StringBuilder packet = new StringBuilder(); // Pacote XML do request MT
    
    private Log logger = LogFactory.getLog(this.getClass());
    private String functionName;

    public MercuriMTQuery()
    {
    }
    
    /**
     * Realiza o envio do MT para o Mercuri.
     */
    public void doQuery()
    {
        long start = System.nanoTime();
        connection.doRequest(this);
        long end = System.nanoTime();
        if (logger.isInfoEnabled())
        {
            double delay = (end - start) / 1e+6;
            logger.info("Requisi��o Mercuri " + ": Dura��o total = " + delay + " (ms)");
        }
    }

    /**
     * Recupera a string representando a query MT.
     * 
     * @return String representando a query MT.
     */
    public String getRequestBody()
    {
        packet.append(HEADER);
        appendBody(packet);
        packet.append(FOOTER);
        return packet.toString();
    }

    protected String getParameter(String name)
    {
        return params.getProperty(name);
    }
    
    /**
     * Monta a requisi��o MT ao Mercuri.
     */
    protected void appendBody(StringBuilder buffer)
    {
        buffer.append("<ApplicationContext>");
        buffer.append("<ApplicationService>" + serviceId + "</ApplicationService>");
        buffer.append("<ApplicationItem>" + itemId + "</ApplicationItem>");
        buffer.append("<AcessControl>");
        buffer.append("<ApplicationIdentity>" + user + "</ApplicationIdentity>");
        buffer.append("<Authentication>");
        buffer.append("<Password>" + password + "</Password>");
        buffer.append("</Authentication>");
        buffer.append("</AcessControl>");
        buffer.append("</ApplicationContext>");
        buffer.append("<SubmitRequest>");
        buffer.append("<ShortMessage>");
        buffer.append("<Header>");
        buffer.append("<Originator>" + originator + "</Originator>");
        buffer.append("<Destination>");
        appendDestination(buffer);
        buffer.append("</Destination>");
        appendInfo(buffer);
        buffer.append("</Header>");
        appendSessionData(buffer);
        buffer.append("<Body>");
        buffer.append("<Text>");
        appendUDH(buffer);
        appendText(buffer);
        buffer.append("</Text>");
        buffer.append("</Body>");
        buffer.append("</ShortMessage>");
        buffer.append("</SubmitRequest>");
    }

    private void appendInfo(StringBuilder buffer)
    {
        if (getParameter(INFO) != null)
        {
            buffer.append("<Info>");
            buffer.append("<![CDATA[" + getParameter(INFO) + "]]>");
            buffer.append("</Info>");
        }
    }

    protected void appendDestination(StringBuilder buffer)
    {
        buffer.append("<Number");
        
        String mercuriCarrierIdStr = getParameter(MERCURI_CARRIER_ID);
        if (mercuriCarrierIdStr != null)
        {
            long mercuriCarrierId = Long.parseLong(mercuriCarrierIdStr);
            
            if (mercuriCarrierId > 0)
            {
                buffer.append(" carrierId=\"" + mercuriCarrierId + "\"");
            }
        }
        
        buffer.append(">" + getParameter(DESTINATION) + "</Number>");
    }

    protected void appendText(StringBuilder buffer)
    {
        buffer.append("<![CDATA[" + getParameter(TEXT) + "]]>");
    }

    protected void appendUDH(StringBuilder buffer)
    {
        if (getParameter(UDH) != null)
        {
            buffer.append("<UDH>");
            buffer.append("<![CDATA[" + getParameter(UDH) + "]]>");
            buffer.append("</UDH>");
        }
    }

    protected void appendSessionData(StringBuilder buffer)
    {
        if (getParameter(SESSION_DATA) != null)
        {
            buffer.append("<Session>");
            buffer.append("<SessionData>");
            buffer.append("<![CDATA[" + getParameter(SESSION_DATA) + "]]>");
            buffer.append("</SessionData>");
            buffer.append("</Session>");
        }
    }

    public void setConnection(MercuriConnection conn)
    {
        this.connection = conn;
    }

    public void setItemId(String itemId)
    {
        this.itemId = itemId;
    }

    public void setOriginator(String originator)
    {
        this.originator = originator;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setServiceId(String serviceId)
    {
        this.serviceId = serviceId;
    }

    public void setUser(String user)
    {
        this.user = user;
    }

    public void addParameter(String name, String value)
    {
        params.setProperty(name, value);
    }

    /**
     * Executa a query sem lan�ar exce��es realizando apenas o log do eventual problema.
     */
    public void run()
    {
        try
        {
            this.doQuery();
        }
        catch(Exception e)
        {
            logger.error("Falha na execu��o da query do Mercuri " + this + ": " + e.getMessage(), e);
        }
    }

    public Object clone() throws CloneNotSupportedException
    {
        MercuriMTQuery query = (MercuriMTQuery) super.clone();
        // IMPORTANTE: Temos que trocar estes atributos, caso contr�rio, eles ser�o
        // compartilhados por todas as inst�ncias clonadas.
        query.packet = new StringBuilder();
        query.params = new Properties();
        return query;
    }

    public void process(InputStream is) throws Exception
    {
    }

    public String getResult(String name)
    {
        return null;
    }

    public String getFunctionName()
    {
        return this.functionName;
    }

    public void setFunctionName(String functionName)
    {
        this.functionName = functionName;
    }

    public String getRequestMethod()
    {
        return REQUEST_METHOD;
    }
}