package br.com.supportcomm.virtualgoodscore.billing.service.platform.mercuri;

import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.supportcomm.virtualgoodscore.billing.ChargeErrorType;
import br.com.supportcomm.virtualgoodscore.billing.ChargeStatus;
import br.com.supportcomm.virtualgoodscore.billing.CreditStatus;
import br.com.supportcomm.virtualgoodscore.billing.service.ChargeResponse;
import br.com.supportcomm.virtualgoodscore.billing.service.CheckCreditResponse;
import br.com.supportcomm.virtualgoodscore.billing.service.platform.BillingPlatform;
import br.com.supportcomm.virtualgoodscore.pojo.Transacao;
import br.com.supportcomm.virtualgoodscore.util.mercuri.BillingQuery;
import br.com.supportcomm.virtualgoodscore.util.mercuri.Connection;
import br.com.supportcomm.virtualgoodscore.util.mercuri.ConnectionFactory;
import br.com.supportcomm.virtualgoodscore.util.mercuri.ConnectionFactoryImpl;

/**
 * Implementação do {@link BillingPlatform} para operadora de celular usando
 * Mercuri.
 */
public class BillingPlatformMercuri implements BillingPlatform
{
    /*private static final String MERCURI_CARRIER_ID = "mercuri.carrierId";
    private static final String MERCURI_ITEM_ID = "mercuri.itemId";
    private static final String MERCURI_SERVICE_ID = "mercuri.serviceId";
    private static final String MERCURI_PASSWORD = "mercuri.password";
    private static final String MERCURI_USERNAME = "mercuri.username";*/
    private String platformName = "Mercuri";
    private ConnectionFactory connectionFactory;
    private static final Log logger = LogFactory.getLog(BillingPlatformMercuri.class);

    @Override
    public CheckCreditResponse checkCredit(Transacao t)
    {
        CheckCreditResponse response = new CheckCreditResponse();
        ConnectionFactoryImpl con = new ConnectionFactoryImpl();
        con.setBaseUrl(t.getSharecode().getMercuriUrl());
        connectionFactory = con;
        Connection connection = connectionFactory.getConnection();
        /*CarrierChargeInfo carrierChargeInfo = (CarrierChargeInfo) chargeInfo;*/

        try
        {
            BillingQuery query = connection.createBillingQuery();
            query.setUsername(t.getSharecode().getMercuriUsername());
            query.setPassword(t.getSharecode().getMercuriPassword());
            query.setServiceId(new Integer(t.getSharecode().getMercuriServiceId()).toString());
            query.setItemId(new Integer(t.getSharecode().getMercuriItemId()).toString());
            query.setCheckCreditAction();
            query.setBillingCode(t.getSharecode().getNome());
            query.setBillingData("sngValorItem=" + new Double(t.getValorTarifacao()).toString().replace(".", ""));
            query.setDestination(t.getMsisdn());
            query.setCarrier(new Integer(t.getOperadora()).toString());
            Properties result = query.execute();

            String resultCode = result.getProperty(BillingQuery.RESULT_CODE);
            if (BillingQuery.ENOUGH_CREDIT_CODE.equals(resultCode))
            {
                response.setCreditStatus(CreditStatus.ENOUGH_CREDIT);
            }
            else if (BillingQuery.INSUFICIENT_CREDIT_CODE.equals(resultCode))
            {
                response.setCreditStatus(CreditStatus.INSUFFICIENT_CREDIT);
            }
            else
            {
                response.setCreditStatus(CreditStatus.BILLING_SYSTEM_FAILURE);
            }
        }
        catch (Exception e)
        {
            logger.error("Falha na verificação de crédito: " + e.getMessage(), e);
            response.setCreditStatus(CreditStatus.BILLING_SYSTEM_FAILURE);
        }
        finally
        {
            connection.close();
        }

        return response;
    }

    @Override
    public ChargeResponse executeCharge(Transacao t)
    {
        ChargeResponse response = new ChargeResponse();
        ConnectionFactoryImpl con = new ConnectionFactoryImpl();
        con.setBaseUrl(t.getSharecode().getMercuriUrl());
        connectionFactory = con;
        Connection connection = connectionFactory.getConnection();
        
        /*if (!(chargeInfo instanceof CarrierChargeInfo))
        {
            throw new InvalidRequestException("ChargeInfo deve ser do tipo CarrierChargeInfo");
        }
        CarrierChargeInfo carrierChargeInfo = (CarrierChargeInfo) chargeInfo;*/

        try
        {
            BillingQuery query = connection.createBillingQuery();
            query.setUsername(t.getSharecode().getMercuriUsername());
            query.setPassword(t.getSharecode().getMercuriPassword());
            query.setServiceId(new Integer(t.getSharecode().getMercuriServiceId()).toString());
            query.setItemId(new Integer(t.getSharecode().getMercuriItemId()).toString());
            query.setBillingCode(t.getSharecode().getNome());
            query.setBillingData("sngValorItem=" + new Double(t.getValorTarifacao()).toString().replace(".", ""));

            /*QueryStringWrapper infoData = new QueryStringWrapper(chargeInfo.getExtraInfo());
            infoData.setParameter("channelId", Integer.toString(recordData.getChannelId()));
            query.setInfo(infoData.toString());*/

            query.setDestination(t.getMsisdn());
            query.setCarrier(new Integer(t.getOperadora()).toString());
            // Check credit
            query.setCheckCreditAction();
            Properties result = query.execute();
            String resultCode = result.getProperty(BillingQuery.RESULT_CODE);
            if (BillingQuery.ENOUGH_CREDIT_CODE.equals(resultCode))
            {
                // Charge
                query.setChargeAction();
                result = query.execute();
                resultCode = result.getProperty(BillingQuery.RESULT_CODE);
                if (BillingQuery.ENOUGH_CREDIT_CODE.equals(resultCode))
                {
                    response.setChargeStatus(ChargeStatus.CHARGED);
                }
                else if (BillingQuery.INSUFICIENT_CREDIT_CODE.equals(resultCode))
                {
                    response.setChargeStatus(ChargeStatus.CHARGE_FAILURE);
                    response.setChargeErrorType(ChargeErrorType.INSUFFICIENT_CREDIT);
                }
                else
                {
                    response.setChargeStatus(ChargeStatus.CHARGE_FAILURE);
                    response.setChargeErrorType(ChargeErrorType.BILLING_SYSTEM_FAILURE);
                    response.setErrorMessage(result.getProperty(BillingQuery.RESULT_MSG));
                }
            }
            else if (BillingQuery.INSUFICIENT_CREDIT_CODE.equals(resultCode))
            {
                response.setChargeStatus(ChargeStatus.CHARGE_FAILURE);
                response.setChargeErrorType(ChargeErrorType.INSUFFICIENT_CREDIT);
            }
            else
            {
                response.setChargeStatus(ChargeStatus.CHARGE_FAILURE);
                response.setChargeErrorType(ChargeErrorType.BILLING_SYSTEM_FAILURE);
                response.setErrorMessage(result.getProperty(BillingQuery.RESULT_MSG));
            }
        }
        catch (Exception e)
        {
            logger.error("Falha na cobrança: " + e.getMessage(), e);
            response.setChargeStatus(ChargeStatus.CHARGE_FAILURE);
            response.setChargeErrorType(ChargeErrorType.BILLING_SYSTEM_FAILURE);
            response.setErrorMessage(e.getMessage());
        }
        finally
        {
            connection.close();            
            logger.debug(String.format("Resultado da cobrança: response: %s", response));
        }
        
        cleanErrorMsg(response);
        
        return response;
    }

    private void cleanErrorMsg(ChargeResponse response)
    {
        String errorMessage = response.getErrorMessage();
        
        if (errorMessage != null)
        {
            errorMessage = errorMessage.trim();
            int start = errorMessage.indexOf("MSG[");
            errorMessage = errorMessage.substring((start < 0 ? 0 : start));
            response.setErrorMessage(errorMessage);
        }
    }

    /*@Override
    public RefundResponse refundCharge(BillingRecord billingRecord)
    {
        RefundResponse response = new RefundResponse();
        response.setRefundStatus(RefundStatus.REFUND_NOT_SUPPORTED);
        return response;
    }*/

    @Override
    public String getPlatformName()
    {
        return platformName;
    }
}
