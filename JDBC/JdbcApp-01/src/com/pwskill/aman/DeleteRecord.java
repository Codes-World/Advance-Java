package com.pwskill.aman;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.pwskills.Utility.DBUtil;

public class DeleteRecord {

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
			
			String sqlDeleteQuery = null;
			if(sc != null) {
				System.out.print("Enter the sid:: ");
				int sid = sc.nextInt();
				
				//delete from student where sid = 7
				sqlDeleteQuery = "delete from student where sid ="+sid+"";
				System.out.println(sqlDeleteQuery);
				
			}
			if(statement != null) {
				rowCount = statement.executeUpdate(sqlDeleteQuery);
			}
			if(rowCount == 0) {
				System.out.println("Record not available for deletion.....");
			}else {
				System.out.println("Record deleted succesfully.....");
			}
			sc.close();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.clearUpResources(null, statement, connection);
		}
	}

}
