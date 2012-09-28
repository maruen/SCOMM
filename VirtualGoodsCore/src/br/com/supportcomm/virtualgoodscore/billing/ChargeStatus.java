package br.com.supportcomm.virtualgoodscore.billing;

import br.com.supportcomm.virtualgoodscore.common.IllegalEnumOrderException;

/**
 * Resultado da cobran�a.
 */
public enum ChargeStatus
{
    /**
     * Cliente foi cobrado.
     */
    CHARGED(0), 
    
    /**
     * Falha na cobran�a.
     */
    CHARGE_FAILURE(1), 
    
    /**
     * Cobran�a em andamento.
     */
    ONGOING(2),
    
    /**
     * Cobran�a est� pendente.
     */
    PENDING(3);
    
    /**
     * Construtor que valida a ordem do enum.
     * 
     * @param order
     */
    private ChargeStatus(int order)
    {
        // Valida a ordem do enum
        if (order != ordinal())
        {
            throw new IllegalEnumOrderException("Ordem do inv�lida para enum: " + name());
        }
    }

}
