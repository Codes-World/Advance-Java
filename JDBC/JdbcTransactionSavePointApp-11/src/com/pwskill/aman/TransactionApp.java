package com.pwskill.aman;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.Scanner;

import com.pwskills.Utility.JDBCUtil;

public class TransactionApp {

	//Driver Code
	public static void main(String[] args) {
		try(Connection connection = JDBCUtil.getMySQLDBConnection()){
			
			try(Statement statement = connection.createStatement()){
				
				//Disabling the autocommit feature
				connection.setAutoCommit(false);
				
				statement.executeUpdate("insert into politicians(`name`,`party`) values('rahul','congress')");
				statement.executeUpdate("insert into politicians(`name`,`party`) values('modi','bjp')");
				Savepoint sp = connection.setSavepoint();
				statement.executeUpdate("insert into politicians(`name`,`party`) values('siddu','bjp')");
				
				System.out.println("Oooopsss something went wrong, operations are rolleback to savepoint");
				connection.rollback(sp);
				
				connection.commit();
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
