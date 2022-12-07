package org.crm.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class CommonDataProgram {
public static void main(String[] args) throws IOException {
	FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");
	Properties properties = new Properties();
	properties.load(fis);
	String url = properties.getProperty("url");
	String un = properties.getProperty("userName");
	String pwd = properties.getProperty("pwd");
	String browser = properties.getProperty("browser");
	String timeout = properties.getProperty("timeout");
	System.out.println(url+"  "+un+"  "+pwd+"  "+browser+"  "+timeout);
}
}
