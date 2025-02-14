package com.pwskill.aman;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.pwskills.Utility.DBUtil;

public class DeleteRecord {

	private static final String SQL_INSERT_QUERY = "delete from student where sid = ?";
	public static void main(String[] args) {
		//Resources used
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int rowCount = 0;
		try {
			connection = DBUtil.getDBConnection();
			
			if(connection != null) {
				preparedStatement = connection.prepareStatement(SQL_INSERT_QUERY);
			}
			
			Scanner sc = new Scanner(System.in);
			
			if(sc != null && preparedStatement != null) {
				System.out.print("Enter the sid:: ");
				int sid = sc.nextInt();
				
				preparedStatement.setInt(1, sid);
				System.out.println("No. of rows deleted is :: "+preparedStatement.executeUpdate());
				
				//pausing the application
				System.in.read();
				
				System.out.println("Reusing the same PreparedStatement Object to run query with different input");
				System.out.print("Enter the sid:: ");
				sid = sc.nextInt();
				
				preparedStatement.setInt(1, sid);
				System.out.println("No. of rows deleted is :: "+preparedStatement.executeUpdate());
				
				
				sc.close();
			}
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.clearUpResources(null, preparedStatement, connection);
		}
	}

}
