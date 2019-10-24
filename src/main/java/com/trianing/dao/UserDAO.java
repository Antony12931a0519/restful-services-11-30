package com.trianing.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.trianing.models.UserModel;
import com.trianing.utility.DBConnection;

public class UserDAO {

	public int insertDataIntoUser(UserModel userModel) {
		return DBConnection.insertDataIntoUser(userModel);
	}

	public int updateUser(UserModel userModel) {
		return DBConnection.updateUser(userModel);
	}

	public int deleteUser(UserModel userModel) {
		return DBConnection.deleteUser(userModel);
	}

	public List<UserModel> getUsersList() throws SQLException {

		List<UserModel> users = new ArrayList<UserModel>();

		ResultSet rs = DBConnection.getUsersDateFromDb();

		while (rs.next()) {

			UserModel user = new UserModel();
			user.setEmailId(rs.getString("EmailId"));

			users.add(user);

		}

		return users;
	}

}
