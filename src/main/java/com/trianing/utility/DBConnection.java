package com.trianing.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.trianing.models.UserModel;

public class DBConnection {

	public static ResultSet getUsersDateFromDb() {
		ResultSet rs = null;

		try {

			/*
			 * connet to db
			 * 
			 * write some query
			 * 
			 * execute the query
			 * 
			 * get the results
			 * 
			 * finally display
			 */

			Class.forName("com.mysql.jdbc.Driver");

			// jdbc url //1521 //uname ///pawd
			// thin driver
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/braingain", "root", "root");

			Statement stmt = con.createStatement();

			rs = stmt.executeQuery("select * from users");

			// con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return rs;
	}

	public static int insertDataIntoUser(UserModel userModel) {
		int result = 0;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/braingain", "root", "root");
			String sql = "insert into users values(?,?,?,?,?,?)";
			PreparedStatement preparedStatement = con.prepareStatement(sql);

			preparedStatement.setString(1, userModel.getEmailId());
			preparedStatement.setString(2, userModel.getUserRoleId());
			preparedStatement.setString(3, userModel.getFullName());
			preparedStatement.setString(4, userModel.getCity());
			preparedStatement.setString(5, userModel.getPhoneNumber());
			preparedStatement.setString(6, userModel.getPassword());

			result = preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

	public static int updateUser(UserModel userModel) {
		int result = 0;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/braingain", "root", "root");
			String sql = "update users set fullname=? where emailid=?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);

			preparedStatement.setString(1, userModel.getFullName());
			preparedStatement.setString(2, userModel.getEmailId());

			result = preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}
	
	public static int deleteUser(UserModel userModel) {
		int result = 0;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/braingain", "root", "root");
			String sql = "delete from users where emailid=?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);

			preparedStatement.setString(1, userModel.getEmailId());

			result = preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}


}
