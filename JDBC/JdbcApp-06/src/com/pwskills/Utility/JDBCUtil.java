package com.pwskills.Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

//This class declare as final because the properties of this class will not change in any other classes
public final class JDBCUtil {
	private static Properties properties = null;
	private JDBCUtil() {}
	
	static {
		FileInputStream fis = null;
		String fileInfo = "E:\\Java Project\\JDBC\\src\\com\\pwskills\\properties\\database.properties";
		try {
			fis = new FileInputStream(fileInfo);
			if(fis != null) {
				properties = new Properties();
				properties.load(fis);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}
	public static Connection getMySQLDBConnection() throws IOException, SQLException {
		//1. Establish the connection
		return DriverManager.getConnection(properties.getProperty("mysql_url"), properties.getProperty("mysql_user"), properties.getProperty("mysql_password"));
	}
	
	public static Connection getOracleDBConnection() throws IOException, SQLException {
		//1. Establish the connection
		return DriverManager.getConnection(properties.getProperty("oracle_url"), properties.getProperty("oracle_user"), properties.getProperty("oracle_password"));
	}
	public static void clearUpResources(ResultSet resultSet, Statement statement, Connection connection) {
		//5. Closing the resources
		
		//Closing ResultSet
		if(resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//Closing statement
		if(statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//Closing connection
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
