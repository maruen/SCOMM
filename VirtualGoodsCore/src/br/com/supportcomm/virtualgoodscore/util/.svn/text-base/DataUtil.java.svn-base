package br.com.supportcomm.virtualgoodscore.util;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DataUtil {


	private static SimpleDateFormat dateFormat 		= new SimpleDateFormat("dd/MM/yyyy");
	private static SimpleDateFormat dateTimeFormat 	= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	
	public static String formatarDataTimestamp(Date data) {

		if (data == null) return null; 
	
		return new SimpleDateFormat("dd/MM/yyyy HH:mm").format(data);
	}
	
	
	public static String formatarDataTimestampSegundos(Date data) {

		if (data == null) 	return null; 

		return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(data);
	}

	
	public static String formatarData(Date data) {

		if (data == null) return null; 

		return dateFormat.format(data);
	}
	
	
	public static String formatarHora(Date data) {

		if (data == null) return null;

		return new SimpleDateFormat("HH:mm").format(data);
	}

	public static double transformarMillisegundosEmDias(double diferencaDeTempoEmMillisegundos) {
		return diferencaDeTempoEmMillisegundos / 1000 / 60 / 60 / 24;
	}

	
	public static boolean dataFinalEhMaiorDoQueDataInicial(	String dataInicialParam, String dataFinalParam) {

		Date dataInicial = obterData(dataInicialParam);
		Date dataFinal 	 = obterData(dataFinalParam);

		return dataFinal.compareTo(dataInicial) == 1;
	}

	
	public static Date somaDiasNaData(Date data, int dias) {
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(data);
		calendar.add(Calendar.DAY_OF_MONTH, dias);

		return calendar.getTime();
	}

	
	public static Date obterData(String dataString) {
	
		if (dataString == null || dataString.trim().equals("") ){
			return null;
		}
		
		try {
			return dateFormat.parse(dataString);
		} catch (ParseException e) {
			return new Date();
		}
	}
	
	public static Timestamp obterDataTimestamp(String dataString) {

		if (dataString == null || dataString.trim().equals("") ){
			return null; 
		}

		try {
			return new Timestamp(dateTimeFormat.parse(dataString).getTime());
		} catch (ParseException e) {
			return new Timestamp(System.currentTimeMillis());
		}
	}
	
	public static String obterDataFormatada(Date data) {

		if (data == null)  return null; 

		return dateFormat.format(data);
	}

	public static long getDiferencaEntreDatas(Date dataInicio, Date dataFim) {

		long diff = dataInicio.getTime() - dataFim.getTime();
		diff = diff / (1000 * 60 * 60 * 24);
		return diff;
	}
	
	public static String[] timeStampToStringArray(Timestamp ts){
		String tm = ts.toString().trim();
		String[] data = new String[6];
	
		data[0]=tm.substring(8, 11);
		data[1]=tm.substring(5, 7);
		data[2]=tm.substring(0, 4);
		data[3]=tm.substring(11, 13);
		data[4]=tm.substring(14, 16);
		data[5]=tm.substring(17, 19);
		
		return data;
	}
	
	
	public static String timeStampToStringFormated(Timestamp ts){
		String tm = ts.toString().trim();
		return tm.substring(8, 11).trim()+"/"+tm.substring(5, 7).trim()+"/"+tm.substring(0, 4).trim();
	}
	
}
