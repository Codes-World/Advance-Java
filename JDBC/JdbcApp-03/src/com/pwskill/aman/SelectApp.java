package com.pwskill.aman;

import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.pwskills.Utility.DBUtil;

public class SelectApp {
	private static final String SQL_SELECT_QUERY = "select id,username,dob from users where id = ?";
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
				preparedStatement =
				connection.prepareStatement(SQL_SELECT_QUERY);

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
				System.out.println("ID\tNAME\tDOB");
				System.out.println(resultSet.getInt(1) + "\t" +resultSet.getString(2) + "\t"+ convertoString(resultSet.getDate(3)));
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
	private static String convertoString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		return sdf.format(date);
	}
}
