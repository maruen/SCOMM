package br.com.supportcomm.virtualgoods.utilities;

import java.util.Calendar;

import br.com.supportcomm.virtualgoodscore.pojo.BillingRecordSuccess;


public class Utils {
	

	public static String fomatMTMessage(String message, String... params) {
		
		for (String param : params) {
			message = message.replaceFirst("%p", param);
		}
		return message;
	}
	
	public static String fomatVoucherMessage(String message, String... params) {
		
		for (String param : params) {
			message = message.replaceFirst("%v", param);
		}
		return message;
	}
	
	
	public static String getFormattedProtocol(BillingRecordSuccess record) {
		
		Long protocol = record.getProtocol();
		String last11digits = String.format("%011d", protocol);
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(record.getDtCompra());
		Integer year = cal.get(Calendar.YEAR);
		String yearAsString = String.valueOf(year);
		String twoDigitYear = yearAsString.substring(yearAsString.length()-2,yearAsString.length());
	
		String first3digits = "";
		Integer oper = record.getCodigoOperadora();
		switch (oper) {
			case 10:
				first3digits = "015";
				break;
			case 5:
				first3digits = "008";
		}
		
		return first3digits + twoDigitYear + last11digits; 
	}
	
	

	


}
