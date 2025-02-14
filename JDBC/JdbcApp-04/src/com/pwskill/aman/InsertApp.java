package com.pwskill.aman;

import java.io.FileInputStream;
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
	private static final String SQL_INSERT_QUERY = "insert into person(`name`,`photo`) values(?,?)";
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
						System.out.print("Enter the username:: ");
						String name = scanner.next();

						// set the values to the '?' placeholder[Formatting is not required]

						preparedStatement.setString(1, name);
						preparedStatement.setBinaryStream(2, new FileInputStream("E:\\image\\aman.png"));
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
