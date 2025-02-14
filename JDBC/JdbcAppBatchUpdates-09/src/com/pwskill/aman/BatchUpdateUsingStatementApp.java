package com.pwskill.aman;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.pwskills.Utility.JDBCUtil;

public class BatchUpdateUsingStatementApp {

	//Driver Code
	public static void main(String[] args) {
		try(Connection connection = JDBCUtil.getMySQLDBConnection()){
			try(Statement statement = connection.createStatement()){
				//Adding the queries to batch
				statement.addBatch("insert into employees(`ename`,`esal`,`eaddress`) values('shahid',25000,'RCB')");
				statement.addBatch("update employees set esal = esal + 1000 where esal < 30000");
				statement.addBatch("delete from employees where esal > 35000");
				
				//Execute the batch
				int[] count = statement.executeBatch();
				int updateCount = 0;
				
				//process the output
				for(int result : count) {
					updateCount += result;
				}
				System.out.println("No of rows altered is :: "+updateCount);
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
