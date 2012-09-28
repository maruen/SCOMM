package br.com.supportcomm.virtualgoodscore.util.mercuri;

import java.io.PrintWriter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Requisição de billing para o Mercuri.
 */
public class BillingQuery extends MercuriQuery
{
    public static final String RESULT_CHARGING_PLAN = "chargingPlan";
    
    public static final String RESULT_CODE = "code";
    public static final String RESULT_MSG = "msg";
    
    public static final String ENOUGH_CREDIT_CODE = "0";
    public static final String INSUFICIENT_CREDIT_CODE = "35";
    
    public static final String TAG_CODE_START = "<code>";
    public static final String TAG_CODE_END = "</code>";
    
    public static final String TAG_MSG_START = "<msg>";
    public static final String TAG_MSG_END = "</msg>";

    private String originator;
    private String destination;
    private String carrier;
    private String billingData;
    private String billingCode;
    private String action;
    private String info;

    private static final Log logger = LogFactory.getLog(BillingQuery.class);

    public void setBillingCode(String billingCode)
    {
        this.billingCode = billingCode;
    }

    public void setBillingData(String billingData)
    {
        this.billingData = billingData;
    }

    public void setCarrier(String carrier)
    {
        this.carrier = carrier;
    }
    
    public void setInfo(String info)
    {
        this.info = info;
    }

    /**
     * Define que a operação a ser feita é de cobrança.
     */
    public void setChargeAction()
    {
        this.action = "charge";
    }

    /**
     * Define que a operação a ser feita é de verificação de crédito.
     */
    public void setCheckCreditAction()
    {
        this.action = "check";
    }

    public void setDestination(String destination)
    {
        this.destination = destination;
    }

    public void setOriginator(String originator)
    {
        this.originator = originator;
    }

    protected void processResponse(String response) throws Exception
    {

    	try {
    		String code = response.substring(response.indexOf(TAG_CODE_START) + TAG_CODE_START.length() ,response.indexOf(TAG_CODE_END));
    		setResult(RESULT_CODE, code);
    		logger.debug("Returned Code = " + code);
    	} catch (Exception exp) {
    		logger.error("Error while parsing code field from XML returned from Mercuri: " + exp.getMessage());
    	}

    	try {
    		String msg = response.substring(response.indexOf(TAG_MSG_START) + TAG_MSG_START.length(),response.indexOf(TAG_MSG_END));
    		setResult(RESULT_MSG, msg);
    		logger.debug("Returned msg = " + msg);
    		
    		String[] parts = msg.split("\\|");
            if (parts.length > 1)
            {
                String chargingPlan = parts[1];
                setResult(RESULT_CHARGING_PLAN, chargingPlan);
                logger.debug("Returned chargingPlan = " + chargingPlan);
            }
    		
    	} catch (Exception exp) {
    		logger.error("Error while parsing msg field from XML returned from Mercuri" + exp.getMessage());
    	}

    }

    protected void writeRequest(PrintWriter out)
    {
        
    	StringBuffer sbf = new StringBuffer();
    	String endLine = "\n";
    	
    	out.write("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?><Operation>");
        sbf.append("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?><Operation>").append(endLine);
        
        out.write("<ApplicationContext>");
        sbf.append("<ApplicationContext>").append(endLine);;
        
        out.write("<ApplicationService>");
        sbf.append("<ApplicationService>").append(endLine);;
        
        out.write(getServiceId());
        sbf.append(getServiceId()).append(endLine);;
        
        out.write("</ApplicationService>");
        sbf.append("</ApplicationService>").append(endLine);;
        
        out.write("<ApplicationItem>");
        sbf.append("<ApplicationItem>").append(endLine);;
        
        out.write(getItemId());
        sbf.append(getItemId()).append(endLine);;
        
        out.write("</ApplicationItem>");
        sbf.append("</ApplicationItem>").append(endLine);;
        
        out.write("<AcessControl>");
        sbf.append("<AcessControl>").append(endLine);;
        
        out.write("<ApplicationIdentity>");
        sbf.append("<ApplicationIdentity>").append(endLine);;
        
        out.write(getUsername());
        sbf.append(getUsername()).append(endLine);;
        
        out.write("</ApplicationIdentity>");
        sbf.append("</ApplicationIdentity>").append(endLine);;
                
        out.write("<Authentication>");
        sbf.append("<Authentication>").append(endLine);;
        
        out.write("<Password>");
        sbf.append("<Password>").append(endLine);;
        
        out.write(getPassword());
        sbf.append(getPassword()).append(endLine);;
        
        
        out.write("</Password>");
        sbf.append("</Password>").append(endLine);;
        
        
        out.write("</Authentication>");
        sbf.append("</Authentication>").append(endLine);;
        
        
        out.write("</AcessControl>");
        sbf.append("</AcessControl>").append(endLine);;
        
        
        out.write("</ApplicationContext>");
        sbf.append("</ApplicationContext>").append(endLine);;
        
        
        out.write("<SubmitRequest>");
        sbf.append("<SubmitRequest>").append(endLine);;
        
        
        out.write("<Billing>");
        sbf.append("<Billing>").append(endLine);;
        
        
        out.write("<Header>");
        sbf.append("<Header>").append(endLine);;
        
        
        if (billingData != null)
        {
            out.write("<BillingData>");
            sbf.append("<BillingData>").append(endLine);;
            
            out.write(billingData);
            sbf.append(billingData).append(endLine);;
            
            
            out.write("</BillingData>");
            sbf.append("</BillingData>").append(endLine);;
            
        }
        if (billingCode != null)
        {
            out.write("<BillingCode>");
            sbf.append("<BillingCode>").append(endLine);;
            
            out.write(billingCode);
            sbf.append(billingCode).append(endLine);;
            
                        
            out.write("</BillingCode>");
            sbf.append("</BillingCode>").append(endLine);;
            
            
        }
        if (originator != null)
        {
            out.write("<Originator>");
            sbf.append("<Originator>").append(endLine);;
            
            out.write(originator);
            sbf.append(originator).append(endLine);;
            
            out.write("</Originator>");
            sbf.append("</Originator>").append(endLine);;
            
        }
        out.write("<Action>");
        sbf.append("<Action>").append(endLine);;
        
        out.write(action);
        sbf.append(action).append(endLine);;
                
        out.write("</Action>");
        sbf.append("</Action>").append(endLine);;
        
        
        out.write("<Destination>");
        sbf.append("<Destination>").append(endLine);;
        
        
        out.write("<Number");
        sbf.append("<Number").append(" ");
        
        
        if (carrier != null)
        {
            out.write(" carrierId=\"");
            sbf.append(" carrierId=\"");
            
            out.write(carrier);
            sbf.append(carrier);
            
            out.write("\"");
            sbf.append("\"");
            
        }
        
        out.write(">");
        sbf.append(">").append(endLine);
        
        out.write(destination);
        sbf.append(destination).append(endLine);;
        
        out.write("</Number>");
        sbf.append("</Number>").append(endLine);;
        
        
        out.write("</Destination>");
        sbf.append("</Destination>").append(endLine);;
        
        
        if (info != null)
        {
            out.write("<Info>");
            sbf.append("<Info>").append(endLine);;
            
            
            out.write("<![CDATA[" + info + "]]>");
            sbf.append("<![CDATA[" + info + "]]>").append(endLine);;
            
            
            out.write("</Info>");
            sbf.append("</Info>").append(endLine);;
            
        }
        
        out.write("</Header>");
        sbf.append("</Header>").append(endLine);;
        
        
        out.write("</Billing>");
        sbf.append("</Billing>").append(endLine);;
        
        out.write("</SubmitRequest>");
        sbf.append("</SubmitRequest>").append(endLine);;
        
        out.write("</Operation>\n");
        sbf.append("</Operation>\n").append(endLine);;
        
        logger.info(sbf.toString());
        
    }

}
