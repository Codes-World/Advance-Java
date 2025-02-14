package com.pwskill.aman;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.pwskills.Utility.DBUtil;

//('sid','sname','sage','saddress')
public class InsertApp {

	private static final String SQL_INSERT_QUERY = "insert into student values(?,?,?,?)";
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
			
			if(preparedStatement != null && sc != null) {
				System.out.print("Enter the sid:: ");
				int sid = sc.nextInt();
				
				System.out.print("Enter the sname:: ");
				String sname = sc.next();
				
				
				System.out.print("Enter the sage:: ");
				int sage = sc.nextInt();
				
				System.out.print("Enter the saddress:: ");
				String saddress = sc.next();
				
				//set the value to the '?' placeholder
				preparedStatement.setInt(1, sid);;
				preparedStatement.setString(2, sname);
				preparedStatement.setInt(3, sage);
				preparedStatement.setString(4, saddress);
				
				//Execute the query now with the inputs
				rowCount = preparedStatement.executeUpdate();
			}
			if(rowCount == 0) {
				System.out.println("Failure in Insertion.....");
			}else {
				System.out.println("No. of records inserted is :: "+rowCount);
			}
			sc.close();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.clearUpResources(null, preparedStatement, connection);
		}
	}

}
