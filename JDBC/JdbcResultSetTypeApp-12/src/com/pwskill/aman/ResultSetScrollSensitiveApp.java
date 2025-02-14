package com.pwskill.aman;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.pwskills.Utility.JDBCUtil;

public class ResultSetScrollSensitiveApp {

	public static void main(String[] args) {
		try(Connection connection = JDBCUtil.getMySQLDBConnection()){
			try(Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)){
				try(ResultSet resultSet = statement.executeQuery("select eid, ename, esal, eaddress from employees")){
					
					System.out.println("Records in Before Updation...");
					System.out.println("EID\tENAME\tESAL\tEADDRESS");
					while(resultSet.next()) {
						System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getInt(3)+"\t"+resultSet.getString(4));
					}
					
					System.out.println();
					System.out.println("Application is in pausing state, please update the database....");
					System.in.read();
					
					resultSet.beforeFirst();
					
					System.out.println("Records in After Updation...");
					System.out.println("EID\tENAME\tESAL\tEADDRESS");
					while(resultSet.next()) {
						//To get latest values from the database(SCROLL_SENSITIVE)
						resultSet.refreshRow();
						System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getInt(3)+"\t"+resultSet.getString(4));
					}
				}
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}

