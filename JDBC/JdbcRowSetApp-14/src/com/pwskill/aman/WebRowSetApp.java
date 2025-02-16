package com.pwskill.aman;



import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

import com.pwskills.Utility.JDBCUtil;

public class WebRowSetApp {

	public static void main(String[] args) {
		WebRowSet webRowSet = null;
		FileWriter fileWriter = null;
		
		try {
			RowSetFactory factory = RowSetProvider.newFactory();
			
			//DisConnected based RowSet
			webRowSet = factory.createWebRowSet();
			webRowSet.setUrl("jdbc:mysql:///pwskills_octbatch");
			webRowSet.setUsername("root");
			webRowSet.setPassword("aman@123");
			
			webRowSet.setCommand("select eid,ename,esal,eaddress from employees");
			webRowSet.execute();
			
			fileWriter = new FileWriter("emp.xml");
			
			//write webRowSet object to emp.xml file
			webRowSet.writeXml(fileWriter);
			
			System.out.println("Employee data transfer to emp.xml file");
			
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(webRowSet != null) {
				try {
					webRowSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(fileWriter != null) {
				try {
					fileWriter.close();
				}catch(IOException i) {
					i.printStackTrace();
				}
				
			}
		}
	}
}
