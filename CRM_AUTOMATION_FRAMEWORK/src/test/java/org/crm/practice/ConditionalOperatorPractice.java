package org.crm.practice;

public class ConditionalOperatorPractice {
	public static void main(String[] args) {
		int a = 1;
		 String result = a==0?" is a Zero":" is not a Zero";
		 System.out.println(a+ result);
		 
		 int b = a>0||a<0?a:0;
		 System.out.println(b);
	}

}
