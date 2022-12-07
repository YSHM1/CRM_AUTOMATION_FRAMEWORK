package org.crm.practice;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class DateConverter {
	public static void main(String[] args) {
		String s = "04-07-2022";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		System.out.println("1 --> "+dtf);
		
		
		LocalDate month = LocalDate.parse(s, dtf);
		System.out.println("2 --> "+month);
		
		Month months = month.getMonth();
		System.out.println("3 --> "+months);
		
		int day = month.getDayOfMonth();
		System.out.println("4 --> "+day);
		
		int dayOfYear = month.getDayOfYear();
		System.out.println("5 --> "+dayOfYear);
		
		
		String s1="JANUARY";
		String s2=s1.substring(0,2);
		System.out.println("6 --> "+s2);
		
		
	}
}