package br.com.supportcomm.virtualgoodscore.billing;

import br.com.supportcomm.virtualgoodscore.common.IllegalEnumOrderException;

/**
 * Tipo específico de erro na cobrança. 
 */
public enum ChargeErrorType
{
    /**
     * Crédito insuficiente para a cobrança.
     */
    INSUFFICIENT_CREDIT(0), 
    
    /**
     * Sistema de billing retornou falha.
     */
    BILLING_SYSTEM_FAILURE(1),
    
    /**
     * Timeout na resposta do sistema de billing.
     */
    TIMEOUT(2);
    
    /**
     * Construtor que valida a ordem do enum.
     * 
     * @param order
     */
    private ChargeErrorType(int order)
    {
        // Valida a ordem do enum
        if (order != ordinal())
        {
            throw new IllegalEnumOrderException("Ordem do inválida para enum: " + name());
        }
    }

}