package br.com.supportcomm.virtualgoods.smsmo;

import java.util.Map;

public class MORequest {
	
	private String originationNumber;
    private String destinationNumber;
    private String textMessage;
    private String carrier;
    private Map<String, String> sessionData;
    private String extraInfo;

    public String getDestinationNumber()
    {
        return destinationNumber;
    }

    public void setDestinationNumber(String destinationNumber)
    {
        this.destinationNumber = destinationNumber;
    }

    public Map<String, String> getSessionData()
    {
        return sessionData;
    }

    public void setSessionData(Map<String, String> sessionData)
    {
        this.sessionData = sessionData;
    }

    public String getOriginationNumber()
    {
        return originationNumber;
    }

    public void setOriginationNumber(String sourceNumber)
    {
        this.originationNumber = sourceNumber;
    }

    public String getTextMessage()
    {
        return textMessage;
    }

    public void setTextMessage(String textMessage)
    {
        this.textMessage = textMessage;
    }
    
    public String getCarrier()
    {
        return carrier;
    }

    public void setCarrier(String carrier)
    {
        this.carrier = carrier;
    }

    public void setExtraInfo(String extraInfo)
    {
        this.extraInfo = extraInfo;
    }
    
    public String getExtraInfo()
    {
        return extraInfo;
    }
    
    public String toString()
    {
        StringBuilder sb = new StringBuilder("MORequest[");
        sb.append("origem=").append(originationNumber).append(", ");
        sb.append("destino=").append(destinationNumber).append(", ");
        sb.append("texto=").append(textMessage).append(", ");
        sb.append("operadora=").append(carrier).append(", ");
        sb.append("extraInfo=").append(extraInfo).append(", ");
        sb.append("sessao=").append(sessionData).append("]");
        return sb.toString();
    }

}
