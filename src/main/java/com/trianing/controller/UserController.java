package com.trianing.controller;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.trianing.dao.UserDAO;
import com.trianing.models.UserModel;
import com.trianing.service.UserService;

@Path("/users")
public class UserController {
	UserService userService = new UserService();
	UserDAO userDAO = new UserDAO();

	@Path("/list")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserModel> getUsers() throws SQLException {
		return userService.getUsers();
	}

	@Path("/add")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String insertDataIntoUser(UserModel userModel) throws SQLException {
		return userService.insertDataIntoUser(userModel);
	}
	
	@Path("/update")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateUser(UserModel userModel) throws SQLException {
		return userService.updateUser(userModel);
	}
	
	@Path("/delete")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String deleteUser(UserModel userModel) throws SQLException {
		return userService.deleteUser(userModel);
	}
}
