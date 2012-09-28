package br.com.supportcomm.virtualgoodscore.util.mercuri;

/**
 * Conex�o com o Mercuri.
 */
public interface Connection
{
    /**
     * Cria requisi��o de billing para o Mercuri.
     * 
     * @return
     */
    BillingQuery createBillingQuery();
    
    /**
     * Fecha conex�o com o Mercuri.
     */
    void close();

}
