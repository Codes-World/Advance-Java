package com.pwskill.aman;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.pwskills.Utility.DBUtil;

public class InsertApp {

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
			
			String sqlInsertQuery = null;
			if(sc != null) {
				System.out.print("Enter the sid:: ");
				int sid = sc.nextInt();
				
				System.out.print("Enter the sname:: ");
				String sname = sc.next();
				
				System.out.print("Enter the sage:: ");
				int sage = sc.nextInt();
				
				System.out.print("Enter the saddress:: ");
				String saddress = sc.next();
				
				//insert into student values(19,'aman',22,'bhopal')
				sqlInsertQuery = "insert into student values("+sid+",'"+sname+"',"+sage+",'"+saddress+"'"+")";
				System.out.println(sqlInsertQuery);
				
			}
			if(statement != null) {
				rowCount = statement.executeUpdate(sqlInsertQuery);
			}
			if(rowCount == 0) {
				System.out.println("Failure in Insertion.....");
			}else {
				System.out.println("Record insert succesfully.....");
			}
			sc.close();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.clearUpResources(null, statement, connection);
		}
	}

}
