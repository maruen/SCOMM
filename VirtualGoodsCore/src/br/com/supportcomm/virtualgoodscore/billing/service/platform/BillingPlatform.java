package br.com.supportcomm.virtualgoodscore.billing.service.platform;

import br.com.supportcomm.virtualgoodscore.billing.service.ChargeResponse;
import br.com.supportcomm.virtualgoodscore.billing.service.CheckCreditResponse;
import br.com.supportcomm.virtualgoodscore.pojo.Transacao;

/**
 * Interface para a plataforma de billing.
 */
public interface BillingPlatform
{

    /**
     * Verifica se existe crédito suficiente para a cobrança indicada.
     * 
     * @param customer
     * @param priceLabel
     * @param chargeOption
     * @param chargeMethodOption
     * @param chargeInfo
     * 
     * @return Resposta da verificação de crédito.
     */
    CheckCreditResponse checkCredit(Transacao t);

    /**
     * Executa cobrança.<br>
     * Antes da cobrança é executada uma verificação de crédito.<br>
     * 
     * @param customer
     * @param priceLabel
     * @param chargeOption
     * @param chargeMethodOption
     * @param chargeInfo
     * @param recordData
     * @param ticketId
     * 
     * @return Resposta da cobrança.
     */
    ChargeResponse executeCharge(Transacao t);

    /**
     * Executa o estorno da cobrança indicada pelo registro do evento.
     * 
     * @param billingRecord Registro de billing.
     * 
     * @return Resposta de estorno.
     */
    /*RefundResponse refundCharge(BillingRecord billingRecord);*/

    /**
     * Recupera o nome de identificação da plataforma.
     * 
     * @return Nome da plataforma.
     */
    String getPlatformName();

}