package com.pwskill.aman;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.pwskills.Utility.DBUtil;

public class UpdateApp {

	public static void main(String[] args) {
		//Resources used
		Connection connection = null;
		Statement statement = null;
		int rowCount = 0;
		try {
			connection = DBUtil.getDBConnection();
			
			if(connection != null) {
				statement = connection.createStatement();
			}
			
			Scanner sc = new Scanner(System.in);
			
			String sqlUpdateQuery = null;
			if(sc != null) {
				System.out.print("Enter the sid:: ");
				int sid = sc.nextInt();
				
				System.out.print("Enter the sname:: ");
				String sname = sc.next();
				sname = "'"+sname+"'";
				
				// update student set sname = 'sachin' where sid = 7;
				sqlUpdateQuery = "update student set sname="+sname+"where sid ="+sid+"";
				System.out.println(sqlUpdateQuery);
				
			}
			if(statement != null) {
				rowCount = statement.executeUpdate(sqlUpdateQuery);
			}
			if(rowCount == 0) {
				System.out.println("Record not available for updation.....");
			}else {
				System.out.println("Record updated succesfully.....");
			}
			sc.close();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.clearUpResources(null, statement, connection);
		}
	}

}
