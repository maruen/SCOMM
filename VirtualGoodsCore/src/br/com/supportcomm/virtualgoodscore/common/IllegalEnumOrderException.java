package br.com.supportcomm.virtualgoodscore.common;

/**
 * Indica que o enum possui ordem incompatível com a declaração.
 */
public class IllegalEnumOrderException extends VirtualGoodsRuntimeException
{
    private static final long serialVersionUID = 986630558190499577L;

    public IllegalEnumOrderException(String message)
    {
        super(message);
    }
}