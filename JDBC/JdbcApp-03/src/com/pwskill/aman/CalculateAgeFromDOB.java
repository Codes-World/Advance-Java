package com.pwskill.aman;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.pwskills.Utility.DBUtil;

public class CalculateAgeFromDOB {
	private static final String SQL_SELECT_QUERY = "select DATE_FORMAT(from_days(datediff(now(),dob)),'%Y') as AGE from users where id = ?";
	public static void main(String[] args) {
		// Resources used
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int id = 0;
		try {
			connection = DBUtil.getDBConnection();
			// 2. Create a Statement Object
			if (connection != null) {

				preparedStatement = connection.prepareStatement(SQL_SELECT_QUERY);

			}
			Scanner scanner = new Scanner(System.in);
			if (preparedStatement != null && scanner != null) {
				System.out.print("Enter the id of the user:: ");
				id = scanner.nextInt();
				// Set the value to the placeholder '?'
				preparedStatement.setInt(1, id);
				// Execute the Query
				resultSet = preparedStatement.executeQuery();
			}
			// 4. Process the Result
			if (resultSet.next()) {
				System.out.println("The age is :: "+resultSet.getInt(1));
			} else {
				System.out.println("Record not found for the given id :: "+ id);
			}
			scanner.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.clearUpResources(resultSet, preparedStatement, connection);
		}
	}
}