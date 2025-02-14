/*Write code to store date of birth in a database and calculate age based on DOB */


package com.pwskill.aman;

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

//('sid','sname','sage','saddress')
public class InsertApp {
	private static final String SQL_INSERT_QUERY = "insert into users(`username`,`dob`) values(?,?)";
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
						String username = scanner.next();

						System.out.print("Enter the DOB(dd-MM-yyyy):: ");
						String dob = scanner.next();
						// set the values to the '?' placeholder[Formatting is not required]

						preparedStatement.setString(1, username);
						preparedStatement.setDate(2, convertToSQLDate(dob));
						// Execute the query now with the inputs
						rowCount = preparedStatement.executeUpdate();

			}
			if (rowCount == 0) {
				System.out.println("Insertion of records failed...");
			} else {
				System.out.println("No of records inserted is :: " +rowCount);
			}
			scanner.close();
		} catch (IOException | SQLException | ParseException e) {
			e.printStackTrace();
		} finally {
			DBUtil.clearUpResources(null, preparedStatement, connection);
		}
	}
	private static Date convertToSQLDate(String dob) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date utilDate = sdf.parse(dob);
		long inputMs = utilDate.getTime();
		java.sql.Date sqlDate = new java.sql.Date(inputMs);
		return sqlDate;
	}
}
