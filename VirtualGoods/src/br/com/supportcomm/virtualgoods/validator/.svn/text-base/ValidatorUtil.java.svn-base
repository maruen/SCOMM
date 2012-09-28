package br.com.supportcomm.virtualgoods.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorUtil {
	
	
	public static boolean validaEmail(String email){
		boolean valor = true;
		
		Pattern p = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@(([\\w-]{2,63}\\.)+[A-Za-z]{2,6}|\\[\\d{1,3}(\\.\\d{1,3}){3}\\])$");   
		Matcher m = p.matcher(email); 
		
		if (!m.find()) {   
		    valor = false;
		}   
		
		return valor;
	}
}
