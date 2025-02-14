package com.pwskill.aman;

import java.sql.Connection;
import java.sql.SQLException;

import com.pwskills.Utility.JDBCUtil;

public class TransactionIsolationLevelsApp {

	public static void main(String[] args) {
		try(Connection connection = JDBCUtil.getMySQLDBConnection()){
			System.out.println(connection.getTransactionIsolation());
			connection.setTransactionIsolation(8);
			System.out.println(connection.getTransactionIsolation());
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
