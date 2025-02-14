//10-03-2024
package com.pwskill.aman;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.xdevapi.Statement;
import com.pwskills.Utility.DBUtil;
import com.pwskills.Utility.JDBCUtil;

public class CopyFromOracleToMySQLApp {
	
	private static final String SQL_INSERT_QUERY = "insert into canarabank(`accno`,`holdername`,`balance`) values(?,?,?)";
	private static final String SQL_SELECT_QUERY = "select accno,holdername,balance from syndicatebank";

	public static void main(String[] args) {
		// Resource used
		Connection mysqlConnection = null;
		Connection oracleConnection = null;
		java.sql.Statement statement = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			
			oracleConnection = JDBCUtil.getOracleDBConnection();
			mysqlConnection = JDBCUtil.getMySQLDBConnection();
			
			if(oracleConnection != null) {
				statement = oracleConnection.createStatement();
			}
			
			if(mysqlConnection != null) {
				preparedStatement = mysqlConnection.prepareStatement(SQL_INSERT_QUERY);
			}
			
			if(statement != null) {
				resultSet = statement.executeQuery(SQL_SELECT_QUERY);
			}
			
			if(resultSet != null && preparedStatement != null) {
				while(resultSet.next()) {
					
					//Set the values to ? of placeholder
					preparedStatement.setInt(1, resultSet.getInt(1));
					preparedStatement.setString(2, resultSet.getString(2));
					preparedStatement.setFloat(3, resultSet.getFloat(3));
					
					preparedStatement.executeUpdate();
				}
				System.out.println("Record are copied from OracleDB to MySQLDB....");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.clearUpResources(resultSet, statement, oracleConnection);
			JDBCUtil.clearUpResources(null, preparedStatement, mysqlConnection);
		}
	}
}
