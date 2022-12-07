package javaProg;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateEx {
public static void main(String[] args) {
	Date date = new Date();
	System.out.println(date);
	
	SimpleDateFormat sdf = new SimpleDateFormat();
	String data = sdf.format(date);
	System.out.println(data);
	
	SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-yyyy");
	String data1 = sdf1.format(date);
	System.out.println(data1);
	
	System.out.println(System.getProperty("user.dir"));
}
}
