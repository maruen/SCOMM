package br.com.supportcomm.virtualgoodscore.billing;

import br.com.supportcomm.virtualgoodscore.common.IllegalEnumOrderException;

/**
 * Resultado da cobrança.
 */
public enum ChargeStatus
{
    /**
     * Cliente foi cobrado.
     */
    CHARGED(0), 
    
    /**
     * Falha na cobrança.
     */
    CHARGE_FAILURE(1), 
    
    /**
     * Cobrança em andamento.
     */
    ONGOING(2),
    
    /**
     * Cobrança está pendente.
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
            throw new IllegalEnumOrderException("Ordem do inválida para enum: " + name());
        }
    }

}
