package com.pwskill.aman;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.pwskills.Utility.JDBCUtil;

public class ResultSetScrollUpdatableApp {

	public static void main(String[] args) {
		try(Connection connection = JDBCUtil.getMySQLDBConnection()){
			try(Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)){
				try(ResultSet resultSet = statement.executeQuery("select eid, ename, esal, eaddress from employees")){
					
					while(resultSet.next()) {
						//perform update operation
						int salary = resultSet.getInt(3);
						if(salary<=28000) {
							int incrSalary = salary + 10000;
							resultSet.updateInt(3, incrSalary);
							resultSet.updateRow();
						}
					}
					System.out.println("Records updated....");
					
				}
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}

