package org.crm.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBCExecuteQueryPractice {
	public static void main(String[] args) throws SQLException {
		//Creating object of Driver class which is given by Database Vendor	
		Driver driver = new Driver();
		
		// Register the driver to JDBC
		DriverManager.registerDriver(driver);
		
		// establish the connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tyss", "root", "root");
		
		// create statement
		Statement statement = connection.createStatement();
		
		ResultSet result = statement.executeQuery("select * from tyss;");
		while (result.next()) {
			System.out.println(result.getString("eid") + "   " + result.getString("ename"));
		}
		connection.close();
	}
}
