package br.com.supportcomm.virtualgoodscore.billing.service;

import java.io.Serializable;

import br.com.supportcomm.virtualgoodscore.billing.*;

/**
 * Resposta de cobrança.
 */
public class ChargeResponse implements Serializable
{
    private static final long serialVersionUID = 7577176577872429127L;
    private Long eventRecordId;
    private String platformTransactionId;
    private ChargeStatus chargeStatus;
    private ChargeErrorType chargeErrorType;
    private String errorMessage;
    /*private ChargeMethod chargeMethod;*/
    private int chargeValue;

    /**
     * Retorna o ID devolvido pela plataforma de billing.
     * 
     * @return ID devolvido pela plataforma de billing.
     */
    public String getPlatformTransactionId()
    {
        return platformTransactionId;
    }

    /**
     * Retorna o tipo específico do erro na cobrança.
     * 
     * @return tipo específico do erro na cobrança.
     */
    public final ChargeErrorType getChargeErrorType()
    {
        return chargeErrorType;
    }

    /**
     * Retorna o status da cobrança.
     * 
     * @return status da cobrança.
     */
    public ChargeStatus getChargeStatus()
    {
        return chargeStatus;
    }

    /**
     * Retorna o ID do evento de cobrança.
     * 
     * @return ID do evento de cobrança.
     */
    public final Long getEventRecordId()
    {
        return eventRecordId;
    }

    public void setPlatformTransactionId(String billingTransactionId)
    {
        this.platformTransactionId = billingTransactionId;
    }

    public final void setChargeErrorType(ChargeErrorType chargeErrorType)
    {
        this.chargeErrorType = chargeErrorType;
    }

    public void setChargeStatus(ChargeStatus status)
    {
        this.chargeStatus = status;
    }

    public final void setEventRecordId(Long eventRecordId)
    {
        this.eventRecordId = eventRecordId;
    }

    public String getErrorMessage()
    {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage)
    {
        this.errorMessage = errorMessage;
    }

    public int getChargeValue()
    {
        return chargeValue;
    }

    /*public ChargeMethodType getChargeMethodType()
    {
        return chargeMethod.getType();
    }*/
    
    /*public ChargeMethod getChargeMethod()
    {
        return chargeMethod;
    }
    
    public void setChargeMethod(ChargeMethod chargeMethod)
    {
        this.chargeMethod = chargeMethod;
    }*/
    
    public void setChargeValue(int chargeValue)
    {
        this.chargeValue = chargeValue;
    }

    @Override
    public String toString()
    {
        return "ChargeResponse[eventRecordId=" + eventRecordId
               /*+ ", chargeMethod="
               + chargeMethod*/
               + ", chargeValue="
               + chargeValue
               + ", chargeStatus="
               + chargeStatus
               + ", chargeError="
               + chargeErrorType
               + ", errorMessage="
               + errorMessage
               + "]";
    }

}