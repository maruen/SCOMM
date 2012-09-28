package br.com.supportcomm.virtualgoodscore.billing;

/**
 * Status do cr�dito do cliente para uma opera��o de cobran�a.
 */
public enum CreditStatus
{
    /**
     * Cliente possui cr�dito suficiente para a cobran�a.
     */
    ENOUGH_CREDIT, 
    
    /**
     * Cliente n�o possui cr�dito suficiente para a cobran�a.
     */
    INSUFFICIENT_CREDIT, 
    
    /**
     * Falha na consulta de cr�dito.
     */
    BILLING_SYSTEM_FAILURE;
}
