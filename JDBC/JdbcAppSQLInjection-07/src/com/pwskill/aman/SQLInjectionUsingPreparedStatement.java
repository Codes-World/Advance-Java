//10-03-2024
package com.pwskill.aman;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.pwskills.Utility.JDBCUtil;

public class SQLInjectionUsingPreparedStatement {
	
	private static final String SQL_INSERT_QUERY = "select count(*) from userinfo where username=? and password=?";

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try(Connection connection = JDBCUtil.getMySQLDBConnection()) {
			try(PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_QUERY)){
				
				System.out.print("Enter the username :: ");
				String username = sc.next();
				
				
				System.out.print("Enter the password :: ");
				String password = sc.next();
				
				//Set the values to ? placeholder(trying to perform SQLINjection)
				preparedStatement.setString(1, username);
				preparedStatement.setString(2, password);
				
				try(ResultSet resultSet = preparedStatement.executeQuery()){
					int count = 0;
					if(resultSet.next()) {
						count = resultSet.getInt(1);
					}
					if(count == 1) {
						System.out.println("Valid Credentials...");
					}else {
						System.out.println("InValid Credentials...");
					}
				}
			}
			
		} catch (SQLException se) {
			se.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		sc.close();
	}
}
