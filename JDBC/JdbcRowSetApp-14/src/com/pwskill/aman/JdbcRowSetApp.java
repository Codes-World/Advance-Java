package com.pwskill.aman;



import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class JdbcRowSetApp {

	public static void main(String[] args) {
		JdbcRowSet jdbcRowSet = null;
		try {
			RowSetFactory factory = RowSetProvider.newFactory();
			
			//Connection based RowSet
			jdbcRowSet = factory.createJdbcRowSet();
			jdbcRowSet.setUrl("jdbc:mysql:///pwskills_octbatch");
			jdbcRowSet.setUsername("root");
			jdbcRowSet.setPassword("aman@123");
			
			jdbcRowSet.setCommand("select eid,ename,esal,eaddress from employees");
			jdbcRowSet.execute();
			System.out.println("Employee details in forward direction...");
			System.out.println("EID\tENAME\tESAL\tEADDRESS");
			while(jdbcRowSet.next()) {
				System.out.println(jdbcRowSet.getInt(1)+"\t"+jdbcRowSet.getString(2)+"\t"+jdbcRowSet.getInt(3)+"\t"+jdbcRowSet.getString(4));
			}
			
			System.out.println();
			
			System.out.println("Employee details in backward direction...");
			System.out.println("EID\tENAME\tESAL\tEADDRESS");
			while(jdbcRowSet.previous()) {
				System.out.println(jdbcRowSet.getInt(1)+"\t"+jdbcRowSet.getString(2)+"\t"+jdbcRowSet.getInt(3)+"\t"+jdbcRowSet.getString(4));
			}
			
			System.in.read();
			
			//placing the cursor to the beginning of the table
			jdbcRowSet.first();
			while(jdbcRowSet.next()) {
				int dbEsal = jdbcRowSet.getInt(3);
				if(dbEsal < 32000) {
					jdbcRowSet.deleteRow();
				}
			}
			System.out.println("Records Deleted Succesfully...");
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(jdbcRowSet != null) {
				try {
					jdbcRowSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
