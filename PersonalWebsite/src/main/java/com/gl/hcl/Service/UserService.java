package com.gl.hcl.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.hcl.DAO.UserDAO;
import com.gl.hcl.Model.User;

//user service
@Service
public class UserService implements IUserService {

	@Autowired
	UserDAO userDAO;

	// function for adding user
	public void addUser(User p) {

		userDAO.addUser(p);

	}

	// function to getting user by their id
	public User getUserByID(int id) {

		return userDAO.getUserByID(id);
	}

	// function to get user base on personal id
	public User getUserByPersonalID(long personal_id) {

		return userDAO.getUserByPersonalID(personal_id);
	}

	// function to update user
	public User updateUser(User user) {

		return userDAO.updateUser(user);
	}

	// function to delete user
	public void delete_resume(int user_id) {

		userDAO.delete_resume(user_id);
	}

}
