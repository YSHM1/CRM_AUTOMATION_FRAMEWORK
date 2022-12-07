package org.crm.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBCExecuteUpdatePractice {
	public static void main(String[] args) {
		try {
			// Creating object of Driver class which is given by Database Vendor
			Driver driver = new Driver();

			// Register the driver to JDBC
			DriverManager.registerDriver(driver);

			// establish the connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");

			// create statement
			Statement statement = connection.createStatement();
			int result = statement.executeUpdate("insert into project values(1112,'yash', '23-06-2022','TYSS-02','Ongoing',15)");
			if (result == 1) {
				System.out.println("Data entered into table project");
			} else
				System.out.println("fail");
			
			connection.close();
			} catch (Exception e) {
				e.printStackTrace();	
			}
	}
}
