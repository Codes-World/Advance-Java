package com.pwskill.aman;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.pwskills.Utility.JDBCUtil;

public class TransactionApp {

	//Driver Code
	public static void main(String[] args) {
		try(Connection connection = JDBCUtil.getMySQLDBConnection()){
			
			try(Statement statement = connection.createStatement()){
				try(ResultSet resultSet = statement.executeQuery("select * from account")){
					System.out.println("Data before transaction....");
					while(resultSet.next()) {
						System.out.println(resultSet.getString(1) + " " + resultSet.getInt(2));
					}
				}
				System.out.println();
				//Starting the transaction
				System.out.println("*********Transaction Begins...************");
				connection.setAutoCommit(false);
				
				statement.executeUpdate("update account set balance = balance - 5000 where name = 'sachin'");
				statement.executeUpdate("update account set balance = balance + 5000 where name = 'dhoni'");
				
				Scanner sc = new Scanner(System.in);
				System.out.print("Do you want to perform the transaction successfully:: [YES/NO]");
				String option = sc.next();
				
				if(option.equalsIgnoreCase("yes")) {
					connection.commit();
					System.out.println("Transaction committed....");
				}else {
					connection.rollback();
					System.out.println("Transaction rolleback...\n");
				}
				
				//Printing the resultSet information after the transaction..
				try(ResultSet resultSet = statement.executeQuery("select * from account")){
					System.out.println("Data after transaction....");
					while(resultSet.next()) {
						System.out.println(resultSet.getString(1) + " " + resultSet.getInt(2));
					}
				}
				
				sc.close();
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
