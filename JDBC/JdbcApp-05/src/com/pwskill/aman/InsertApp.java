package com.pwskill.aman;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.pwskills.Utility.DBUtil;

public class InsertApp {
	private static final String SQL_INSERT_QUERY = "insert into employee(`ename`,`eaddress`, `resume`) values(?,?,?)";
	public static void main(String[] args) {
		// Resource used
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int rowCount = 0;
		try {
			connection = DBUtil.getDBConnection();
			if (connection != null)
				preparedStatement = connection.prepareStatement(SQL_INSERT_QUERY);
				Scanner scanner = new Scanner(System.in);
				if (preparedStatement != null && scanner != null) {
						System.out.print("Enter the Employee name:: ");
						String ename = scanner.next();
						
						System.out.print("Enter the Employee address:: ");
						String eaddress = scanner.next();
						// set the values to the '?' placeholder[Formatting is not required]

						preparedStatement.setString(1, ename);
						preparedStatement.setString(2, eaddress);
						String location = "E:\\image\\Resume.txt";
						preparedStatement.setCharacterStream(3, new FileReader(new File(location)));
						// Execute the query now with the inputs
						rowCount = preparedStatement.executeUpdate();

			}
			if (rowCount == 0) {
				System.out.println("Insertion of records failed...");
			} else {
				System.out.println("No of records inserted is :: " +rowCount);
			}
			scanner.close();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.clearUpResources(null, preparedStatement, connection);
		}
	}
}
