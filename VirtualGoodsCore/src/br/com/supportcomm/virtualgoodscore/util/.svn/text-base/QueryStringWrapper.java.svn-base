package br.com.supportcomm.virtualgoodscore.util;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Map.Entry;

public class QueryStringWrapper
{
    private Map<String, String> props = new HashMap<String, String>();

    public QueryStringWrapper()
    {
    }
    
    public QueryStringWrapper(String queryString)
    {
        if (queryString != null)
        {
            StringTokenizer parameters = new StringTokenizer(queryString, "&");
            while(parameters.hasMoreTokens())
            {
                String[] parts = parameters.nextToken().split("=", 2);
                if (parts.length == 2)
                {
                    props.put(parts[0], parts[1]);
                }
            }
        }
    }
    
    public String getParameter(String name)
    {
        return props.get(name);
    }
    
    public void setParameter(String name, String value)
    {
        if (name != null && value != null)
        {
            props.put(name, value);
        }
    }
    
    @Override
    public String toString()
    {
        boolean afterFirst = false;
        StringBuilder sb = new StringBuilder();
        for (Entry<String, String> entry : props.entrySet())
        {
            if (afterFirst)
            {
                sb.append("&");
            }
            sb.append(entry.getKey());
            sb.append("=");
            if (entry.getValue() != null)
            {
                sb.append(entry.getValue());
            }
            afterFirst = true;
        }
        return sb.toString();
    }
    
    public static void main(String[] args)
    {
        String params = "&&a&b=1&c_d_e=2&";
        QueryStringWrapper qsb = new QueryStringWrapper(params);
        System.out.println(qsb.toString());
        qsb.setParameter("teste", "abc");
        System.out.println(qsb.toString());
        System.out.println(qsb.getParameter("teste"));
    }

}