package br.com.supportcomm.virtualgoodscore.billing;

import br.com.supportcomm.virtualgoodscore.common.IllegalEnumOrderException;

/**
 * Tipo espec�fico de erro na cobran�a. 
 */
public enum ChargeErrorType
{
    /**
     * Cr�dito insuficiente para a cobran�a.
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
            throw new IllegalEnumOrderException("Ordem do inv�lida para enum: " + name());
        }
    }

}