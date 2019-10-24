package com.trianing.service;

import java.sql.SQLException;
import java.util.List;

import com.trianing.dao.UserDAO;
import com.trianing.models.UserModel;

public class UserService {
	// creation of object
	UserDAO userDAO = new UserDAO();

	public List<UserModel> getUsers() throws SQLException {

		return userDAO.getUsersList();
	}

	public String insertDataIntoUser(UserModel userModel) {

		int res = userDAO.insertDataIntoUser(userModel);
		if (res != 0)
			return "Students details are added.";
		else
			return "Students details are failed to  add.";

	}
	
	public String updateUser(UserModel userModel) {

		int res = userDAO.updateUser(userModel);
		if (res != 0)
			return "User details are update.";
		else
			return "User details are failed to  update.";

	}
	
	public String deleteUser(UserModel userModel) {

		int res = userDAO.deleteUser(userModel);
		if (res != 0)
			return "User details are deleted.";
		else
			return "User details are failed to  delete.";

	}

}
