package br.com.supportcomm.virtualgoodscore.billing.service;

import java.io.Serializable;

import br.com.supportcomm.virtualgoodscore.billing.CreditStatus;

public class CheckCreditResponse implements Serializable
{
    private static final long serialVersionUID = 904644282975632818L;
    private CreditStatus creditStatus;
    private int chargeValue;

    public CreditStatus getCreditStatus()
    {
        return creditStatus;
    }

    public void setCreditStatus(CreditStatus creditStatus)
    {
        this.creditStatus = creditStatus;
    }
    
    public int getChargeValue()
    {
        return chargeValue;
    }

    public void setChargeValue(int chargeValue)
    {
        this.chargeValue = chargeValue;
    }

    @Override
    public String toString()
    {
        return "CheckCreditResponse[status=" + creditStatus + "]";
    }
}
