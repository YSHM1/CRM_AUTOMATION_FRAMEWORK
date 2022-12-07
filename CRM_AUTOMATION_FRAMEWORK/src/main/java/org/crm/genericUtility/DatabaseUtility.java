package org.crm.genericUtility;

/**
 * This class contains methods to fetch/write/verify the data from Database
 * @author ymulk
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

public final class DatabaseUtility {

	private Connection connection;
	private ResultSet result;
	private List<String> allResult = new ArrayList<String>();
	private List<Object> list = new ArrayList<>();

	/**
	 * This method is used to establish connection with Database
	 * 
	 * @param url
	 * @param userName
	 * @param password
	 */
	public void establishDriverConnection(String url, String databaseName, String userName, String password) {
		Driver driver = null;
		try {
			driver = new Driver();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			DriverManager.registerDriver(driver);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			connection = DriverManager.getConnection(url + databaseName, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to Execute Select Query
	 * 
	 * @param query
	 */
	public void executeSelectQuery(String query) {
		try {
			result = connection.createStatement().executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to execute Update Query
	 * 
	 * @param query
	 * @return
	 */
	public int executeUpdateQuery(String query) {
		int updateResult = 0;
		try {
			updateResult = connection.createStatement().executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updateResult;
	}

	/**
	 * This method is used to get Select Query Result with help of Column index
	 * 
	 * @param ColumnIndex
	 * @return List<String>
	 */
//	public List getSelectQueryResult(int ColumnIndex) {
//		try {
//			while (result.next()) {
//				 list.add(result.getInt(ColumnIndex));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return allResult;
//	}

	/**
	 * This method is used to get Select Query Result with help of Column Name
	 * 
	 * @param ColumnName
	 * @return List<String>
	 */
	public List<String> getSelectQueryResult(String ColumnName) {
		try {
			while (result.next()) {
				//System.out.println(result.getString(ColumnName));
				allResult.add(result.getString(ColumnName));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allResult;
	}

	/**
	 * This method is used to verify or compare Actual Data with Expected Data
	 * 
	 * @param fetchedResultFromDatabase
	 * @param actualData
	 * @return
	 */
	public boolean verifyExpectedResultWithActualResult(List<String> fetchedResultFromDatabase, String actualData) {

		boolean flag = false;
		for (String result : fetchedResultFromDatabase) {
			if (result.equals(actualData)) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	/**
	 * this method is used to close the Database Connection/ kill driver object
	 */
	public void closeDatabaseConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
