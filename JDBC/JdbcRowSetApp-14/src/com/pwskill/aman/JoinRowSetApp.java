package com.pwskill.aman;



import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

import com.pwskills.Utility.JDBCUtil;

public class JoinRowSetApp {

	public static void main(String[] args) {
		JdbcRowSet jdbcRowSet = null;
		Connection connection = null;
		try {
			connection = JDBCUtil.getMySQLDBConnection();
			
			RowSetFactory factory = RowSetProvider.newFactory();
			
			CachedRowSet crs1 = factory.createCachedRowSet();
			crs1.setCommand("select * from students");
			crs1.execute(connection);
			
			CachedRowSet crs2 = factory.createCachedRowSet();
			crs2.setCommand("select * from course");
			crs2.execute(connection);
			
			JoinRowSet jrs = factory.createJoinRowSet();
			jrs.addRowSet(crs1, 4);
			jrs.addRowSet(crs2, 1);
			
			System.out.println("SID\tSNAME\tSADDR\tCID\tCNAME\tCCOST");
			System.out.println("---------------------------------------");
			while(jrs.next()) {
				System.out.println(jrs.getString(1)+"\t"+jrs.getString(2)+"\t"+jrs.getString(3)+"\t"+jrs.getString(4)+"\t"+jrs.getString(5)+"\t"+jrs.getString(6));
			}
			
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
			if(connection != null) {
				try {
					connection.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
