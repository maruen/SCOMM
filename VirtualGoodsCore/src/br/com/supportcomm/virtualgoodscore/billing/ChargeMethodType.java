package br.com.supportcomm.virtualgoodscore.billing;

import br.com.supportcomm.virtualgoodscore.common.IllegalEnumOrderException;

/**
 * Tipo de cobrança
 * ATENÇÃO: Não remova enums ou altere a ordem pois ela é usada no banco de dados.<br>
 */
public enum ChargeMethodType
{
    CREDIT_CARD(0), MOBILE_CARRIER(1), CUBE_ACCOUNT(2);

    /**
     * Construtor que valida a ordem do enum.
     * 
     * @param order
     */
    private ChargeMethodType(int order)
    {
        // Valida a ordem do enum
        if (order != ordinal())
        {
            throw new IllegalEnumOrderException("Ordem do inválida para enum: " + name());
        }
    }
}