package com.pwskill.aman;

import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;

import com.pwskills.Utility.DBUtil;

public class SelectApp {
	private static final String SQL_SELECT_QUERY = "select eid,ename,eaddress,resume from employee where eid = ?";
	public static void main(String[] args) {
		// Resources used
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int eid = 0;
		try {
			connection = DBUtil.getDBConnection();
			// 2. Create a Statement Object
			if (connection != null) {
				preparedStatement =
				connection.prepareStatement(SQL_SELECT_QUERY);

			}
			Scanner scanner = new Scanner(System.in);
			if (preparedStatement != null && scanner != null) {
				System.out.print("Enter the employee id of the user:: ");
				eid = scanner.nextInt();

				// Set the value to the placeholder '?'
				preparedStatement.setInt(1, eid);
				
				// Execute the Query
				resultSet = preparedStatement.executeQuery();
			}
			// 4. Process the Result
			if (resultSet.next()) {
				System.out.println("EID\tENAME\tEAddress\tResume");
				String fileName = "Resume.txt";
				
				//Framework code or API code
				FileWriter fileWriter = new FileWriter(new File(fileName));
				IOUtils.copy(resultSet.getCharacterStream(4), fileWriter);
				fileWriter.flush();
				
				System.out.println(resultSet.getInt(1) + "\t" +resultSet.getString(2) + "\t" + resultSet.getString(3) + "\t" + fileName);
				
				//System.out.println(displayImageInfo(resultSet.getBinaryStream(3)));
				
			} else {
				System.out.println("Record not found for the given id :: "+ eid);
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
