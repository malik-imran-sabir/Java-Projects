package org.core.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	
	public static Date getCurrentDateTime(){
		Calendar cal = Calendar.getInstance();
		return cal.getTime();
		
	}

	public static String convertDateToString(Date timestamp, String desiredFormat){
		SimpleDateFormat dateFormat= new SimpleDateFormat(desiredFormat);
		return dateFormat.format(timestamp);
	}

	public static Date convertStringToDate(String dateString, String dateFormat) throws ParseException{
		SimpleDateFormat format= new SimpleDateFormat(dateFormat);
		return format.parse(dateString);
	}


	public static String convertDateToDefaultStringFormat(Date timestamp) {
		return convertDateToString(timestamp, Constants.DATEFORMAT.MM_DD_YYYY.getValue());
	}

	public static Date convertStringToDefaultDateFormat(String dateString) throws ParseException{
		return convertStringToDate(dateString, Constants.DATEFORMAT.MM_DD_YYYY.getValue());
	}

}
