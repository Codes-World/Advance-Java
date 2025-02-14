package com.pwskill.aman;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.pwskills.Utility.JDBCUtil;

public class SQLInjectionUsingStatement {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try(Connection connection = JDBCUtil.getMySQLDBConnection()){
			try(Statement statement = connection.createStatement()){
				System.out.print("Enter the username :: ");
				String username = sc.next();
				username = "'"+username+"'";
				
				System.out.print("Enter the password :: ");
				String password = sc.next();
				password="'"+password+"'";
				String sqlSelectQuery = "select count(*) from userinfo where username="+ username +" and password="+ password +" ";
				try(ResultSet resultSet = statement.executeQuery(sqlSelectQuery)){
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
			
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		sc.close();
	}

}
