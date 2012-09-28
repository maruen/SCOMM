package br.com.supportcomm.virtualgoods.taglibs;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

/**
 * 
 * @author maruen.mehana
 *
 */

public class ContainsTag extends BodyTagSupport  {

	
    private static final long serialVersionUID = 188218005035764204L;
    private ArrayList<String> list ;
    private String item; 

	public ArrayList<String> getList() {
    	return list;
    }

	public void setList(ArrayList<String> list) {
    	this.list = list;
    }

	public String getItem() {
    	return item;
    }

	public void setItem(String item) {
    	this.item = item;
    }
		
	public int doAfterBody() throws JspException {
        try {
            BodyContent bc = getBodyContent();
            String body = bc.getString();
            JspWriter out = bc.getEnclosingWriter();
            if (body != null) {
                if (list.contains(item)) {
                    out.print(body);
                }
            }
        } catch (IOException ioe) {
            throw new JspException("Error: " + ioe.getMessage());
        }
        return SKIP_BODY;
    }
	
	

}
