package br.com.supportcomm.virtualgoodscore.util.mercuri.mt;

/**
 * Interface das queries ao Mercuri, que podem ser de MO, MT, WAP PUSH, etc.
 * 
 * @author felipe.curilla
 */
public interface MercuriQuery extends Runnable
{
    /**
     * Realiza o envio da requisição para o Mercuri.
     * 
     * @throws MercuriException
     */
    public abstract void doQuery() throws MercuriException;

    /**
     * Adiciona parâmetro à query.
     * 
     * @param name Nome do parâmetro.
     * @param value Valor do parâmetro.
     */
    public abstract void addParameter(String name, String value);
    
    /**
     * Recupera algum resultado retornado pelo Mercuri.
     * 
     * @param name Nome do parâmetro.
     * 
     * @return Resultado.
     */
    public abstract String getResult(String name);

}
