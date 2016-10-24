package com.air.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTest {

	public static void main(String[] args) throws ParseException {
		String tempString="0,E2-1A-6<E2-1-01>,2016-09-25-16-2";
		String[] dataStrings = tempString.split(",");
		
		String[] dates = dataStrings[2].split("-");
		String[] date1 = dataStrings[1].split("-");
		String keyvalue = dataStrings[0] + "," + dataStrings[1] + "," + dataStrings[2] + "," + date1[0]+ " "+dates[3]  + dates[4];
System.out.println(keyvalue);
		
		//		String dateString=xx2[1];
//		SimpleDateFormat df1=new SimpleDateFormat("yyyy/M/dd HH:mm:ss");
//		Date date=df1.parse(dateString);
//		SimpleDateFormat df2=new SimpleDateFormat("yyyyMMdd,HHmm");
//		System.out.println(df2.format(date).substring(0,12));
	}
}
