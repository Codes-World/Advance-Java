package com.pwskill.aman;

import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;

import com.pwskills.Utility.DBUtil;

public class SelectApp {
	private static final String SQL_SELECT_QUERY = "select id,name,photo from person where id = ?";
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
				System.out.println("ID\tNAME\tPHOTO");
				String imageName = "download.png";
				
				//Framework code or API code
				IOUtils.copy(resultSet.getBinaryStream(3), new FileOutputStream(imageName));
				System.out.println(resultSet.getInt(1) + "\t" +resultSet.getString(2) + imageName);
				
				//System.out.println(displayImageInfo(resultSet.getBinaryStream(3)));
				
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
/*
	//Code without buffer for copying the data from InputStream to OutputStream
	private static String displayImageInfo(InputStream binaryStream) throws IOException {
		String location = "download.png";
		FileOutputStream fos = new FileOutputStream(location);
		int data = binaryStream.read();
		while (data != -1) {
			fos.write(data);
			data = binaryStream.read();
		}
		fos.close();
		binaryStream.close();
		return "Succesfuly Downloaded with the file name as " + location;
	}
*/

/*
	//Code with Buffer for Copying the data from InputStream to OutputStream
	private static String displayImageInfo(InputStream binaryStream) throws IOException {
		String location = "download.png";
		FileOutputStream fos = new FileOutputStream(location);
		byte[] imageBuffer = new byte[1024];
		while (binaryStream.read(imageBuffer) > 0) {
			fos.write(imageBuffer);
		}
		fos.close();
		binaryStream.close();
		return "Succesfuly Downloaded with the file name as " + location;
	}
*/
}
