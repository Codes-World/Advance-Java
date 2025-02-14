package com.pwskill.aman;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.pwskills.Utility.DBUtil;

public class SelectAndNonSelectApp {

	public static void main(String[] args) {
		//Resources used
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		int rowCount = 0;
		boolean flag = false;
		try {
			connection = DBUtil.getDBConnection();
			
			if(connection != null) {
				statement = connection.createStatement();
			}
			
			Scanner sc = new Scanner(System.in);
			
			String sqlQuery = null;
			if(sc != null) {
				System.out.print("Enter the query::");
				sqlQuery = sc.nextLine();
				System.out.println(sqlQuery);
				sc.close();
				
			}
			if(statement != null && sqlQuery != null) {
				flag = statement.execute(sqlQuery);
			}
			if(flag) {
				//Display resultSet
				resultSet = statement.getResultSet();
				while(resultSet.next())
					System.out.println("\n"+resultSet.getInt(1)+ "\t" +resultSet.getString(2)+ "\t" +resultSet.getInt(3)+ "\t" +resultSet.getString(4));
			}else {
				//Display Non-ResultSet
				rowCount = statement.getUpdateCount();
				if(rowCount == 0) {
					System.out.println("Table not modified");
				}else {
					System.out.println("Table modified");
				}
			}
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.clearUpResources(null, statement, connection);
		}
	}

}
