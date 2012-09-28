package br.com.supportcomm.virtualgoodscore.util.mercuri.mt;

/**
 * Interface para conex�o ao Mercuri.
 * 
 * @author felipe.curilla
 */
public interface MercuriConnection
{
    /**
     * Define o timeout de conex�o e leitura em milisegundos.
     * 
     * @param timeout Timeout em milisegundos.
     */
    public void setTimeout(int timeout);

    /**
     * Retorna a URL de conex�o.
     * 
     * @return URL de conex�o.
     */
    public String getUrl();

    /**
     * Define a URL da conex�o.
     * 
     * @param url URL da conex�o.
     */
    public void setUrl(String url);
    
    /**
     * Executa a requisi��o para o Mercuri.
     * 
     * @param query Consulta a ser executada.
     */
    public void doRequest(MercuriQueryBuilder query);
}