package com.pwskill.aman;

import java.io.*;
import java.sql.*;
import com.pwskills.Utility.DBUtil;

public class SelectApp {

	public static void main(String[] args) {
		
		//Using Resources
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		
		try {
			
			connection = DBUtil.getDBConnection();
			
			
			//2. Create a statement object
			statement = connection.createStatement();
			
			
			//3. Execute the query
			String sqlSelectQuery = "select sid,sname,sage,saddress from student";
			resultSet = statement.executeQuery(sqlSelectQuery);
			
			
			//4. Process the result
			System.out.println("\nSID\tSNAME\tSAGE\tSADDRESS");
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getString(3)+"\t"+resultSet.getString(4));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			DBUtil.clearUpResources(resultSet, statement, connection);
		}	
	}
}
