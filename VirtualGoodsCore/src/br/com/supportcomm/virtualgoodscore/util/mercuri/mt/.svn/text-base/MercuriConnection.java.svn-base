package br.com.supportcomm.virtualgoodscore.util.mercuri.mt;

/**
 * Interface para conexão ao Mercuri.
 * 
 * @author felipe.curilla
 */
public interface MercuriConnection
{
    /**
     * Define o timeout de conexão e leitura em milisegundos.
     * 
     * @param timeout Timeout em milisegundos.
     */
    public void setTimeout(int timeout);

    /**
     * Retorna a URL de conexão.
     * 
     * @return URL de conexão.
     */
    public String getUrl();

    /**
     * Define a URL da conexão.
     * 
     * @param url URL da conexão.
     */
    public void setUrl(String url);
    
    /**
     * Executa a requisição para o Mercuri.
     * 
     * @param query Consulta a ser executada.
     */
    public void doRequest(MercuriQueryBuilder query);
}