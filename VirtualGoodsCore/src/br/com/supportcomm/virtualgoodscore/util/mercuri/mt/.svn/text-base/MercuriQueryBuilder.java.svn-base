package br.com.supportcomm.virtualgoodscore.util.mercuri.mt;

import java.io.InputStream;

public interface MercuriQueryBuilder extends MercuriQuery, Cloneable
{
    /**
     * Recupera a string representando a query a ser enviada para o Mercuri.
     * 
     * @return String representando a query.
     */
    public abstract String getRequestBody();
    
    /**
     * Cria um clone da query.
     * 
     * @return Clone da query.
     * 
     * @throws CloneNotSupportedException
     */
    public abstract Object clone() throws CloneNotSupportedException;
    
    /**
     * Define a conexão ao Mercuri.
     * 
     * @param connection
     */
    public abstract void setConnection(MercuriConnection connection);

    /**
     * Processar resposta da query.
     * 
     * @param is Resposta da query.
     * 
     * @throws Exception
     */
    public abstract void process(InputStream is) throws Exception;

    public abstract String getFunctionName();

}