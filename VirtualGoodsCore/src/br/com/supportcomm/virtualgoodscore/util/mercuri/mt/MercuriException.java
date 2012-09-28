package br.com.supportcomm.virtualgoodscore.util.mercuri.mt;

/**
 * Classe de exce��o na comunica��o com o Mercuri.
 *  
 * @author felipe.curilla
 */
public class MercuriException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    public MercuriException(String message)
    {
        super(message);
    }

    public MercuriException(String message, Throwable t)
    {
        super(message, t);
    }
}