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

	public UserModel getUserDetailsById(String emailId) throws SQLException {

		return userDAO.getUserDetailsById(emailId);
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
			return "User details are updated.";
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

	public String updateUserById(UserModel userModel, String emailId) {

		int res = userDAO.updateUserById(userModel, emailId);
		if (res != 0)
			return "User details are updated.";
		else
			return "User details are failed to  update.";

	}

	public String deleteUserById(String emailId) {

		int res = userDAO.deleteUserById(emailId);
		if (res != 0)
			return "User details are deleted.";
		else
			return "User details are failed to  delete.";

	}

}
