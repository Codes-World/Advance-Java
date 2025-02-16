package com.pwskill.aman;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

import com.pwskills.Utility.JDBCUtil;

public class CachedRowSetApp {

	public static void main(String[] args) {
		CachedRowSet cachedRowSet = null;
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = JDBCUtil.getMySQLDBConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select eid,ename,esal,eaddress from employees");
			
			RowSetFactory factory = RowSetProvider.newFactory();
			
			//DisConnected based RowSet
			cachedRowSet = factory.createCachedRowSet();
			
			//Copy ResultSet object to CachedRowSet
			cachedRowSet.populate(resultSet);
			
			connection.close();
		
			
			System.out.println("Employee details in forward direction...");
			System.out.println("EID\tENAME\tESAL\tEADDRESS");
			while(cachedRowSet.next()) {
				System.out.println(cachedRowSet.getInt(1)+"\t"+cachedRowSet.getString(2)+"\t"+cachedRowSet.getInt(3)+"\t"+cachedRowSet.getString(4));
			}
			
			System.out.println();
			
			System.out.println("Employee details in backward direction...");
			System.out.println("EID\tENAME\tESAL\tEADDRESS");
			while(cachedRowSet.previous()) {
				System.out.println(cachedRowSet.getInt(1)+"\t"+cachedRowSet.getString(2)+"\t"+cachedRowSet.getInt(3)+"\t"+cachedRowSet.getString(4));
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(cachedRowSet != null) {
				try {
					cachedRowSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
