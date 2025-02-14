package com.pwskill.aman;


import java.text.SimpleDateFormat;

public class DateFormTest {

	public static void main(String[] args) throws Exception {
		//For this "06-02-2025" -> "dd-MM-yyyy" and "06-Feb-2025" -> "dd-MMM-yyyy"
		
		String indianUser = "06-Feb-2025";
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		java.util.Date utilDate = sdf.parse(indianUser);
		
		long inputMS = utilDate.getTime();
		java.sql.Date sqlDate = new java.sql.Date(inputMS);
		System.out.println("SQLDate information is :: "+sqlDate);
		
		//input is 2025-02-06 this formate we can directly converting to java.sql.Date
		String chinaUser = "2025-02-06";
		java.sql.Date sqlOutput = java.sql.Date.valueOf(chinaUser);
		System.out.println("SQLDate infromation is :: "+sqlOutput);
	}

}
