package com.pwskill.aman;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.pwskills.Utility.JDBCUtil;

public class BatchUpdateUsingPreparedStatementApp {

	private static final String SQL_INSERT_QUERY = "insert into employees(`ename`,`esal`,`eaddress`) values(?,?,?)";

	//Driver Code
	public static void main(String[] args) {
		try(Connection connection = JDBCUtil.getMySQLDBConnection()){
			try(PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_QUERY)){
				Scanner sc = new Scanner(System.in);
				
				while(true) {
					System.out.print("Enter the employee name :: ");
					String ename = sc.next();
					
					System.out.print("Enter the employee salary :: ");
					int esal = sc.nextInt();
					
					System.out.print("Enter the employee address :: ");
					String address = sc.next();
					
					preparedStatement.setString(1, ename);
					preparedStatement.setInt(2, esal);
					preparedStatement.setString(3, address);
					
					preparedStatement.addBatch();
					
					System.out.print("Do you want to insert one more record:: [Yes/NO]");
					String option = sc.next();
					
					if(option.equalsIgnoreCase("No")) {
						break;
					}
				}
				
				//Execute the batch
				preparedStatement.executeBatch();
				System.out.println("Record inserted succesfully.....");
				sc.close();
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
