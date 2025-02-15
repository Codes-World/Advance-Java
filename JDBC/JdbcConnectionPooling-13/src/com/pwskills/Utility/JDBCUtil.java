package com.pwskills.Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;

//This class declare as final because the properties of this class will not change in any other classes
public final class JDBCUtil {
	private static Properties properties = null;
	private static MysqlConnectionPoolDataSource dataSource = null;
	
	private JDBCUtil() {}
	
	static {
		FileInputStream fis = null;
		String fileInfo = "E:\\Java Project\\JdbcConnectionPooling-13\\src\\com\\pwskills\\properties\\database.properties";
		try {
			fis = new FileInputStream(fileInfo);
			if(fis != null) {
				properties = new Properties();
				properties.load(fis);
			}
			
			//Working with connection pool
			dataSource = new MysqlConnectionPoolDataSource();
			dataSource.setUrl(properties.getProperty("mysql_url"));
			dataSource.setUser(properties.getProperty("mysql_user"));
			dataSource.setPassword(properties.getProperty("mysql_password"));
		} catch (IOException e) {
			e.printStackTrace();
		}catch(Exception e) {
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
		return dataSource.getConnection();
	}
	
}
