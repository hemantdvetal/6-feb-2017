package com.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EmployeeUtil {
	
	public static Date ConvertStringToDate(String createDate) {
		
		DateFormat df = new SimpleDateFormat("dd-mm-yyyy");
		   Date createdDate=null;
		try {
			createdDate = df.parse(createDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		   return createdDate;
	}

}
