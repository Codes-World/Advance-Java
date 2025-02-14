package com.pwskill.aman;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.pwskills.Utility.JDBCUtil;

public class ResultSetTypeApp1 {

	public static void main(String[] args) {
		try(Connection connection = JDBCUtil.getMySQLDBConnection()){
			try(Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)){
				try(ResultSet resultSet = statement.executeQuery("select eid, ename, esal, eaddress from employees")){
					
					System.out.println("Records in forward direction...");
					System.out.println("EID\tENAME\tESAL\tEADDRESS");
					while(resultSet.next()) {
						System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getInt(3)+"\t"+resultSet.getString(4));
					}
					
					System.out.println();
					System.out.println("Records in backward direction...");
					System.out.println("EID\tENAME\tESAL\tEADDRESS");
					while(resultSet.previous()) {
						System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getInt(3)+"\t"+resultSet.getString(4));
					}
					
					//In absolute, each time cursor start from bottom but in relative, cursor is start from where the cursor was
					System.out.println();
					System.out.println("Exploring the methods for Navigation...");
					resultSet.first();
					System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getInt(3)+"\t"+resultSet.getString(4));
					
					System.out.println();
					System.out.println("Exploring the methods for Navigation...");
					resultSet.last();
					System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getInt(3)+"\t"+resultSet.getString(4));
					
					System.out.println();
					resultSet.absolute(3); //Just input row number or id and get the result from database
					System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getInt(3)+"\t"+resultSet.getString(4));
					
					resultSet.absolute(-5); //Just input row number or id and get the result from database
					System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getInt(3)+"\t"+resultSet.getString(4));
					
					resultSet.absolute(3);
					
					System.out.println();
					resultSet.relative(5); //Just input row number or id and get the result from database
					System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getInt(3)+"\t"+resultSet.getString(4));
					
					System.out.println();
					resultSet.relative(-5); //Just input row number or id and get the result from database
					System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getInt(3)+"\t"+resultSet.getString(4));
					
					System.out.println();
					resultSet.beforeFirst();
					System.out.println("Cursor pointing to first row :: "+resultSet.isFirst());
					System.out.println("Cursor pointing to Last row :: "+resultSet.isLast());
					System.out.println("Cursor pointing to BeforeFirst row :: "+resultSet.isBeforeFirst());
					resultSet.afterLast();
					System.out.println("Cursor pointing to AfterLast row :: "+resultSet.isAfterLast());
				}
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
